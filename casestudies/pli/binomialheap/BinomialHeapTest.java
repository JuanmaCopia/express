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
    public void test00() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2895);
        binomialHeap0.insert((-1939));
        binomialHeap0.insert((-1939));
        binomialHeap0.insert((-1939));
        binomialHeap0.insert((-1));
        binomialHeap0.delete((-1));
    }

    @Test()
    public void test01() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.delete((-3946));
    }

    @Test()
    public void test02() throws Throwable {
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
    public void test03() throws Throwable {
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
    public void test04() throws Throwable {
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
    public void test05() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-353));
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.delete((-1817));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete((-1797));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete(0);
    }

    @Test()
    public void test06() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.insert((-3946));
        binomialHeap0.delete((-3946));
    }

    @Test()
    public void test07() throws Throwable {
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
        binomialHeap0.insert(0);
    }

    @Test()
    public void test08() throws Throwable {
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
        binomialHeap0.insert(949);
        binomialHeap0.delete(1);
    }

    @Test()
    public void test09() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.delete(2186);
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-49));
        binomialHeap0.insert(0);
        binomialHeap0.delete(2186);
    }

    @Test()
    public void test10() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.insert(0);
        binomialHeap0.insert(0);
        binomialHeap0.insert(0);
        binomialHeap0.delete(2);
        binomialHeap0.delete(282);
        binomialHeap0.insert((-101));
        binomialHeap0.insert(2);
        binomialHeap0.insert(0);
        binomialHeap0.insert(2);
        binomialHeap0.delete(0);
    }

    @Test()
    public void test11() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2);
    }

    @Test()
    public void test12() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(21);
        binomialHeap0.insert(21);
        binomialHeap0.insert(21);
        binomialHeap0.insert(21);
        binomialHeap0.delete(21);
    }

    @Test()
    public void test13() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(558);
        binomialHeap0.insert((-2529));
    }

    @Test()
    public void test14() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
    }

    @Test()
    public void test15() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(0);
    }

    @Test()
    public void test16() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(916);
        binomialHeap0.insert(916);
        binomialHeap0.delete(0);
    }

    @Test()
    public void test17() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(352);
        binomialHeap0.insert(0);
        binomialHeap0.delete(352);
    }

    @Test()
    public void test18() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-25));
        binomialHeap0.insert((-25));
        binomialHeap0.insert(1334);
        binomialHeap0.delete((-25));
    }

    @Test()
    public void test19() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(949);
        binomialHeap0.insert(949);
        binomialHeap0.delete(3923);
        binomialHeap0.insert(949);
        binomialHeap0.insert(0);
        binomialHeap0.insert(1);
        binomialHeap0.delete(0);
        binomialHeap0.insert(949);
    }

    @Test()
    public void test20() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.insert(2186);
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.insert((-1963));
        binomialHeap0.insert(0);
        binomialHeap0.delete(2186);
    }

    @Test()
    public void test21() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(949);
        binomialHeap0.insert(949);
        binomialHeap0.delete(3923);
        binomialHeap0.delete(2148);
        binomialHeap0.insert(2294);
        binomialHeap0.delete(1725);
    }

    @Test()
    public void test22() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(2186);
        binomialHeap0.delete((-2930));
    }

    @Test()
    public void test23() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.insert(1453);
        binomialHeap0.delete(1453);
    }

    @Test()
    public void test24() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.insert(903);
        binomialHeap0.delete(903);
    }

    @Test()
    public void test25() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.delete(903);
    }

    @Test()
    public void test26() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        // Undeclared exception!
        try {
        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test()
    public void test27() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert((-353));
        binomialHeap0.delete(0);
        binomialHeap0.insert(0);
        binomialHeap0.delete((-1817));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete((-1797));
        binomialHeap0.insert(0);
        binomialHeap0.delete(0);
        binomialHeap0.delete(0);
    }

    @Test
    public void test28() {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(-1);
        binomialHeap0.insert(0);
    }

    @Test()
    public void test29() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.insert(-58);
        binomialHeap0.insert(35);
        binomialHeap0.insert(9303);
        binomialHeap0.insert(-538);
        binomialHeap0.insert(24);
        binomialHeap0.insert(354);
        binomialHeap0.insert(-338);
        binomialHeap0.insert(3502);
        binomialHeap0.insert(90763);
        binomialHeap0.insert(-3458);
        binomialHeap0.insert(101);
        binomialHeap0.insert(120);
        binomialHeap0.insert(-158);
        binomialHeap0.insert(998);
        binomialHeap0.insert(1000);
        binomialHeap0.insert(-888);
        binomialHeap0.insert(676);
        binomialHeap0.insert(321);
        binomialHeap0.insert(-123);
        binomialHeap0.insert(545);
        binomialHeap0.insert(453);
        binomialHeap0.insert(-1258);
        binomialHeap0.insert(35231);
    }

    @Test()
    public void test30() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.insert(-58);
        binomialHeap0.insert(35);
        binomialHeap0.insert(9303);
        binomialHeap0.insert(-538);
        binomialHeap0.insert(24);
        binomialHeap0.insert(354);
        binomialHeap0.insert(-338);
        binomialHeap0.insert(3502);
        binomialHeap0.insert(90763);
        binomialHeap0.insert(-3458);
        binomialHeap0.insert(101);
        binomialHeap0.insert(120);
        binomialHeap0.insert(-158);
        binomialHeap0.insert(998);
        binomialHeap0.insert(1000);
        binomialHeap0.insert(-888);
        binomialHeap0.insert(676);
        binomialHeap0.insert(321);
        binomialHeap0.insert(-123);
        binomialHeap0.insert(545);
        binomialHeap0.insert(453);
        binomialHeap0.insert(-1258);
        binomialHeap0.insert(35231);
        binomialHeap0.insert(21);
        binomialHeap0.insert(31);
        binomialHeap0.insert(-21);
        binomialHeap0.insert(52);
        binomialHeap0.insert(-55);
        binomialHeap0.insert(1);
        binomialHeap0.insert(0);
    }

    @Test()
    public void test31() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.insert(-58);
        binomialHeap0.insert(35);
        binomialHeap0.insert(9303);
        binomialHeap0.insert(-538);
        binomialHeap0.insert(24);
        binomialHeap0.insert(354);
        binomialHeap0.insert(-338);
        binomialHeap0.insert(3502);
        binomialHeap0.insert(90763);
        binomialHeap0.insert(-3458);
        binomialHeap0.insert(101);
        binomialHeap0.insert(120);
        binomialHeap0.insert(-158);
        binomialHeap0.insert(998);
        binomialHeap0.insert(1000);
        binomialHeap0.insert(-888);
        binomialHeap0.insert(676);
        binomialHeap0.insert(321);
        binomialHeap0.insert(-123);
        binomialHeap0.insert(545);
        binomialHeap0.insert(453);
        binomialHeap0.insert(-1258);
        binomialHeap0.insert(35231);
        binomialHeap0.insert(21);
        binomialHeap0.insert(31);
        binomialHeap0.insert(-21);
        binomialHeap0.insert(52);
        binomialHeap0.insert(-55);
        binomialHeap0.insert(1);
        binomialHeap0.insert(0);

        binomialHeap0.delete(0);
        binomialHeap0.delete(1000);
        binomialHeap0.delete(-338);
    }

    @Test()
    public void test32() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(903);
        binomialHeap0.insert(-58);
        binomialHeap0.insert(35);
        binomialHeap0.insert(9303);
        binomialHeap0.insert(-538);
        binomialHeap0.insert(24);
        binomialHeap0.insert(354);
        binomialHeap0.insert(-338);
        binomialHeap0.insert(3502);
        binomialHeap0.insert(90763);
        binomialHeap0.insert(-3458);
        binomialHeap0.insert(101);
        binomialHeap0.insert(120);
        binomialHeap0.insert(-158);
        binomialHeap0.insert(998);
        binomialHeap0.insert(1000);
        binomialHeap0.insert(-888);
        binomialHeap0.insert(676);
        binomialHeap0.insert(321);
        binomialHeap0.insert(-123);
        binomialHeap0.insert(545);
        binomialHeap0.insert(453);
        binomialHeap0.insert(-1258);
        binomialHeap0.insert(35231);
        binomialHeap0.insert(21);
        binomialHeap0.insert(31);
        binomialHeap0.insert(-21);
        binomialHeap0.insert(52);
        binomialHeap0.insert(-55);
        binomialHeap0.insert(1);
        binomialHeap0.insert(0);

        binomialHeap0.delete(0);
        binomialHeap0.delete(1000);
        binomialHeap0.delete(-338);
        binomialHeap0.delete(-123);
        binomialHeap0.delete(545);
        binomialHeap0.delete(453);
    }

    @Test()
    public void test33() throws Throwable {
        BinomialHeap binomialHeap0 = new BinomialHeap();
        binomialHeap0.insert(-1);
        binomialHeap0.insert(-2);
        binomialHeap0.insert(-3);
        binomialHeap0.insert(0);
        binomialHeap0.insert(1);
        binomialHeap0.insert(2);
        binomialHeap0.insert(3);
        binomialHeap0.insert(4);
        binomialHeap0.insert(5);
        binomialHeap0.insert(6);
        binomialHeap0.insert(7);
        binomialHeap0.insert(8);
        binomialHeap0.insert(9);
        binomialHeap0.insert(10);
        binomialHeap0.insert(11);
        binomialHeap0.insert(12);
        binomialHeap0.insert(13);
        binomialHeap0.insert(14);
        binomialHeap0.insert(15);
        binomialHeap0.insert(16);
        binomialHeap0.insert(903);
        binomialHeap0.insert(-58);
        binomialHeap0.insert(35);
        binomialHeap0.insert(9303);
        binomialHeap0.insert(-538);
        binomialHeap0.insert(24);
        binomialHeap0.insert(354);
        binomialHeap0.insert(-338);
        binomialHeap0.insert(3502);
        binomialHeap0.insert(90763);
        binomialHeap0.insert(-3458);
        binomialHeap0.insert(101);
        binomialHeap0.insert(120);
        binomialHeap0.insert(-158);
        binomialHeap0.insert(998);
        binomialHeap0.insert(1000);
        binomialHeap0.insert(-888);
        binomialHeap0.insert(-5);
        binomialHeap0.insert(-6);
        binomialHeap0.insert(-7);
        binomialHeap0.insert(-8);
        binomialHeap0.insert(676);
        binomialHeap0.insert(321);
        binomialHeap0.insert(-123);
        binomialHeap0.insert(545);
        binomialHeap0.insert(453);
        binomialHeap0.insert(-1258);
        binomialHeap0.insert(35231);
        binomialHeap0.insert(21);
        binomialHeap0.insert(31);
        binomialHeap0.insert(-8);
        binomialHeap0.insert(-9);
        binomialHeap0.insert(-10);
        binomialHeap0.insert(-11);
        binomialHeap0.insert(-12);
        binomialHeap0.insert(-21);
        binomialHeap0.insert(52);
        binomialHeap0.insert(-55);
        binomialHeap0.insert(1);
        binomialHeap0.insert(0);
        binomialHeap0.insert(-14);
        binomialHeap0.insert(-15);
        binomialHeap0.insert(-16);
        binomialHeap0.insert(534);
        binomialHeap0.insert(622);
        binomialHeap0.insert(711);
        binomialHeap0.insert(83213);
        binomialHeap0.insert(913);
        binomialHeap0.insert(1033);
        binomialHeap0.insert(1154);
        binomialHeap0.insert(1256);
        binomialHeap0.insert(744);
        binomialHeap0.insert(176);
        binomialHeap0.insert(154);
    }

}
