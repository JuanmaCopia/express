# EvoExpress: Evolving Executable Preconditions for Software Systems

EvoExpress is a tool that automatically generates method preconditions in the form of executable properties.
EvoExpress uses Genetic Programming to evolve a population of candidate method preconditions. Mutations are either based
on static analysis of the subject or proposed by Large Language Models (LLMs). The individuals are evaluated using a
fitness function that is based on the number of valid and invalid instances that is able to detect.

## Getting Started

Clone the repository:

```
git clone git@github.com:JuanmaCopia/evoexpress.git
```

Move to the folder:

```
cd evoexpress
```

Build:

```
./gradlew build
```

Run:

```
./gradlew run
```

The main class is `evoexpress.Evorep`.

## Parameter Configuration

The parameters of the tool can be configured in the file `config.properties`.

Available parameters:

```
evoexpress.src_path   = <PATH_TO_SRC>
evoexpress.bin_path   = <PATH_TO_BIN_FOLDER>
evoexpress.class_name = <FULLY_QUALIFIED_CLASS_NAME>
evoexpress.src_java_version = <JAVA_VERSION_OF_SOURCE_CODE>
evoexpress.max_population = <POPULATION_SIZE>
evoexpress.max_generations = <NUMBER_OF_GENERATIONS>
```

`evoexpress.src_path` is the path to the source code of the subject.

`evoexpress.bin_path` is the path to the binary folder of the subject. (Not used yet)

`evoexpress.class_name` is the fully qualified name of the class for which the RepOK method will be generated.

`evoexpress.src_java_version` is the version of the source code.

`evoexpress.max_population` is the maximum number of individuals in the population.

`evoexpress.max_generations` is the maximum number of generations to be performed.

## Case Studies

The source code of the case studies can be found under the `src/main/resources` folder.
