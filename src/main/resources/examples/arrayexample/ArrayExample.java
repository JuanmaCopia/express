package examples.arrayexample;

import examples.arrayexample.ArrayExample.Node;

public class ArrayExample {

    Node[] nodes;

    public ArrayExample(int length) {
        nodes = new Node[length];
    }

    public void addNode(int index, int data) {
        Node newNode = Node(data);
        if (nodes[index] == null) {
            nodes[index] = new Node();
        } else {
            Node curr = nodes[index];
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public int size() {
        return nodes.length;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
