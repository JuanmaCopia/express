package evoexpress.compile;

import evoexpress.config.Config;
import evoexpress.util.Utils;
import spoon.Launcher;
import spoon.OutputType;
import spoon.reflect.code.CtComment;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtPackage;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Objects;

public class InputOutputManager {

    Config config;

    Launcher launcher;
    Compiler compiler;
    URLClassLoader classLoader;

    File outputBinPath;
    File outputSrcPath;
    URL outputBinURL;

    public InputOutputManager(Launcher launcher, Config config, CtPackage subjectPackage) {
        this.config = config;
        this.launcher = launcher;
        this.compiler = new Compiler(launcher, subjectPackage);
        this.outputBinPath = Utils.createDirectory(config.outputBinPath);
        this.outputSrcPath = Utils.createDirectory(config.outputSrcPath);
        this.outputBinURL = Utils.createURL(this.outputBinPath);
        this.classLoader = Utils.createClassLoader(this.outputBinURL);
    }

    public void generateSourcePreconditionSourceFile(CtClass<?> cls) {
        CtClass<?> clsClone = cls.clone();
        clsClone.setSimpleName(config.preconditionClassName);
        removeComments(clsClone);
        compiler.addClassToPackage(clsClone);
        try {
            launcher.getModelBuilder().generateProcessedSourceFiles(OutputType.CLASSES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        compiler.removeClassFromPackage(clsClone);
    }

    private void removeComments(CtClass<?> cls) {
        List<CtComment> comments = cls.getElements(Objects::nonNull);
        for (CtComment comment : comments)
            comment.delete();
    }

    public File getOutputBinPath() {
        return outputBinPath;
    }

    public File getOutputSrcPath() {
        return outputSrcPath;
    }

    public URL getOutputBinURL() {
        return outputBinURL;
    }

    public Compiler getCompiler() {
        return compiler;
    }

    public URLClassLoader getClassLoader() {
        return classLoader;
    }
}
