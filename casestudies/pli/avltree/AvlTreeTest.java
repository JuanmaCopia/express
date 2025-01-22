package casestudies.pli.avltree;

import org.junit.Test;

public class AvlTreeTest {

    @Test
    public void test0() {
        AvlTree t = new AvlTree();
    }

    @Test
    public void test1() {
        AvlTree t = new AvlTree();
        t.insert(5);
    }

    @Test
    public void test2() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
    }

    @Test
    public void test3() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
    }

    @Test
    public void test4() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
    }

    @Test
    public void test5() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
    }

    @Test
    public void test6() {
        AvlTree t = new AvlTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(4);
        t.insert(5);
    }

    @Test
    public void test7() {
        AvlTree t = new AvlTree();
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
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-459));
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.remove(223);
        avlTree0.insert(476);
        avlTree0.insert(0);
        avlTree0.insert(223);
        avlTree0.remove(312);
        avlTree0.insert((-4327));
        avlTree0.remove(1383);
        avlTree0.insert((-3701));
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.insert(0);
        avlTree0.insert(2360);
        avlTree0.insert((-1));
        avlTree0.remove((-459));
        avlTree0.insert(590);
        avlTree0.remove((-1));
    }

    @Test()
    public void test01()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-2558));
        avlTree0.insert(1);
        avlTree0.insert(678);
        avlTree0.insert(678);
        avlTree0.remove(678);
        avlTree0.insert(0);
        AvlTree avlTree1 = new AvlTree();
        avlTree1.insert((-619));
    }

    @Test()
    public void test02()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-459));
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.remove(223);
        avlTree0.insert(476);
        avlTree0.insert(0);
        avlTree0.insert((-4327));
        avlTree0.remove(1383);
        avlTree0.insert((-3701));
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.insert(0);
        avlTree0.insert(2360);
        avlTree0.insert((-1));
        avlTree0.remove((-459));
        avlTree0.insert(590);
        avlTree0.insert(274);
        avlTree0.remove(Integer.MIN_VALUE);
        avlTree0.insert(3063);
    }

    @Test()
    public void test03()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(Integer.MIN_VALUE);
        avlTree0.remove((-2689));
        avlTree0.remove((-2689));
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.remove(0);
        avlTree0.insert((-1));
        avlTree0.remove((-1));
        avlTree0.insert(0);
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.insert((-1));
        avlTree0.insert(0);
    }

    @Test()
    public void test04()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-2916));
        avlTree0.insert(755);
        avlTree0.insert((-68));
        avlTree0.insert(2);
        avlTree0.remove((-68));
    }

    @Test()
    public void test05()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(2961);
        avlTree0.remove(415);
        avlTree0.insert(415);
        avlTree0.remove(2327);
        avlTree0.insert(415);
        avlTree0.remove(2746);
        avlTree0.insert(415);
        avlTree0.insert((-1239));
        avlTree0.remove(2327);
        avlTree0.insert(1);
        avlTree0.insert(0);
        avlTree0.remove(2327);
        avlTree0.insert(2327);
        avlTree0.insert(2358);
        avlTree0.insert(2961);
        avlTree0.remove(415);
        avlTree0.insert(0);
        avlTree0.insert((-221));
        avlTree0.remove((-141));
        avlTree0.remove(2961);
        avlTree0.insert(0);
        avlTree0.insert(2358);
        avlTree0.remove((-3957));
    }

    @Test()
    public void test06()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(0);
        avlTree0.insert((-1285));
        avlTree0.insert((-2490));
    }

    @Test()
    public void test07()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(2401);
        avlTree0.insert(520);
        avlTree0.insert(2071);
    }

    @Test()
    public void test08()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.remove(3328);
        avlTree0.remove(0);
        avlTree0.insert(0);
        avlTree0.remove((-1526));
        avlTree0.insert((-1));
        avlTree0.insert(432);
        avlTree0.remove(0);
    }

    @Test()
    public void test09()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-1723));
        avlTree0.insert(1744);
        avlTree0.insert(4114);
        avlTree0.remove(1744);
    }

    @Test()
    public void test10()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(0);
        avlTree0.remove(0);
        avlTree0.remove((-2737));
    }

    @Test()
    public void test11()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-1723));
        avlTree0.insert(1744);
        avlTree0.insert(880);
    }

    @Test()
    public void test12()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-1723));
        avlTree0.insert(3784);
        avlTree0.insert(3944);
    }

    @Test()
    public void test13()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.remove((-2239));
        avlTree0.insert((-2239));
        avlTree0.insert((-230));
        avlTree0.insert((-230));
        avlTree0.insert((-1));
        avlTree0.remove(3275);
        avlTree0.insert(0);
        avlTree0.remove((-2545));
        avlTree0.insert(0);
    }

    @Test()
    public void test14()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-2049));
        avlTree0.remove((-1));
    }

    @Test()
    public void test15()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(1744);
        avlTree0.insert(880);
    }

    @Test()
    public void test16()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(505);
        avlTree0.insert(0);
        avlTree0.remove(505);
    }

    @Test()
    public void test17()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.remove(1);
        avlTree0.insert(0);
        avlTree0.remove((-1489));
        avlTree0.insert((-4557));
        avlTree0.insert(0);
        avlTree0.insert((-4557));
        avlTree0.remove(1);
        avlTree0.remove(1430);
        avlTree0.insert(0);
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.insert(2623);
    }

    @Test()
    public void test18()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-2023));
        avlTree0.insert(688);
    }

    @Test()
    public void test19()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(1744);
        avlTree0.remove((-615));
    }

    @Test()
    public void test20()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert(0);
        avlTree0.insert(0);
    }

    @Test()
    public void test21()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-2049));
        avlTree0.remove((-2049));
    }

    @Test()
    public void test22()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.insert((-1));
    }

    @Test()
    public void test23()  throws Throwable  {
        AvlTree avlTree0 = new AvlTree();
        avlTree0.remove(0);
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.insert(0);
        avlTree0.remove(0);
        avlTree0.insert(0);
        avlTree0.remove((-1797));
        avlTree0.remove(0);
        avlTree0.remove(0);
        avlTree0.insert(1);
        avlTree0.remove((-353));
    }

}
