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

    @Test
    public void test20() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
        for (int i = 0; i <= 50; i++) {
            t.add(new Object());
        }
        for (int i = 0; i <= 45; i++) {
            t.removeLast();
        }
    }

    @Test
    public void test21() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
        for (int i = 0; i <= 50; i++) {
            t.add(new Object());
        }
        for (int i = 0; i <= 45; i++) {
            t.removeLast();
        }
        t.setMaximumCacheSize(0);
        t.removeAllNodes();
    }

    @Test
    public void test22() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
        for (int i = 0; i <= 50; i++) {
            t.add(new Object());
        }
        t.removeAllNodes();
    }

    @Test
    public void test23() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
        for (int i = 0; i <= 50; i++) {
            t.addLast(new Object());
        }
        for (int i = 0; i <= 45; i++) {
            t.removeLast();
        }
        t.setMaximumCacheSize(0);
        t.removeAllNodes();
        t.setMaximumCacheSize(0);
        t.clear();
    }

    @Test
    public void test24() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeAllNodes();
    }

    @Test
    public void test25() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.removeAllNodes();
    }

    @Test
    public void test26() {
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
        t.add(new Object());
        t.add(new Object());
        t.removeAllNodes();
    }

    @Test
    public void test27() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
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
        t.add(new Object());
        t.add(new Object());
        t.removeAllNodes();
    }

    @Test
    public void test28() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
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
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.removeAllNodes();
    }

    @Test
    public void test29() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        while (t.size() > 0) {
            t.removeLast();

        }
    }

    @Test
    public void test30() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(60);
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
        t.add(new Object());
        t.add(null);
        t.add(new Object());
        t.add(new Object());
        while (t.size() > 0) {
            t.removeLast();

        }
    }

    @Test
    public void test31() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.setMaximumCacheSize(7);
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
        while (t.size() > 0) {
            t.removeLast();

        }
    }

    @Test
    public void test32() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        while (t.size() > 0) {
            t.removeLast();

        }
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
        t.getNodeFromCache();
    }

    @Test
    public void test33() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        while (t.size() > 0) {
            t.removeLast();

        }
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
        t.getNodeFromCache();
        t.getNodeFromCache();
        t.getNodeFromCache();
        t.getNodeFromCache();
    }

    @Test
    public void test34() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        t.add(new Object());
        while (t.size() > 0) {
            t.removeLast();

        }
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
        t.getNodeFromCache();
        t.getNodeFromCache();
        t.getNodeFromCache();
        t.getNodeFromCache();
    }

    @Test
    public void test35() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        AbstractLinkedList.Node<Object> node0 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node1 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node2 = t.createNode(new Object());
        t.addNodeToCache(node0);
        t.addNodeToCache(node1);
        t.addNodeToCache(node2);
    }

    @Test
    public void test36() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        AbstractLinkedList.Node<Object> node0 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node1 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node2 = t.createNode(new Object());
        t.addNodeToCache(node0);
        t.addNodeToCache(node1);
        t.addNodeToCache(node2);
        t.getNodeFromCache();
    }

    @Test
    public void test37() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        AbstractLinkedList.Node<Object> node0 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node1 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node2 = t.createNode(new Object());
        t.addNodeToCache(node0);
        t.addNodeToCache(node1);
        t.addNodeToCache(node2);
        t.getNodeFromCache();
        t.getNodeFromCache();
    }

    @Test
    public void test38() {
        NodeCachingLinkedList<Object> t = new NodeCachingLinkedList<>();
        AbstractLinkedList.Node<Object> node0 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node1 = t.createNode(new Object());
        AbstractLinkedList.Node<Object> node2 = t.createNode(new Object());
        t.addNodeToCache(node0);
        t.addNodeToCache(node1);
        t.addNodeToCache(node2);
        t.getNodeFromCache();
        t.getNodeFromCache();
        t.getNodeFromCache();
    }

}
