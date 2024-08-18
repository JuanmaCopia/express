package express.compile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class InMemoryCompiler {
    private final JavaCompiler compiler;
    private final InMemoryFileManager fileManager;
    private final InMemoryClassLoader classLoader;
    private final Map<String, JavaFileObject> sourceFiles = new HashMap<>();
    private final Map<String, ByteArrayJavaFileObject> compiledClasses = new HashMap<>();

    public InMemoryCompiler() {
        this.compiler = ToolProvider.getSystemJavaCompiler();
        this.fileManager = new InMemoryFileManager(compiler.getStandardFileManager(null, null, null));
        this.classLoader = new InMemoryClassLoader();
    }

    // Add or update source code
    public void addSource(String className, String sourceCode) {
        JavaFileObject sourceFile = new InMemoryJavaFileObject(className, sourceCode);
        sourceFiles.put(className, sourceFile);
    }

    public void addSource(Map<String, String> sourceCodeMap) {
        for (Map.Entry<String, String> entry : sourceCodeMap.entrySet()) {
            addSource(entry.getKey(), entry.getValue());
        }
    }

    // Compile the source files
    public boolean compile() {
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                diagnostics, null, null, sourceFiles.values());

        boolean success = task.call();
        if (!success) {
            diagnostics.getDiagnostics().forEach(d -> System.out.println(d.toString()));
        }

        return success;
    }

    // Compile a single new class
    public boolean compileSingleClass(String className, String sourceCode) {
        JavaFileObject sourceFile = new InMemoryJavaFileObject(className, sourceCode);
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                diagnostics, null, null, java.util.Collections.singletonList(sourceFile));

        boolean success = task.call();
        if (!success) {
            diagnostics.getDiagnostics().forEach(d -> System.out.println(d.toString()));
        } else {
            sourceFiles.put(className, sourceFile); // Add to sourceFiles if compilation is successful
        }

        return success;
    }

    // Load or reload a compiled class
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return classLoader.loadClass(className);
    }

    private static class InMemoryJavaFileObject extends SimpleJavaFileObject {
        private final String sourceCode;

        public InMemoryJavaFileObject(String className, String sourceCode) {
            super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension),
                    Kind.SOURCE);
            this.sourceCode = sourceCode;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return sourceCode;
        }
    }

    private class InMemoryClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            ByteArrayJavaFileObject fileObject = compiledClasses.get(name);
            if (fileObject != null) {
                byte[] bytes = fileObject.getBytes();
                return defineClass(name, bytes, 0, bytes.length);
            }
            return super.findClass(name);
        }
    }

    private static class ByteArrayJavaFileObject extends SimpleJavaFileObject {
        private final ByteArrayOutputStream outputStream;

        public ByteArrayJavaFileObject(String className, Kind kind) {
            super(URI.create("mem:///" + className.replace('.', '/') + kind.extension), kind);
            this.outputStream = new ByteArrayOutputStream();
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            return outputStream;
        }

        public byte[] getBytes() {
            return outputStream.toByteArray();
        }
    }

    private class InMemoryFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
        protected InMemoryFileManager(StandardJavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,
                FileObject sibling) throws IOException {
            ByteArrayJavaFileObject fileObject = new ByteArrayJavaFileObject(className, kind);
            compiledClasses.put(className, fileObject);
            return fileObject;
        }

        @Override
        public ClassLoader getClassLoader(Location location) {
            return classLoader;
        }

        @Override
        public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind)
                throws IOException {
            JavaFileObject fileObject = sourceFiles.get(className);
            if (fileObject != null) {
                return fileObject;
            }
            return super.getJavaFileForInput(location, className, kind);
        }

        @Override
        public Iterable<JavaFileObject> list(Location location, String packageName,
                java.util.Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
            Iterable<JavaFileObject> result = super.list(location, packageName, kinds, recurse);
            if (location == StandardLocation.CLASS_PATH && kinds.contains(JavaFileObject.Kind.CLASS)) {
                Map<String, JavaFileObject> allClasses = new HashMap<>(compiledClasses);
                allClasses.putAll(sourceFiles);
                return allClasses.values();
            }
            return result;
        }

        @Override
        public String inferBinaryName(Location location, JavaFileObject file) {
            if (file instanceof InMemoryJavaFileObject) {
                String uri = file.toUri().toString();
                return uri.substring(uri.indexOf(":///") + 4, uri.lastIndexOf('.')).replace('/', '.');
            }
            return super.inferBinaryName(location, file);
        }
    }

    public static void main(String[] args) throws Exception {
        InMemoryCompiler compiler = new InMemoryCompiler();

        String className = "HelloWorld";
        String sourceCode = """
                public class HelloWorld {
                    public String greet() {
                        Helper helper = new Helper();
                        System.out.println(helper.help());
                        return "Hello, World!";
                    }
                }
                """;

        String helperClassName = "Helper";
        String helpersource = """
                public class Helper {
                    public String help() {
                        return "I'm here to help!";
                    }
                }
                """;

        compiler.addSource(className, sourceCode);
        compiler.addSource(helperClassName, helpersource);
        if (compiler.compile()) {
            Class<?> cls = compiler.loadClass(className);
            Method method = cls.getDeclaredMethod("greet");
            System.out.println(method.invoke(cls.getDeclaredConstructor().newInstance()));
        }

        // Recompile with modified source code
        String className2 = className + "2";
        String modifiedSourceCode = """
                public class HelloWorld2 {
                    public String sayHi() {
                        Helper helper = new Helper();
                        System.out.println(helper.help());
                        return "Hello, Universe!";
                    }
                }
                """;

        // compiler.addSource(className2, modifiedSourceCode);
        // if (compiler.compile()) {
        // Class<?> cls = compiler.loadClass(className2);
        // Method method = cls.getDeclaredMethod("sayHi");
        // System.out.println(method.invoke(cls.getDeclaredConstructor().newInstance()));
        // }

        if (compiler.compileSingleClass(className2, modifiedSourceCode)) {
            Class<?> cls = compiler.loadClass(className2);
            Method method = cls.getDeclaredMethod("sayHi");
            System.out.println(method.invoke(cls.getDeclaredConstructor().newInstance()));
        }
    }
}
