package examples.iterableexample;

import org.junit.Test;

public class IterableExampleTest {

    @Test
    public void test0() {
        IterableExample t = new IterableExample();
    }

    @Test
    public void test1() {
        IterableExample t = new IterableExample();
        t.addNode(5);
    }

    @Test
    public void test2() {
        IterableExample t = new IterableExample();
        t.addNode(1);
        t.addNode(2);
    }

    @Test
    public void test3() {
        IterableExample t = new IterableExample();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
    }

    @Test
    public void test4() {
        IterableExample t = new IterableExample();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
    }

    @Test
    public void test5() {
        IterableExample t = new IterableExample();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
        t.addNode(4);
    }

    @Test
    public void test6() {
        IterableExample t = new IterableExample();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
        t.addNode(4);
        t.addNode(5);
    }

    @Test
    public void test7() {
        IterableExample t = new IterableExample();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
        t.addNode(4);
        t.addNode(5);
        t.addNode(6);
        t.addNode(0);
        t.addNode(40);
        t.addNode(23);
        t.addNode(61);
    }

}
