package examples.bintree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BinTree {

    BTNode root;
    int size;

    public BinTree() {
        root = null;
        size = 0;
    }

    public void addNode(int value) {
        BTNode newNode = new BTNode();
        newNode.data = value;
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        LinkedList<BTNode> worklist = new LinkedList<>();
        worklist.add(root);
        while (!worklist.isEmpty()) {
            BTNode current = worklist.removeFirst();
            if (current.left == null) {
                current.left = newNode;
                size++;
                return;
            } else {
                worklist.add(current.left);
            }
            if (current.right == null) {
                current.right = newNode;
                size++;
                return;
            } else {
                worklist.add(current.right);
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (root == null) {
            return "\nEmpty tree, size: " + size + "\n";
        } else {
            sb.append("\nRoot: " + root.data + "\n");
        }
        Set<BTNode> visited_0 = new HashSet<BTNode>();
        LinkedList<BTNode> worklist_0 = new LinkedList<BTNode>();
        worklist_0.add(root);
        String indent = "  ";
        while (!worklist_0.isEmpty()) {
            BTNode current_0 = worklist_0.removeFirst();

            indent += "  ";

            if (current_0.left != null) {
                sb.append(indent + current_0.left.data + "\n");
                if (visited_0.add(current_0.left)) {
                    worklist_0.add(current_0.left);
                } else {
                    sb.append(indent + " Cycle!\n");
                }

            } else {
                sb.append(indent + "null\n");
            }
            if (current_0.right != null) {
                sb.append(indent + current_0.right.data + "\n");
                if (visited_0.add(current_0.right)) {
                    worklist_0.add(current_0.right);
                } else {
                    sb.append(indent + " Cycle!\n");
                }

            } else {
                sb.append(indent + "null\n");
            }
        }
        sb.append("\n Size: " + size + "\n");
        return sb.toString();
    }

    public static class BTNode {
        int data;
        BTNode left;
        BTNode right;

        public BTNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
    }

/*    public class BTNode {
        int data;
        BTNode left;
        BTNode right;
    }*/

}
