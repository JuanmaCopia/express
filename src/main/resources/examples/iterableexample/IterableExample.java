package examples.iterableexample;

import java.util.LinkedList;

public class IterableExample {

    LinkedList<IterNode> list = new LinkedList<>();

    public IterableExample() {
    }

    public void addNode(int value) {
        list.add(new IterNode(value));
    }

    public static class IterNode {
        public int value;
        public IterNode next;

        public IterNode(int value) {
            this.value = value;
        }
    }
}
