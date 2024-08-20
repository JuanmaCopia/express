package express.compile;

import express.config.Config;
import express.spoon.SpoonHelper;
import express.spoon.SpoonManager;
import express.util.Utils;
import spoon.Launcher;
import spoon.OutputType;
import spoon.reflect.declaration.CtClass;
import spoon.support.compiler.VirtualFile;

import java.io.File;
import java.net.URL;

public class InputOutputManager {

    Config config;
    File outputBinPath;
    File outputSrcPath;
    URL outputBinURL;

    public InputOutputManager(Config config) {
        this.config = config;
        this.outputBinPath = Utils.createDirectory(config.outputBinPath);
        this.outputSrcPath = Utils.createDirectory(config.outputSrcPath);
        this.outputBinURL = Utils.createURL(outputBinPath);
    }

    public void generatePredicateSourceFiles(CtClass<?> cls) {
        CtClass<?> clsClone = cls.clone();
        clsClone.setSimpleName(config.predicateClassName);
        SpoonManager.addClassToMainPackage(clsClone);
        SpoonHelper.removeComments(clsClone);
        String sourceCode = SpoonManager.getPrettyPrintedSourceCode(clsClone);
        SpoonManager.removeClassFromMainPackage(clsClone);

        try {
            Launcher l = new Launcher();
            VirtualFile virtualFile = new VirtualFile(sourceCode, config.predicateClassName + ".java");

            l.addInputResource(config.subjectSrcPath);
            l.addInputResource(virtualFile);

            l.getEnvironment().setComplianceLevel(config.subjectSrcJavaVersion);
            l.getEnvironment().setShouldCompile(false);
            l.getEnvironment().setAutoImports(true);

            l.setBinaryOutputDirectory(outputBinPath);
            l.setSourceOutputDirectory(outputSrcPath);
            l.buildModel();

            l.getModelBuilder().generateProcessedSourceFiles(OutputType.CLASSES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
