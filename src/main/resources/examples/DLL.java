package examples;

import java.util.HashSet;
import java.util.Set;

public class DLL {

    Node head;
    Node tail;
    int size;

    public boolean repOKStructure() {
        if (head == null) {
            return tail == null;
        }
        if (tail == null) {
            return false;
        }
        if (head.back != null) {
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
            if (current_0.back != null && current_0.back.next != current_0) {
                return false;
            }
            if (current_0 == tail && current_0.next != null) {
                return false;
            }
            /* End of Handle current: */
            current_0 = current_0.next;
        }
        return true;
    }

    private class Node {
        int data;
        Node next;
        Node back;
    }


}
