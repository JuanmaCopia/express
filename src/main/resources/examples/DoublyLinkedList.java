package examples;

import java.util.HashSet;
import java.util.Set;

class DoublyLinkedList {

    Node head;
    Node tail;
    int size;


    public void addNode(int data) {
        Node newNode = new Node(data);
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
        if (head == null) {
            return tail == null;
        }
        if (tail == null) {
            return false;
        }
        if (head.prev != null) {
            return false;
        }
        if (tail.next != null) {
            return false;
        }
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
        // Visited Check
        if (visited.size() != size)
            return false;
        return true;
    }

    //A node class for doubly linked list
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
