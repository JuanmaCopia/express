package examples;

import java.util.HashSet;
import java.util.Set;

public class DoublyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public boolean repOKStructure() {
        if (head == null && tail != null) {
            return false
        }
        if (head != null && tail == null) {
            return false
        }
        /* End of Initial Checks */
        Set<Node> visited = new HashSet<Node>();
        /* Initialize root element: */
        Node current_0 = head;
        /* Cycle over cyclic references: */
        while (current_0 != null) {
            if (!visited.add(current_0)) {
                return false;
            }
            /* Handle current: */
            if (current_0.prev != null && current_0.prev.next != current_0) {
                return false;
            }
            if (current_0 == tail && current_0.next != null) {
                return false;
            }
            /* End of Handle current: */
            current_0 = current_0.next;
        }
        /* Size check */
        if (visited.size() != size)
            return false;
        return true;
    }

    public void mymethod() {

    }

    public static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node() {
        }

    }
}
