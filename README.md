# EvoRep

EvoRep is a tool that automatically generates class invariants in the form of executable properties, also known as RepOK
methods. EvoRep uses a Genetic Algorithm to evolve a population of candidate RepOK methods. Mutations are either based
on static analysis of the subject or proposed by Large Language Models (LLMs). The individuals are evaluated using a
fitness function that is based on the number of valid and invalid instances that is able to detect.

## Getting Started

Clone the repository:

```
git clone git@github.com:JuanmaCopia/evorep.git
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
evorep.src_path   = <PATH_TO_SRC>
evorep.bin_path   = <PATH_TO_BIN_FOLDER>
evorep.class_name = <FULLY_QUALIFIED_CLASS_NAME>
evorep.src_java_version = <JAVA_VERSION_OF_SOURCE_CODE>
evorep.max_population = <POPULATION_SIZE>
evorep.max_generations = <NUMBER_OF_GENERATIONS>
```

`evorep.src_path` is the path to the source code of the subject.

`evorep.bin_path` is the path to the binary folder of the subject. (Not used yet)

`evorep.class_name` is the fully qualified name of the class for which the RepOK method will be generated.

`evorep.src_java_version` is the version of the source code.

`evorep.max_population` is the maximum number of individuals in the population.

`evorep.max_generations` is the maximum number of generations to be performed.

## Case Studies

The source code of the case studies can be found under the `src/main/resources` folder.
