package examples.schedule;

import org.junit.jupiter.api.Test;

public class ScheduleTest {

    @Test
    public void test0() {
        Schedule t = new Schedule();
    }

    @Test
    public void test1() {
        Schedule t = new Schedule(0, 1, 1);
    }

    @Test
    public void test2() {
        Schedule t = new Schedule(1, 0, 0);
    }

    @Test
    public void test3() {
        Schedule t = new Schedule(0, 1, 0);
    }

    @Test
    public void test4() {
        Schedule t = new Schedule(0, 0, 1);
    }

    @Test
    public void test5() {
        Schedule t = new Schedule(1, 1, 0);
    }

    @Test
    public void test6() {
        Schedule t = new Schedule(1, 0, 1);
    }

    @Test
    public void test7() {
        Schedule t = new Schedule(2, 0, 5);
        t.quantumExpire();
    }

    @Test
    public void test8() {
        Schedule t = new Schedule(3, 7, 5);
        t.blockProcess();
    }

    @Test
    public void test9() {
        Schedule t = new Schedule(9, 2, 3);
        t.quantumExpire();
    }

    @Test
    public void test10() {
        Schedule t = new Schedule(2, 5, 8);
        t.blockProcess();
    }

}
