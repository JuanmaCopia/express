package casestudies.treemap2;

import org.junit.Test;

public class TreeMap2Test {

    @Test
    public void test0() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
    }

    @Test
    public void test1() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(5, new Object());
    }

    @Test
    public void test2() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(1, new Object());
        t.put(2, new Object());
    }

    @Test
    public void test3() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
    }

    @Test
    public void test4() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
    }

    @Test
    public void test5() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
        t.put(4, new Object());
    }

    @Test
    public void test6() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
        t.put(4, new Object());
        t.put(5, new Object());
    }

    @Test
    public void test7() {
        TreeMap2<Integer, Object> t = new TreeMap2<>();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
        t.put(4, new Object());
        t.put(5, new Object());
        t.put(6, new Object());
        t.put(0, new Object());
        t.put(40, new Object());
        t.put(23, new Object());
        t.put(61, new Object());
    }

}
