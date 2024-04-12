package examples.bintree;

import org.junit.jupiter.api.Test;

public class BinTreeTest {

    @Test
    public void test0() {
        BinTree t = new BinTree();
    }

    @Test
    public void test1() {
        BinTree t = new BinTree();
        t.addNode(5);
    }

    @Test
    public void test2() {
        BinTree t = new BinTree();
        t.addNode(1);
        t.addNode(2);
    }

    @Test
    public void test3() {
        BinTree t = new BinTree();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
    }

    @Test
    public void test4() {
        BinTree t = new BinTree();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
    }

    @Test
    public void test5() {
        BinTree t = new BinTree();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
        t.addNode(4);
    }

    @Test
    public void test6() {
        BinTree t = new BinTree();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
        t.addNode(4);
        t.addNode(5);
    }

    @Test
    public void test7() {
        BinTree t = new BinTree();
        t.addNode(1);
        t.addNode(2);
        t.addNode(3);
        t.addNode(4);
        t.addNode(4);
        t.addNode(5);
        t.addNode(6);
    }

}
