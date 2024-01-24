
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class ClassExample {

    public Node head;
    public int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean emptyMethod() {
        return true;
    }

    public boolean localVarMethod() {
        Node curr = head;
        return true;
    }

    public boolean visitedSetMethod() {
        Node curr = head;
        Set<Node> visited = new HashSet<>();
        while (curr != null) {
            curr = curr.next;
        }
        return true;
    }

}
