#!/bin/bash

# Build the project without running tests
./gradlew build -x test

CASE_STUDY=$1

TREEMAP_PLI="src/main/resources/examples/treemap/treemap.properties"
SCHEDULE_PLI="src/main/resources/examples/schedule/schedule.properties"
HASHMAP_PLI="src/main/resources/examples/hashmap/hashmap.properties"
LINKEDLIST_PLI="src/main/resources/examples/linkedlist/linkedlist.properties"
TREESET_PLI="src/main/resources/examples/treeset/treeset.properties"
AVLTREE_PLI="src/main/resources/examples/avltree/avltree.properties"
BINOMIALHEAP_PLI="src/main/resources/examples/binomialheap/binomialheap.properties"
TRANSPORTSTATS_PLI="src/main/resources/examples/transportstats/transportstats.properties"

# Create the output and output/out directories if they don't exist
mkdir -p output/out

./gradlew run --args="$TREEMAP_PLI" > output/out/TREEMAP_PLI
./gradlew run --args="$SCHEDULE_PLI" > output/out/SCHEDULE_PLI
./gradlew run --args="$HASHMAP_PLI" > output/out/HASHMAP_PLI
./gradlew run --args="$LINKEDLIST_PLI" > output/out/LINKEDLIST_PLI
./gradlew run --args="$TREESET_PLI" > output/out/TREESET_PLI
./gradlew run --args="$AVLTREE_PLI" > output/out/AVLTREE_PLI
./gradlew run --args="$BINOMIALHEAP_PLI" > output/out/BINOMIALHEAP_PLI
./gradlew run --args="$TRANSPORTSTATS_PLI" > output/out/TRANSPORTSTATS_PLI