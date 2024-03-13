package examples;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    void test0() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    }

    @Test
    void test1() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(5);
    }

    @Test
    void test2() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
    }

    @Test
    void test3() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
    }

    @Test
    void test4() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);
    }

    @Test
    void test5() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(4);
    }

    @Test
    void test6() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(5);
    }

    @Test
    void test7() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(6);
    }

}
