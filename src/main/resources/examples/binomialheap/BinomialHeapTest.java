package examples.binomialheap;

import org.junit.Test;

public class BinomialHeapTest {

    @Test
    public void test0() {
        BinomialHeap t = new BinomialHeap();
    }

    @Test
    public void test1() {
        BinomialHeap t = new BinomialHeap();
        t.insert(5);
    }

    @Test
    public void test2() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
    }

    @Test
    public void test3() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
    }

    @Test
    public void test4() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
    }

    @Test
    public void test5() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
    }

    @Test
    public void test6() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(5);
    }

    @Test
    public void test7() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(0);
        t.insert(40);
        t.insert(23);
        t.insert(61);
    }

}
