package examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DLL {

    Node head;
    Node tail;
    int size;

    private class Node {
        int data;
        Node next;
    }

    public boolean repOKStructure() {
        Set<Node> visited = new HashSet<Node>();
        LinkedList<Node> worklist = new LinkedList<Node>();
        worklist.add(head);
        while (!worklist.isEmpty()) {
            Node current = worklist.removeFirst();
            if (current == null) {
                continue;
            }
            if (!visited.add(current)) {
                return false;
            }
            worklist.add(current.next);
        }
        return true;
    }

}
