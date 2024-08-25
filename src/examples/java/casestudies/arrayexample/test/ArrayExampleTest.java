package casestudies.arrayexample;

import org.junit.jupiter.api.Test;

public class ArrayExampleTest {

    @Test
    public void test0() {
        ArrayExample t = new ArrayExample(10);
    }

    @Test
    public void test1() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(0, 1);
    }

    @Test
    public void test2() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(0, 2);
    }

    @Test
    public void test3() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(0, 1);
        t.addNode(0, 2);
        t.addNode(5, 3);
    }

    @Test
    public void test4() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(0, 1);
        t.addNode(0, 2);
        t.addNode(1, 2);
        t.addNode(5, 3);
    }

    @Test
    public void test5() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(0, 1);
        t.addNode(0, 2);
        t.addNode(1, 2);
        t.addNode(2, 6);
        t.addNode(3, 7);
        t.addNode(4, 4);
        t.addNode(5, 8);
        t.addNode(6, 3);
    }

    @Test
    public void test6() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(0, 1);
        t.addNode(0, 2);
        t.addNode(1, 2);
        t.addNode(2, 6);
        t.addNode(3, 7);
        t.addNode(4, 4);
        t.addNode(5, 8);
        t.addNode(6, 3);
        t.addNode(7, 9);
        t.addNode(8, 5);
        t.addNode(9, 0);
    }

    @Test
    public void test7() {
        ArrayExample t = new ArrayExample(10);
        t.addNode(3, 7);
        t.addNode(4, 4);
        t.addNode(5, 8);
        t.addNode(6, 3);
        t.addNode(7, 9);
        t.addNode(8, 5);
        t.addNode(9, 0);
    }

}
