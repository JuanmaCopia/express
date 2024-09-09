package casestudies.pli.treemap;

import org.junit.Test;

public class TreeMapTest {

    @Test
    public void test0() {
        TreeMap t = new TreeMap();
    }

    @Test
    public void test1() {
        TreeMap t = new TreeMap();
        t.put(5, new Object());
    }

    @Test
    public void test2() {
        TreeMap t = new TreeMap();
        t.put(1, new Object());
        t.put(2, new Object());
    }

    @Test
    public void test3() {
        TreeMap t = new TreeMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
    }

    @Test
    public void test4() {
        TreeMap t = new TreeMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
    }

    @Test
    public void test5() {
        TreeMap t = new TreeMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, null);
        t.put(4, new Object());
        t.put(4, new Object());
    }

    @Test
    public void test6() {
        TreeMap t = new TreeMap();
        t.put(1, null);
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
        t.put(4, new Object());
        t.put(5, new Object());
    }

    @Test
    public void test7() {
        TreeMap t = new TreeMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, null);
        t.put(4, new Object());
        t.put(5, new Object());
        t.put(6, new Object());
        t.put(0, new Object());
        t.put(40, new Object());
        t.put(23, null);
        t.put(61, new Object());
    }

    @Test
    public void test8() {
        TreeMap t = new TreeMap();
        t.put(1, null);
        t.put(2, null);
        t.put(3, null);
        t.put(4, null);
        t.put(4, null);
        t.put(5, null);
        t.put(6, null);
        t.put(0, null);
        t.put(40, null);
        t.put(23, null);
        t.put(61, null);
    }

}
