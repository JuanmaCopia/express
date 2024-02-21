package examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SLL {

    public Node head;
    public int size;

    public boolean repOKStructure() {
        if (head == null) {
            return true;
        }
        Set<Node> visited = new HashSet<Node>();
        LinkedList<Node> worklist = new LinkedList<Node>();
        /* Initialize root element: */
        Node current_0 = head;
        worklist.add(current_0);
        /* Cycle over cyclic references: */
        while (!worklist.isEmpty()) {
            current_0 = worklist.removeFirst();
            if (!visited.add(current_0)) {
                return false;
            }
            /* Handle current: */
            /* End of Handle current: */
            if (current_0.next != null) {
                worklist.add(current_0.next);
            }
        }
        return true;
    }

    /*
     * public boolean repOKStructure() {
     * if (head == null) {
     * return true;
     * }
     * Set<Node> visited = new HashSet<Node>();
     * LinkedList<Node> worklist = new LinkedList<Node>();
     * worklist.add(head);
     * while (!worklist.isEmpty()) {
     * Node current = worklist.removeFirst();
     * if (!visited.add(current)) {
     * return false;
     * }
     * if (current.next != null) {
     * worklist.add(current.next);
     * }
     * }
     * return true;
     * }
     */

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
