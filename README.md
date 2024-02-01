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

## Parameter Configuration

The parameters of the tool can be configured in the file `config.properties`.