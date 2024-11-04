#!/bin/bash

# Build the project without running tests
./gradlew build -x test

CASE_STUDY=$1

TREEMAP_PLI="casestudies/pli/treemap/treemap.properties"
SCHEDULE_PLI="casestudies/pli/schedule/schedule.properties"
HASHMAP_PLI="casestudies/pli/hashmap/hashmap.properties"
LINKEDLIST_PLI="casestudies/pli/linkedlist/linkedlist.properties"
TREESET_PLI="casestudies/pli/treeset/treeset.properties"
AVLTREE_PLI="casestudies/pli/avltree/avltree.properties"
BINOMIALHEAP_PLI="casestudies/pli/binomialheap/binomialheap.properties"

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