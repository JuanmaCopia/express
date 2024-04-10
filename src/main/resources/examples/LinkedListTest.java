package examples;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void test0() {
        LinkedList l = new LinkedList();
    }

    @Test
    public void test1() {
        LinkedList l = new LinkedList();
        l.add(5);
    }

    @Test
    public void test2() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
    }

    @Test
    public void test3() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
    }

    @Test
    public void test4() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
    }

    @Test
    public void test5() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
    }

    @Test
    public void test6() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
    }

    @Test
    public void test7() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
        l.add(6);
    }

}
