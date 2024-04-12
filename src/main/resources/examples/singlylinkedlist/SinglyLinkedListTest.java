package examples.singlylinkedlist;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test
    public void test0() {
        SinglyLinkedList l = new SinglyLinkedList();
    }

    @Test
    public void test1() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(6);
    }

    @Test
    public void test2() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(3);
    }

    @Test
    public void test3() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
    }

    @Test
    public void test4() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(5);
    }

    @Test
    public void test5() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(5);
        l.addLast(10);
    }

    @Test
    public void test6() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(5);
        l.addLast(10);
        l.addLast(0);
    }

    @Test
    public void test7() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(5);
        l.addLast(10);
        l.addLast(0);
        l.addLast(7);
    }

    @Test
    public void test8() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(5);
        l.addLast(10);
        l.addLast(0);
        l.addLast(7);
        l.addLast(1);
    }

    @Test
    public void test9() {
        SinglyLinkedList l = new SinglyLinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(5);
        l.addLast(10);
        l.addLast(0);
        l.addLast(7);
        l.addLast(1);
        l.addLast(-1);
    }


}