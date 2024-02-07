# EvoRep

EvoRep is a tool that automatically generates class invariants in the form of executable properties, also known as RepOK
methods. EvoRep uses a Genetic Algorithm to evolve a population of candidate RepOK methods. Mutations are either based
on static analysis of the subject or proposed by Large Language Models (LLMs). The individuals are evaluated using a
fitness function that is based on the number of valid and invalid instances that is able to detect.

## Getting Started

Clone the repository:

```
git clone git@github.com:JuanmaCopia/spf-pli.git
```

Move to the folder:

```
cd evorep
```

Build:

```
./gradlew build
```

Run:

```
./gradlew run
```

The main class is `evorep.Evorep`.

## Parameter Configuration

The parameters of the tool can be configured in the file `config.properties`.

Available parameters:

```
app.srcpath   = <PATH_TO_SRC>
app.binpath   = <PATH_TO_BIN_FOLDER>
app.classname = <FULLY_QUALIFIED_CLASS_NAME>
```

`app.srcpath` is the path to the source code of the subject.
`app.binpath` is the path to the binary folder of the subject. (Not used yet)
`app.classname` is the fully qualified name of the class for which the RepOK method will be generated.

## Case Studies

The source code of the case studies can be found under the `src/main/resources` folder.
