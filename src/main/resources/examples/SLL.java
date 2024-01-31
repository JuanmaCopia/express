package examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SLL {

    public List<Integer> list = new ArrayList<>();
    public Node head;
    public int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean traverse() {
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
        }
        return true;
    }

    public boolean structureRepOK() {
        Set<Node> visited = new HashSet<>();
        visited.add(head);
        Node curr = head;
        while (curr != null) {
            if (curr.next != null && !visited.add(curr.next)) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public boolean structureRepOK2() {
        Set<Node> visited = new HashSet<>();
        visited.add(head);
        Node curr = head;
        while (curr != null) {
            if (curr.next != null) {
                if (!visited.add(curr.next)) {
                    return false;
                }
            }
            curr = curr.next;
        }
        return true;
    }

    public boolean mymethod2() {
        return true;
    }

    public boolean mymethod3() {
        Set<Node> visited = new HashSet<>();
        Node current = head;
        return true;
    }

    public boolean mymethod4() {
        Set<Node> visited = new HashSet<>();
        visited.add(head);
        Node curr = head;
        while (curr != null) {
            Node shouldNotBeVisible = curr.next;
            if (curr.next != null && !visited.add(curr.next)) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

}
