# EvoExpress: Evolving Executable Preconditions for Software Systems

EvoExpress is a tool that automatically generates method preconditions in the form of executable routines.
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

Example of BinTree case study configuration:

```
# Subject Settings:
evoexpress.subject.src_path=./src/main/resources/examples/bintree
evoexpress.subject.test_src_path=./src/main/resources/examples/bintree
evoexpress.subject.class_name=examples.bintree.BinTree
evoexpress.subject.test_suite_class_name=examples.bintree.BinTreeTest
evoexpress.subject.method_name=size
evoexpress.subject.src_java_version=17
# Output Settings:
evoexpress.output.bin_path=./output/bin
evoexpress.output.src_path=./output/src
evoexpress.output.precondition_class_name=Precondition
evoexpress.output.precondition_method_name=precondition
# Search Settings:
evoexpress.search.max_population=7
evoexpress.search.max_generations=600
evoexpress.search.elitism=1
evoexpress.search.mutation_rate=1.0
evoexpress.search.crossover_rate=1.0
# Object Settings
evoexpress.object.max_mutations_per_instance=7
# Fitness Settings:
evoexpress.fitness.timeout_ms=300
```

## Case Studies

The source code of the case studies can be found under the `src/main/resources` folder.
