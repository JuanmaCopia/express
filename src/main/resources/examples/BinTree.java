package examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BinTree {

    BTNode root;
    int size;

    public boolean repOKStructure() {
        if (root == null) {
            return true;
        }
        Set<BTNode> visited = new HashSet<BTNode>();
        LinkedList<BTNode> worklist = new LinkedList<BTNode>();
        /* Initialize root element: */
        BTNode current_0 = root;
        worklist.add(current_0);
        /* Cycle over cyclic references: */
        while (!worklist.isEmpty()) {
            current_0 = worklist.removeFirst();
            if (!visited.add(current_0)) {
                return false;
            }
            /* Handle current: */
            /* End of Handle current: */
            if (current_0.left != null) {
                worklist.add(current_0.left);
            }
            if (current_0.right != null) {
                worklist.add(current_0.right);
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
