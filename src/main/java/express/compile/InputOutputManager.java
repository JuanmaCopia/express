package express.compile;

import express.config.Config;
import express.util.Utils;
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
    URLClassLoader classLoader;

    File outputBinPath;
    File outputSrcPath;
    URL outputBinURL;

    public InputOutputManager(Launcher launcher, Config config, CtPackage subjectPackage) {
        this.config = config;
        this.launcher = launcher;
        this.outputBinPath = Utils.createDirectory(config.outputBinPath);
        this.outputSrcPath = Utils.createDirectory(config.outputSrcPath);
        this.outputBinURL = Utils.createURL(this.outputBinPath);
        this.classLoader = Utils.createClassLoader(this.outputBinURL);
    }

    public void generatePredicateSourceFiles(CtClass<?> cls) {
        CtClass<?> clsClone = cls.clone();
        clsClone.setSimpleName(config.predicateClassName);
        removeComments(clsClone);
        try {
            launcher.getModelBuilder().generateProcessedSourceFiles(OutputType.CLASSES);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

//    public Compiler getCompiler() {
//        return compiler;
//    }

//    public URLClassLoader getClassLoader() {
//        return classLoader;
//    }
}
