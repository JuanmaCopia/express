#!/bin/bash

# Build the project without running tests
./gradlew build -x test

TREEMAP_PLI="casestudies/pli/treemap/treemap.properties"
SCHEDULE_PLI="casestudies/pli/schedule/schedule.properties"
HASHMAP_PLI="casestudies/pli/hashmap/hashmap.properties"
LINKEDLIST_PLI="casestudies/pli/linkedlist/linkedlist.properties"
AVLTREE_PLI="casestudies/pli/avltree/avltree.properties"
BINOMIALHEAP_PLI="casestudies/pli/binomialheap/binomialheap.properties"

NCLL_APACHE="casestudies/apache/nodecachinglinkedlist/nodecachinglinkedlist.properties"

# Create the output and output/out directories if they don't exist
mkdir -p output/out

echo "Running all cases, the terminal output for each case will be stored in the folder output/out"

echo "Running TREEMAP_PLI case..."
./gradlew run --args="$TREEMAP_PLI" > output/out/TREEMAP_PLI
echo "Running SCHEDULE_PLI case..."
./gradlew run --args="$SCHEDULE_PLI" > output/out/SCHEDULE_PLI
echo "Running LINKEDLIST_PLI case..."
./gradlew run --args="$LINKEDLIST_PLI" > output/out/LINKEDLIST_PLI
echo "Running AVLTREE_PLI case..."
./gradlew run --args="$AVLTREE_PLI" > output/out/AVLTREE_PLI
echo "Running BINOMIALHEAP_PLI case..."
./gradlew run --args="$BINOMIALHEAP_PLI" > output/out/BINOMIALHEAP_PLI
echo "Running HASHMAP_PLI case..."
./gradlew run --args="$HASHMAP_PLI" > output/out/HASHMAP_PLI

echo "Running NCLL_APACHE case..."
./gradlew run --args="$NCLL_APACHE" > output/out/NCLL_APACHE
