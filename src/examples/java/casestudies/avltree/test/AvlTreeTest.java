package casestudies.avltree;

import org.junit.jupiter.api.Test;

public class AvlTreeTest {

    @Test
    public void test0() {
        AvlTree t = new AvlTree();
    }

    @Test
    public void test1() {
        AvlTree t = new AvlTree();
        t.insert(5);
    }

    @Test
    public void test2() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
    }

    @Test
    public void test3() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
    }

    @Test
    public void test4() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
    }

    @Test
    public void test5() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
    }

    @Test
    public void test6() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(5);
    }

    @Test
    public void test7() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(0);
        t.insert(40);
        t.insert(23);
        t.insert(61);
    }

}
