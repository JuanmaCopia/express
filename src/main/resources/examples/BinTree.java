package examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BinTree {

    BTNode root;
    int size;

    public boolean repOKStructure() {
        if (root == null)
            return true;
        Set<BTNode> visited = new HashSet<BTNode>();
        LinkedList<BTNode> worklist = new LinkedList<BTNode>();
        worklist.add(root);
        while (!worklist.isEmpty()) {
            BTNode current = worklist.removeFirst();
            if (!visited.add(current)) {
                return false;
            }
            if (current.left != null) {
                worklist.add(current.left);
            }
            if (current.right != null) {
                worklist.add(current.right);
            }
        }
        return true;
    }

    class BTNode {
        int data;
        BTNode left;
        BTNode right;
    }

}
