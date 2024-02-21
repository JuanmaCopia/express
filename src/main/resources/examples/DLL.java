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
        Set<Node> visited = new HashSet<Node>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (!visited.add(current)) {
                return false;
            }
            if (prev != current.back) {
                return false;
            }
            prev = current;
            current = current.next;
        }
        if (prev != tail) {
            return false;
        }
        return true;
    }

    private class Node {
        int data;
        Node next;
        Node back;
    }


}
