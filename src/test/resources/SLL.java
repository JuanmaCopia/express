import java.util.HashSet;
import java.util.Set;

public class SLL {

    public Node head;
    public int size;

    public SLL() {
        head = null;
        size = 0;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }


    public boolean repOKStructure() {
        if (head == null) {
            return true;
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
            /* End of Handle current: */
            current_0 = current_0.next;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size: ").append(size).append("| ");
        Node current = head;
        if current == null) {
            return sb.append("NULL").toString();
        }
        Set<Node> visited = new HashSet<Node>();
        while (current != null) {
            if (!visited.add(current)) {
                sb.append("ALIAS TO: ").append(current.toString());
                return sb.toString();
            }
            sb.append(current.toString()).append(" -> ");
            current = current.next;
        }

        sb.append("NULL");
        return sb.toString();
    }

    public boolean m() {
        Node curr = head;
        return true;
    }

    public static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
