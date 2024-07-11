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
        t.quantumExpire();
        t.blockProcess();
        t.blockProcess();
    }

    @Test
    public void test11() {
        Schedule t = new Schedule(6, 5, 8);
        t.blockProcess();
        t.quantumExpire();
        t.blockProcess();
        t.blockProcess();
        t.blockProcess();
    }

    @Test
    public void test12() {
        Schedule t = new Schedule(4, 5, 8);
        t.quantumExpire();
        t.blockProcess();
        t.blockProcess();
        t.quantumExpire();
    }

    @Test
    public void test13() {
        Schedule t = new Schedule(4, 5, 2);
        t.quantumExpire();
        t.blockProcess();
        t.blockProcess();
        t.quantumExpire();
    }

    @Test
    public void test14() {

        Schedule t = new Schedule();
        t.addProcess(1);
    }

    @Test
    public void test15() {

        Schedule t = new Schedule();
        t.addProcess(2);
    }

    @Test
    public void test16() {

        Schedule t = new Schedule();
        t.addProcess(3);
    }

    @Test
    public void test17() {
        Schedule t = new Schedule(8, 8, 8);
        t.quantumExpire();
        t.blockProcess();
        t.blockProcess();
        t.quantumExpire();
    }

    @Test
    public void test18() {
        Schedule t = new Schedule(8, 8, 8);
        t.finishAllProcesses();
    }

}
