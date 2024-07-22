package examples.hashmap;

import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    public void test0() {
        HashMap t = new HashMap();
    }

    @Test
    public void test1() {
        HashMap t = new HashMap();
        t.put(5, new Object());
    }

    @Test
    public void test2() {
        HashMap t = new HashMap();
        t.put(1, new Object());
        t.put(2, new Object());
    }

    @Test
    public void test3() {
        HashMap t = new HashMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
    }

    @Test
    public void test4() {
        HashMap t = new HashMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
    }

    @Test
    public void test5() {
        HashMap t = new HashMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
        t.put(4, new Object());
    }

    @Test
    public void test6() {
        HashMap t = new HashMap();
        t.put(1, new Object());
        t.put(2, new Object());
        t.put(3, new Object());
        t.put(4, new Object());
        t.put(4, new Object());
        t.put(5, new Object());
    }

    @Test
    public void test7() {
        HashMap t = new HashMap();
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
