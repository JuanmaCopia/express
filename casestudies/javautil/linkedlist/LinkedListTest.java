package casestudies.javautil.linkedlist;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test0() {
        LinkedList<Integer> l = new LinkedList<Integer>();
    }

    @Test
    public void test1() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(5);
    }

    @Test
    public void test2() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
    }

    @Test
    public void test3() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
    }

    @Test
    public void test4() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
    }

    @Test
    public void test5() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
    }

    @Test
    public void test6() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
    }

    @Test
    public void test7() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
        l.add(6);
    }

}
