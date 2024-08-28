package apache.nodecachinglinkedlist;

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
        t.add(new Object());
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

}
