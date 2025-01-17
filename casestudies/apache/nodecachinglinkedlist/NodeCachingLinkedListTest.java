package casestudies.apache.nodecachinglinkedlist;

import org.junit.Test;

public class NodeCachingLinkedListTest {

    @Test
    public void test0() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
    }

    @Test
    public void test1() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
    }

    @Test
    public void test2() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
    }

    @Test
    public void test3() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test4() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
    }

    @Test
    public void test5() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
    }

    @Test
    public void test6() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test7() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test8() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.removeLast();
    }

    @Test
    public void test9() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test10() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test11() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test12() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(null);
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test13() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test14() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test15() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
    }

    @Test
    public void test16() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.removeLast();
        t.add(new Object());
        t.setMaximumCacheSize(1);
    }

    @Test
    public void test17() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.setMaximumCacheSize(1);
        t.removeAllNodes();
    }

    @Test
    public void test18() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.setMaximumCacheSize(1);
    }

    @Test
    public void test19() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
    }

}
