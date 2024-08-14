# Express: Executable Predicate Search for Structural Constraints

Express is a tool that automatically generates predicates in the form of executable routines (java methods).
using search-based algorithms.

## Getting Started

Clone the repository:

```
git clone git@github.com:JuanmaCopia/express.git
```

Move to the folder:

```
cd express
```

Build:

```
./gradlew build
```

Run:

```
./gradlew run
```

The main class is `express.Evorep`.

## Parameter Configuration

The parameters of the tool can be configured in the file `config.properties`.

Example of BinTree case study configuration:

```
# Subject Settings:
express.subject.src_path=./src/main/resources/examples/schedule
express.subject.test_src_path=./src/main/resources/examples/schedule
express.subject.class_name=examples.schedule.Schedule
express.subject.test_suite_class_name=examples.schedule.ScheduleTest
express.subject.src_java_version=17
# Output Settings:
express.output.bin_path=./output/bin
express.output.src_path=./output/src
express.output.predicate_class_name=Predicate
express.output.predicate_method_name=predicate
# Search Settings:
express.search.sa.initial_temperature=7
express.search.sa.cooling_rate=0.004
express.search.sa.restart_rounds=200
# Object Settings:
express.object.max_mutations_per_instance=1
# Fitness Settings:
express.fitness.timeout_ms=300
```

## Case Studies

The source code of the case studies can be found under the `src/main/resources` folder.

## Output

The output can be found under the `output` folder.
