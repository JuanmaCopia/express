#!/bin/bash

CASE_STUDY=$1

echo "Running ${CASE_STUDY} case..."
case $CASE_STUDY in
    "TREEMAP_PLI")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.pli.treemap.TreeMapTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=TreeMapTest.decls-DynComp casestudies.pli.treemap.TreeMapTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants TreeMapTest.inv.gz --ppt-select 'casestudies.pli.treemap.TreeMap:::OBJECT' --format java > TreeMapDaikonInvariant.out
        echo "Invariant saved to TreeMapDaikonInvariant.out"
        ;;
    "SCHEDULE_PLI")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.pli.schedule.ScheduleTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=ScheduleTest.decls-DynComp casestudies.pli.schedule.ScheduleTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants ScheduleTest.inv.gz --ppt-select 'casestudies.pli.schedule.Schedule:::OBJECT' --format java > ScheduleDaikonInvariant.out
        echo "Invariant saved to ScheduleDaikonInvariant.out"
        ;;
    "HASHMAP_PLI")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.pli.hashmap.HashMapTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=HashMapTest.decls-DynComp casestudies.pli.hashmap.HashMapTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants HashMapTest.inv.gz --ppt-select 'casestudies.pli.hashmap.HashMap:::OBJECT' --format java > HashMapDaikonInvariant.out
        echo "Invariant saved to HashMapDaikonInvariant.out"
        ;;
    "LINKEDLIST_PLI")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.pli.linkedlist.LinkedListTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=LinkedListTest.decls-DynComp casestudies.pli.linkedlist.LinkedListTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants LinkedListTest.inv.gz --ppt-select 'casestudies.pli.linkedlist.LinkedList:::OBJECT' --format java > LinkedListDaikonInvariant.out
        echo "Invariant saved to LinkedListDaikonInvariant.out"
        ;;
    "AVLTREE_PLI")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.pli.avltree.AvlTreeTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=AvlTreeTest.decls-DynComp casestudies.pli.avltree.AvlTreeTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants AvlTreeTest.inv.gz --ppt-select 'casestudies.pli.avltree.AvlTree:::OBJECT' --format java > AvlTreeDaikonInvariant.out
        echo "Invariant saved to AvlTreeDaikonInvariant.out"
        ;;
    "BINOMIALHEAP_PLI")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.pli.binomialheap.BinomialHeapTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=BinomialHeapTest.decls-DynComp casestudies.pli.binomialheap.BinomialHeapTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants BinomialHeapTest.inv.gz --ppt-select 'casestudies.pli.binomialheap.BinomialHeap:::OBJECT' --format java > BinomialHeapDaikonInvariant.out
        echo "Invariant saved to BinomialHeapDaikonInvariant.out"
        ;;
    "NODECACHINGLINKEDLIST_APACHE")
        echo "Dynamic comparability analysis.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.DynComp casestudies.apache.nodecachinglinkedlist.NodeCachingLinkedListTest >/dev/null 2>&1
        echo "Inferring invariants.."
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.Chicory --daikon --comparability-file=NodeCachingLinkedListTest.decls-DynComp casestudies.apache.nodecachinglinkedlist.NodeCachingLinkedListTest >/dev/null 2>&1
        java -cp build/libs/express.jar:$DAIKONDIR/daikon.jar daikon.PrintInvariants NodeCachingLinkedListTest.inv.gz --ppt-select 'casestudies.apache.nodecachinglinkedlist.NodeCachingLinkedList:::OBJECT' --format java > NodeCachingLinkedListDaikonInvariant.out
        echo "Invariant saved to NodeCachingLinkedListDaikonInvariant.out"
        ;;
    *)
        echo ""
        echo "ERROR: Invalid CASE_STUDY argument"
        ;;
esac

# Clean up
rm *.inv.gz
rm *.dtrace.gz
rm *.decls-DynComp

# Move invariant to the right place
mkdir -p daikon-output
mv *DaikonInvariant.out daikon-output