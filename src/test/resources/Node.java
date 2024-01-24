
public class Node {
    int data;
    Node next;

    public boolean actual1() {
        return true;
    }

    public boolean expected1() {
        if (next == null)
            return false;
        return true;
    }

    public boolean m() {

        Node current = this;
        return true;
    }
}
