package casestudies.pli.binomialheap;

import org.junit.Test;

public class BinomialHeapTest {

    @Test
    public void test0() {
        BinomialHeap t = new BinomialHeap();
    }

    @Test
    public void test1() {
        BinomialHeap t = new BinomialHeap();
        t.insert(5);
    }

    @Test
    public void test2() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
    }

    @Test
    public void test3() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
    }

    @Test
    public void test4() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
    }

    @Test
    public void test5() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
    }

    @Test
    public void test6() {
        BinomialHeap t = new BinomialHeap();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(5);
    }

    @Test
    public void test7() {
        BinomialHeap t = new BinomialHeap();
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

    @Test()
    public void test00()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.decreaseKeyValue(2186, 2968);
        binomialHeap0.insert(2895);
        binomialHeap0.insert((-1939));
        binomialHeap0.insert((-1939));
        binomialHeap0.insert((-1939));
        binomialHeap0.decreaseKeyValue(0, (-49));
        binomialHeap0.insert((-1));
        binomialHeap0.delete((-1));
    }

    @Test()
    public void test01()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.decreaseKeyValue((-3946), 935);
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.delete((-3946));
    }

    @Test()
    public void test02()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2222);
        binomialHeap0.insert((-1880));
        binomialHeap0.insert((-1880));
        binomialHeap0.insert(2222);
        binomialHeap0.insert(2222);
        binomialHeap0.insert(2222);
        binomialHeap0.delete((-1880));
    }

    @Test()
    public void test03()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert((-733));
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.delete((-733));
    }

    @Test()
    public void test04()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert((-1915));
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.delete((-1915));
    }

    @Test()
    public void test05()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-353));
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(0, 0);
        binomialHeap0.delete((-1817));
        binomialHeap0.decreaseKeyValue(0, (-353));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete((-1797));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete(0);
    }

    @Test()
    public void test06()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.decreaseKeyValue((-3946), 935);
        binomialHeap0.insert((-3946));
        binomialHeap0.delete((-3946));
    }

    @Test()
    public void test07()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete((-2689));
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete(1);
        binomialHeap0.delete(0);
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(0, 3040);
        binomialHeap0.decreaseKeyValue(0, 0);
        binomialHeap0.decreaseKeyValue(0, 725);
        binomialHeap0.insert(0);
    }

    @Test()
    public void test08()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.delete(949);
        binomialHeap0.insert(0);
        binomialHeap0.insert(949);
        binomialHeap0.insert(949);
        binomialHeap0.delete((-1712));
        binomialHeap0.delete((-2660));
        binomialHeap0.insert(949);
        binomialHeap0.insert((-49));
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(949, 1);
        binomialHeap0.insert(949);
        binomialHeap0.delete(1);
    }

    @Test()
    public void test09()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.decreaseKeyValue((-1963), 1588);
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.delete(2186);
        binomialHeap0.decreaseKeyValue(1588, (-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-49));
        binomialHeap0.decreaseKeyValue(0, (-49));
        binomialHeap0.insert(0);
        binomialHeap0.delete(2186);
    }

    @Test()
    public void test10()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(0, 0);
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(282, 1084);
        binomialHeap0.insert(0);
        binomialHeap0.insert(0);
        binomialHeap0.delete(2);
        binomialHeap0.decreaseKeyValue(0, 0);
        binomialHeap0.delete(282);
        binomialHeap0.insert((-101));
        binomialHeap0.decreaseKeyValue(0, (-205));
        binomialHeap0.insert(2);
        binomialHeap0.insert(0);
        binomialHeap0.insert(2);
        binomialHeap0.decreaseKeyValue((-101), (-101));
        binomialHeap0.delete(0);
    }

    @Test()
    public void test11()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2);
        binomialHeap0.decreaseKeyValue(0, 0);
    }

    @Test()
    public void test12()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(21);
        binomialHeap0.insert(21);
        binomialHeap0.insert(21);
        binomialHeap0.insert(21);
        binomialHeap0.delete(21);
    }

    @Test()
    public void test13()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(558);
        binomialHeap0.insert((-2529));
    }

    @Test()
    public void test14()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
    }

    @Test()
    public void test15()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(2186, 2186);
    }

    @Test()
    public void test16()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(916);
        binomialHeap0.insert(916);
        binomialHeap0.delete(0);
    }

    @Test()
    public void test17()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(352);
        binomialHeap0.insert(0);
        binomialHeap0.delete(352);
    }

    @Test()
    public void test18()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-25));
        binomialHeap0.insert((-25));
        binomialHeap0.insert(1334);
        binomialHeap0.delete((-25));
    }

    @Test()
    public void test19()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(949);
        binomialHeap0.insert(949);
        binomialHeap0.delete(3923);
        binomialHeap0.insert(949);
        binomialHeap0.insert(0);
        binomialHeap0.insert(1);
        binomialHeap0.delete(0);
        binomialHeap0.insert(949);
        binomialHeap0.decreaseKeyValue(949, 0);
    }

    @Test()
    public void test20()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.decreaseKeyValue(0, (-49));
        binomialHeap0.insert(0);
        binomialHeap0.delete(2186);
    }

    @Test()
    public void test21()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(949);
        binomialHeap0.insert(949);
        binomialHeap0.delete(3923);
        binomialHeap0.decreaseKeyValue(949, 1762);
        binomialHeap0.delete(2148);
        binomialHeap0.insert(2294);
        binomialHeap0.delete(1725);
    }

    @Test()
    public void test22()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.delete((-2930));
    }

    @Test()
    public void test23()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.delete(1453);
    }

    @Test()
    public void test24()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.insert(903);
        binomialHeap0.delete(903);
    }

    @Test()
    public void test25()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.delete(903);
    }

    @Test()
    public void test26()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        // Undeclared exception!
        try {
            binomialHeap0.decreaseKeyValue(0, 0);
        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test()
    public void test27()  throws Throwable  {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-353));
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.decreaseKeyValue(0, 0);
        binomialHeap0.delete((-1817));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete((-1797));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete(0);
    }

}
