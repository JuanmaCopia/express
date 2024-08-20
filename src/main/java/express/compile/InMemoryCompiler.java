package express.compile;

import express.spoon.SpoonManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

    private static final Logger logger = Logger.getLogger(InMemoryCompiler.class.getName());

    private final JavaCompiler compiler;
    private final InMemoryFileManager fileManager;
    private final InMemoryClassLoader classLoader;
    private final Map<String, JavaFileObject> sourceFiles = new HashMap<>();
    private final Map<String, ByteArrayJavaFileObject> compiledClasses = new HashMap<>();
    private List<String> classpath = new ArrayList<>();

    public InMemoryCompiler() {
        this.compiler = ToolProvider.getSystemJavaCompiler();
        this.fileManager = new InMemoryFileManager(compiler.getStandardFileManager(null, null, null));
        this.classLoader = new InMemoryClassLoader();
    }

    // Set the classpath for the compiler
    public void setClasspath(List<String> classpath) {
        this.classpath = classpath;
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
        List<String> options = new ArrayList<>();
        if (!classpath.isEmpty()) {
            options.add("-classpath");
            options.add(String.join(":", classpath));
        }

        // Print classpath for debugging
        //logger.info("Classpath: " + String.join(":", classpath));

        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                diagnostics, options, null, sourceFiles.values());

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
                // Combine the compiled classes, source files, and classes from classpath
                List<JavaFileObject> files = new ArrayList<>();
                compiledClasses.values().forEach(files::add);
                sourceFiles.values().forEach(files::add);
                result.forEach(files::add);
                return files;
            }
            return result;
        }

        @Override
        public String inferBinaryName(Location location, JavaFileObject file) {
            if (file instanceof InMemoryJavaFileObject) {
                String uri = file.toUri().toString();
                return uri.substring(uri.indexOf(":///") + 4, uri.lastIndexOf('.')).replace('/', '.');
            } else if (file instanceof ByteArrayJavaFileObject) {
                return file.getName().substring(1).replace('/', '.');
            }
            return super.inferBinaryName(location, file);
        }

    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

}
