#!/bin/bash

# Build the project without running tests
./gradlew build -x test

CASE_STUDY=$1

TREEMAP_PLI="casestudies/pli/treemap/treemap.properties"
SCHEDULE_PLI="casestudies/pli/schedule/schedule.properties"
SCHEDULE_ARRAY_PLI="casestudies/pli/schedulearray/schedulearray.properties"
HASHMAP_PLI="casestudies/pli/hashmap/hashmap.properties"
LINKEDLIST_PLI="casestudies/pli/linkedlist/linkedlist.properties"
TREESET_PLI="casestudies/pli/treeset/treeset.properties"
AVLTREE_PLI="casestudies/pli/avltree/avltree.properties"
BINOMIALHEAP_PLI="casestudies/pli/binomialheap/binomialheap.properties"

NODECACHINGLINKEDLIST_APACHE="casestudies/apache/nodecachinglinkedlist/nodecachinglinkedlist.properties"

LINKEDLIST_JAVAUTIL="casestudies/javautil/linkedlist/linkedlist.properties"
TREEMAP_JAVAUTIL="casestudies/javautil/treemap/treemap.properties"


case $CASE_STUDY in
    "TREEMAP_PLI")
        ./gradlew run --args="$TREEMAP_PLI"
        ;;
    "SCHEDULE_PLI")
        ./gradlew run --args="$SCHEDULE_PLI"
        ;;
    "SCHEDULE_ARRAY_PLI")
        ./gradlew run --args="$SCHEDULE_ARRAY_PLI"
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
    "NODECACHINGLINKEDLIST_APACHE")
        ./gradlew run --args="$NODECACHINGLINKEDLIST_APACHE"
        ;;
    "TREEMAP_JAVAUTIL")
        ./gradlew run --args="$TREEMAP_JAVAUTIL"
        ;;
    "LINKEDLIST_JAVAUTIL")
        ./gradlew run --args="$LINKEDLIST_JAVAUTIL"
        ;;
    *)
        echo ""
        echo "ERROR: Invalid CASE_STUDY argument"
        ;;
esac