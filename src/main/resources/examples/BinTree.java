package examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BinTree {

    BTNode root;
    int size;

    class BTNode {
        int data;
        BTNode left;
        BTNode right;
    }

    public boolean repOKStructure() {
        Set<BTNode> visited = new HashSet<BTNode>();
        LinkedList<BTNode> worklist = new LinkedList<BTNode>();
        worklist.add(root);
        while (!worklist.isEmpty()) {
            BTNode current = worklist.removeFirst();
            if (current == null) {
                continue;
            }
            if (!visited.add(current)) {
                return false;
            }
            worklist.add(current.left);
            worklist.add(current.right);
        }
        return true;
    }

}
