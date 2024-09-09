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

case $CASE_STUDY in
    "TREEMAP_PLI")
        ./gradlew run --args="$TREEMAP_PLI"
        ;;
    "SCHEDULE_PLI")
        ./gradlew run --args="$SCHEDULE_PLI"
        ;;
    "HASHMAP_PLI")
        ./gradlew run --args="$HASHMAP_PLI"
        ;;
    "LINKEDLIST_PLI")
        ./gradlew run --args="$LINKEDLIST_PLI"
        ;;
    "TREESET_PLI")
        ./gradlew run --args="$TREESET_PLI"
        ;;
    "AVLTREE_PLI")
        ./gradlew run --args="$AVLTREE_PLI"
        ;;
    "BINOMIALHEAP_PLI")
        ./gradlew run --args="$BINOMIALHEAP_PLI"
        ;;
    "TRANSPORTSTATS_PLI")
        ./gradlew run --args="$TRANSPORTSTATS_PLI"
        ;;
    *)
        echo "Invalid CASE_STUDY value"
        ;;
esac