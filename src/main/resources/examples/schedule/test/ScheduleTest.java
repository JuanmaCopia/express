package examples.schedule;

import org.junit.Test;

public class ScheduleTest {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test001");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        java.lang.Class<?> wildcardClass2 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test002");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test003");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test004");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) -1, (float) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test005");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test006");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test007");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test008");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test009");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio(10, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test010");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test011");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) ' ', 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test012");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) -1, 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test013");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) 'a', (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test014");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 100, (float) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test015");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test016");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test017");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test018");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 0, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test019");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 10, (float) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test020");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test021");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test022");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) -1, (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test023");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        schedule0.quantumExpire();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test024");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test025");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test026");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test027");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test028");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 10, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test029");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 10, (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test030");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) ' ', (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test031");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test032");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 10, (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test033");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test034");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test035");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test036");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test037");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test038");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 100, (float) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test039");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test040");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass2 = schedule0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test041");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test042");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test043");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test044");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test045");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass4 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test046");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test047");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test048");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test049");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test050");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, (float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test051");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) '#', (float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test052");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(100, (float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test053");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 10, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test054");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test055");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test056");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test057");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test058");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(10, (float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test059");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test060");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 0, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test061");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test062");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test063");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) ' ', (float) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test064");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test065");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test066");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) '4', (float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test067");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test068");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test069");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test070");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test071");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test072");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test073");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test074");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test075");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass4 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test076");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test077");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test078");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        schedule0.blockProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test079");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) 0);
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test080");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test081");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test082");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass12 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test083");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test084");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test085");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 10, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test086");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test087");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.quantumExpire();
        java.lang.Class<?> wildcardClass2 = schedule0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test088");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test089");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) -1, 1);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test090");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test091");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test092");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test093");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        java.lang.String str6 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test094");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test095");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test096");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test097");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test098");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test099");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) 'a', (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test100");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test101");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test102");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test103");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test104");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test105");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test106");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) '4', (float) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test107");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test108");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass5 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test109");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test110");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) -1, 1);
        schedule3.blockProcess();
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test111");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test112");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test113");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test114");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test115");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (-1), (int) (short) 100);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test116");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test117");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) '#', 10);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test118");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        schedule3.finishProcess();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 9\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 19\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 9\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 19\n");
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test119");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n");
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test120");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        schedule0.unblockProcess((float) 1L);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test121");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.blockProcess();
        java.lang.String str13 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 0, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test122");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test123");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test124");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 0, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test125");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        schedule3.unblockProcess(0.0f);
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test126");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test127");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test128");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) '#', 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test129");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test130");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.quantumExpire();
        java.lang.String str13 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test131");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (int) (short) -1, (int) (short) 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test132");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test133");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test134");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 1, (int) (short) -1, (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test135");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test136");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test137");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test138");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test139");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test140");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, (int) (byte) 10, (int) (byte) 0);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test141");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test142");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (byte) -1, (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test143");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test144");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test145");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (byte) 0, (int) (byte) 1);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test146");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 100, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test147");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(0, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test148");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test149");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, (int) ' ', (int) (byte) 1);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test150");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test151");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 100, (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test152");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.quantumExpire();
        java.lang.String str2 = schedule0.toString();
        schedule0.blockProcess();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str2, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test153");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test154");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) 'a', (int) (byte) -1);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test155");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 100, 0);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test156");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        schedule0.unblockProcess((float) (short) 1);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test157");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishProcess();
        java.lang.Class<?> wildcardClass4 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test158");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.unblockProcess((float) 1);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n" + "'", str7, "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n");
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test159");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test160");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test161");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test162");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 97   |  Last: Visited  |  mem_count: 1\nprio_2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 98\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 97   |  Last: Visited  |  mem_count: 1\nprio_2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 98\n");
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test163");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test164");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test165");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test166");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 0, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test167");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str6 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: 1\nprio_0: null\nprio_1: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134   |  Last: Visited  |  mem_count: 100\nprio_2: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 0   |  Last: Visited  |  mem_count: 34\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 1   |  Last: Visited  |  mem_count: 1\nnum_processes: 135\n" + "'", str6, "curProc: 1\nprio_0: null\nprio_1: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134   |  Last: Visited  |  mem_count: 100\nprio_2: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 0   |  Last: Visited  |  mem_count: 34\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 1   |  Last: Visited  |  mem_count: 1\nnum_processes: 135\n");
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test168");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 100, (int) (short) 0);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test169");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test170");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 1, (int) 'a', (int) (byte) 10);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test171");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        java.lang.String str11 = schedule3.toString();
        schedule3.unblockProcess(1.0f);
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test172");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) 0);
        schedule3.quantumExpire();
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test173");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test174");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test175");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test176");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test177");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test178");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.quantumExpire();
        java.lang.String str5 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str5, "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test179");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 10, (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test180");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test181");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (int) (short) -1, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 10\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 10\n");
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test182");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 10, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test183");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) (byte) 0, (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test184");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test185");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test186");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, (int) (byte) -1, (int) (byte) -1);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test187");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test188");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test189");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test190");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        java.lang.String str9 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test191");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test192");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass14 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test193");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 10, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test194");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test195");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.blockProcess();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test196");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, 100, (int) (byte) 10);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test197");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess(1);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test198");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        java.lang.String str6 = schedule0.toString();
        schedule0.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test199");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test200");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test201");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (-1), (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test202");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test203");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test204");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test205");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test206");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test207");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test208");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test209");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 0, 0);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test210");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.finishAllProcesses();
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test211");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', 1, 10);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test212");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test213");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test214");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) '#', (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test215");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test216");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) 'a', (int) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, (float) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test217");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 0, 0);
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test218");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(10, (int) (short) 10, (int) (byte) -1);
        schedule3.quantumExpire();
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test219");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio(0, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test220");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 0, 0);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test221");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test222");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test223");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test224");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test225");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test226");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test227");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        schedule0.upgradeProcessPrio((int) (byte) 1, (float) 1L);
        schedule0.blockProcess();
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test228");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, (int) '#', 0);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test229");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) (byte) 10);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test230");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.Class<?> wildcardClass3 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test231");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test232");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) (byte) 0);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test233");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test234");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test235");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass3 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test236");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test237");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test238");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '4', 100, 0);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test239");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test240");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 1 2 3 4 5 6 7 8 9 0   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str8, "curProc: 0\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 1 2 3 4 5 6 7 8 9 0   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test241");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test242");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) '#', (int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test243");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test244");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, 100, 10);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test245");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test246");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test247");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 100, (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test248");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test249");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.unblockProcess((float) 1L);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test250");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) 'a', (int) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test251");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test252");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test253");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) (short) 1, (int) (short) 0);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test254");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(10, (int) (short) 10, 1);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test255");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test256");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(10, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test257");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n" + "'", str7, "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n");
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test258");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test259");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test260");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) 1);
        schedule3.blockProcess();
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test261");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str7 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n" + "'", str7, "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n");
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test262");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test263");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test264");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(0, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test265");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 10, (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test266");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
        java.lang.String str7 = schedule3.toString();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test267");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test268");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        schedule3.quantumExpire();
        java.lang.String str6 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str6, "curProc: 0\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test269");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        schedule3.blockProcess();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test270");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test271");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) (byte) 1, (int) (short) 10);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test272");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test273");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.finishProcess();
        schedule0.blockProcess();
        schedule0.addProcess(1);
        schedule0.finishProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test274");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test275");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test276");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test277");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test278");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test279");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        schedule0.upgradeProcessPrio((int) (byte) 1, (float) 1L);
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio(100, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test280");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test281");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess(0.0f);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test282");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) 'a', (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test283");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test284");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', 1, 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test285");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, 0, 100);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 100\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 100\n");
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test286");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 0, 0);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test287");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test288");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test289");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test290");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) '#', (int) (short) 100);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test291");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test292");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test293");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.String str7 = schedule3.toString();
        java.lang.String str8 = schedule3.toString();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test294");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.quantumExpire();
        java.lang.String str2 = schedule0.toString();
        schedule0.quantumExpire();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str2, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test295");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) (byte) -1, (int) (short) 10);
        schedule3.blockProcess();
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test296");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test297");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test298");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        java.lang.String str8 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test299");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) -1, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test300");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) ' ', (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test301");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 0, 0);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test302");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        schedule0.blockProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test303");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) '4', 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test304");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) (short) 10, 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(0, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test305");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test306");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test307");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (-1), (int) (byte) 10);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test308");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test309");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test310");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test311");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test312");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test313");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (int) (short) -1, (int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test314");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test315");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test316");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.quantumExpire();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test317");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 1, (int) (short) -1, (int) (byte) 0);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test318");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        java.lang.String str11 = schedule3.toString();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test319");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test320");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (-1), 100);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 0, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test321");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) ' ', (int) 'a');
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test322");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, (int) (byte) 10, (int) '#');
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test323");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        java.lang.String str5 = schedule0.toString();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test324");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, (int) (byte) 100, 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) -1, (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test325");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 10, (-1));
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 100, (float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test326");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, 100, (int) (byte) 100);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test327");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        schedule0.finishProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test328");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test329");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        schedule0.blockProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test330");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) 'a', (int) (byte) -1);
        schedule3.finishProcess();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n");
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test331");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) (short) 10, 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test332");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n");
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test333");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test334");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) ' ', (float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test335");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) (byte) -1, (int) (byte) 1);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test336");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test337");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test338");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test339");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        java.lang.String str8 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 0   |  Last: Visited  |  mem_count: 99\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 109\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 0   |  Last: Visited  |  mem_count: 99\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 109\n");
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test340");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test341");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test342");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test343");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (byte) 0, (int) (byte) 0);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test344");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test345");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test346");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        java.lang.String str13 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test347");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) '4', (int) (short) 10);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test348");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(10, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test349");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test350");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 100, (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test351");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test352");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) '#', 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test353");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test354");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str6 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test355");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.unblockProcess(0.0f);
        schedule3.finishProcess();
        schedule3.unblockProcess(1.0f);
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test356");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, 0, 100);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test357");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess(10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test358");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess(10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test359");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test360");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.unblockProcess((float) 0L);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test361");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) ' ');
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test362");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.Class<?> wildcardClass1 = schedule0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test363");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.String str7 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test364");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 1\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 1   |  Last: Visited  |  mem_count: 34\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 66\n" + "'", str7, "curProc: 1\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 1   |  Last: Visited  |  mem_count: 34\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 66\n");
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test365");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess(1.0f);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test366");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) 0);
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test367");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 10, 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test368");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (byte) 0, (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test369");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) (byte) 10, (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test370");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) -1, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test371");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) (byte) 0);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test372");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test373");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (-1), (int) (short) 10);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test374");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) '#', (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test375");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (-1), 100);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test376");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test377");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test378");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        java.lang.String str9 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test379");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test380");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test381");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) 1);
        schedule3.finishProcess();
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test382");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass11 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test383");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.blockProcess();
        java.lang.String str5 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str5, "curProc: 0\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test384");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 10, 0);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n");
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test385");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) (short) 10, 0);
        schedule3.blockProcess();
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test386");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, (int) (short) 100, (int) (short) 1);
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test387");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, (-1), (int) ' ');
        schedule3.blockProcess();
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test388");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, (int) (short) 100, (int) '4');
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test389");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        schedule0.unblockProcess(0.0f);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test390");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (-1), (int) (short) 10);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test391");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 10, (-1));
        schedule3.upgradeProcessPrio((int) (short) 1, (float) 0L);
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test392");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (short) 0, 0);
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test393");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.finishProcess();
        schedule0.quantumExpire();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test394");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, (int) ' ', (int) (short) 10);
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test395");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.String str9 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test396");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(10, (float) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test397");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        java.lang.String str13 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test398");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test399");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test400");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(0, (float) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test401");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.blockProcess();
        java.lang.String str13 = schedule3.toString();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test402");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        java.lang.String str9 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 2\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 110   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 2\n");
    }

    @Test
    public void test403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test403");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, 10, (int) 'a');
        schedule3.quantumExpire();
    }

    @Test
    public void test404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test404");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str11 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test405");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test406");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(10, (int) (byte) 10, (int) '#');
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test407");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess(0.0f);
        schedule3.finishProcess();
        java.lang.String str14 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str14, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test408");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 0, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test409");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, (int) (byte) 0, 0);
    }

    @Test
    public void test410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test410");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, 10);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test411");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        schedule3.unblockProcess(0.0f);
        schedule3.unblockProcess(0.0f);
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test412");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test413");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test414");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.String str9 = schedule3.toString();
        java.lang.String str10 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test415");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        schedule0.upgradeProcessPrio((int) (byte) 1, (float) 1L);
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) '#', (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test416");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test417");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 10, (int) (short) 0);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44   |  Last: Visited  |  mem_count: 10\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 45\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44   |  Last: Visited  |  mem_count: 10\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 45\n");
    }

    @Test
    public void test418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test418");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) '#', (int) '4');
    }

    @Test
    public void test419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test419");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test420");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test421() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test421");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test422");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess(10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test423");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        java.lang.String str11 = schedule3.toString();
        schedule3.unblockProcess(1.0f);
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test424");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test425");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test426");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        java.lang.String str13 = schedule3.toString();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test427");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 1, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test428");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test429");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test430");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.addProcess(1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test431");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        java.lang.String str10 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test432");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', (int) ' ', (int) (short) 10);
    }

    @Test
    public void test433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test433");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        java.lang.String str11 = schedule3.toString();
        java.lang.String str12 = schedule3.toString();
        java.lang.String str13 = schedule3.toString();
        schedule3.unblockProcess((float) 0L);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str12, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test434");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test435");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        schedule0.blockProcess();
        schedule0.upgradeProcessPrio((int) (byte) 1, (float) 1L);
        java.lang.Class<?> wildcardClass5 = schedule0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test436");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        java.lang.String str9 = schedule3.toString();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 2\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 110   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 2\n");
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test437");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (byte) -1, (int) (short) 10);
    }

    @Test
    public void test438() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test438");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test439() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test439");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 100, (int) (byte) 0, (int) 'a');
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test440() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test440");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test441() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test441");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test442() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test442");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test443() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test443");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test444() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test444");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        java.lang.String str11 = schedule3.toString();
        java.lang.String str12 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str12, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test445() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test445");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test446() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test446");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test447() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test447");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.upgradeProcessPrio((int) (byte) 1, (float) (byte) 0);
    }

    @Test
    public void test448() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test448");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test449() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test449");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        java.lang.Class<?> wildcardClass15 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test450() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test450");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test451() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test451");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (-1), (int) (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test452() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test452");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        schedule3.quantumExpire();
        schedule3.upgradeProcessPrio((int) (short) 1, (float) 0L);
    }

    @Test
    public void test453() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test453");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 0, 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test454() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test454");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 100, (int) '4', 10);
    }

    @Test
    public void test455() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test455");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) '#', 10);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test456() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test456");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test457() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test457");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 1, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test458() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test458");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test459() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test459");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (short) 100, (int) (byte) 10);
    }

    @Test
    public void test460() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test460");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test461() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test461");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test462() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test462");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, 10, (int) (byte) -1);
        schedule3.blockProcess();
    }

    @Test
    public void test463() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test463");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(10, 0, (int) (byte) 100);
        schedule3.finishProcess();
    }

    @Test
    public void test464() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test464");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 0, (int) '4');
        schedule3.addProcess(1);
    }

    @Test
    public void test465() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test465");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        java.lang.String str10 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test466() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test466");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test467() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test467");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test468() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test468");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test469() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test469");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess(1.0f);
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test470() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test470");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (byte) 100);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test471() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test471");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test472() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test472");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test473() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test473");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138 139 140 141 142 143 144 145 146 147 148 149 150 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181 182 183 184 185 186 187 188 189 190 191 192 193 194 195 196 197 198 199 200 201 202 203 204 205 206 207 208 209   |  Last: Visited  |  mem_count: 100\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 210\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138 139 140 141 142 143 144 145 146 147 148 149 150 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181 182 183 184 185 186 187 188 189 190 191 192 193 194 195 196 197 198 199 200 201 202 203 204 205 206 207 208 209   |  Last: Visited  |  mem_count: 100\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 210\n");
    }

    @Test
    public void test474() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test474");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) 'a', 1);
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) 1L);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 97   |  Last: Visited  |  mem_count: 1\nprio_2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 98\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 97   |  Last: Visited  |  mem_count: 1\nprio_2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 98\n");
    }

    @Test
    public void test475() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test475");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (int) (short) -1, (int) (short) 10);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test476() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test476");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        java.lang.String str5 = schedule3.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test477() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test477");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.unblockProcess(0.0f);
        schedule3.finishProcess();
        schedule3.blockProcess();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test478() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test478");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) 'a', (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test479() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test479");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (-1), (int) (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 10, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test480() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test480");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, (-1), (int) ' ');
        schedule3.finishAllProcesses();
    }

    @Test
    public void test481() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test481");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, 10);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 10\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 10\n");
    }

    @Test
    public void test482() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test482");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test483() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test483");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test484() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test484");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test485() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test485");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n");
    }

    @Test
    public void test486() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test486");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test487() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test487");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        schedule3.blockProcess();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 9\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 20\n" + "'", str5, "curProc: 0\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 9\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 20\n");
    }

    @Test
    public void test488() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test488");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test489() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test489");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        java.lang.String str13 = schedule3.toString();
        java.lang.String str14 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str13, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str14, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test490() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test490");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, (float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test491() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test491");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test492() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test492");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test493() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test493");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', (int) (short) 1, (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test494() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test494");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (-1), (int) '4');
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test495() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test495");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((int) (short) 1);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 100, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test496() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test496");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test497() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test497");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) ' ', (int) (short) 10, 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 10, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test498() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test498");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test499() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test499");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test500() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test500");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', 1, 10);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test501");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        schedule0.quantumExpire();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test502");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, (-1), 100);
        java.lang.String str4 = schedule3.toString();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 100\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 100\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test503");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 1, 100, (int) (short) 1);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test504");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, 0, 100);
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test505");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 0, (float) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test506");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) 'a', (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 0, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test507");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 1, 1, (int) '4');
        schedule3.quantumExpire();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53   |  Last: Visited  |  mem_count: 52\nprio_2: 1   |  Last: Visited  |  mem_count: 1\nprio_3: 0   |  Last: Visited  |  mem_count: 1\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 54\n" + "'", str5, "curProc: 0\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53   |  Last: Visited  |  mem_count: 52\nprio_2: 1   |  Last: Visited  |  mem_count: 1\nprio_3: 0   |  Last: Visited  |  mem_count: 1\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 54\n");
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test508");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, (int) (byte) 100, 1);
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test509");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (byte) 10, (float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test510");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test511");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.quantumExpire();
        java.lang.String str5 = schedule3.toString();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str5, "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test512");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test513");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, (int) (short) -1, (int) '4');
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test514");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test515");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        java.lang.String str6 = schedule3.toString();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test516");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test517");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test518");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 100, (float) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test519");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 0, 0);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test520");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test521");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        schedule0.unblockProcess((float) (short) 0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test522");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, 1, (int) (byte) 10);
    }

    @Test
    public void test523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test523");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(1, (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test524");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 10, (int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test525");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, (int) (byte) 10, (int) (byte) -1);
    }

    @Test
    public void test526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test526");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 0, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test527");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test528");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.String str9 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test529");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 0, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test530");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 100, (int) '#');
    }

    @Test
    public void test531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test531");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test532");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, 100, (int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(0, (float) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test533");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) (byte) -1, (int) (byte) 1);
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test534");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 10, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test535");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test536");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test537");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        java.lang.String str5 = schedule3.toString();
        schedule3.addProcess((int) (short) 1);
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n");
    }

    @Test
    public void test538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test538");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '4', (int) '#', 100);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138 139 140 141 142 143 144 145 146 147 148 149 150 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181 182 183 184 185 186   |  Last: Visited  |  mem_count: 100\nprio_2: 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86   |  Last: Visited  |  mem_count: 35\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51   |  Last: Visited  |  mem_count: 52\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 187\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138 139 140 141 142 143 144 145 146 147 148 149 150 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181 182 183 184 185 186   |  Last: Visited  |  mem_count: 100\nprio_2: 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86   |  Last: Visited  |  mem_count: 35\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51   |  Last: Visited  |  mem_count: 52\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 187\n");
    }

    @Test
    public void test539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test539");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test540");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 0, 1);
    }

    @Test
    public void test541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test541");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test542");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) (byte) 10, (int) (short) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test543");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test544");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test545");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', (-1), (int) (short) 0);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test546");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        schedule0.blockProcess();
        schedule0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test547() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test547");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 10, 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test548() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test548");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) '4', (int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test549() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test549");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test550() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test550");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        java.lang.String str6 = schedule3.toString();
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: 1\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 97\n" + "'", str6, "curProc: 1\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 1\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 97\n" + "'", str7, "curProc: 1\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 97\n");
    }

    @Test
    public void test551() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test551");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) -1, 0, 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test552() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test552");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str11 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test553() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test553");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.addProcess(1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test554() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test554");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test555() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test555");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test556() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test556");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test557() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test557");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test558() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test558");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, 10, (int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 1, 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test559() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test559");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(100, (int) '4', (int) (short) 1);
    }

    @Test
    public void test560() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test560");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.unblockProcess(0.0f);
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 100, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test561() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test561");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, (int) (byte) 1, (int) (short) 0);
    }

    @Test
    public void test562() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test562");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (short) 0, (int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test563() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test563");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (byte) 100, 10);
        schedule3.finishProcess();
    }

    @Test
    public void test564() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test564");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) -1, (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test565() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test565");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n" + "'", str7, "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n");
    }

    @Test
    public void test566() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test566");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test567() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test567");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test568() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test568");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) 'a', (int) 'a');
        schedule3.blockProcess();
    }

    @Test
    public void test569() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test569");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test570() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test570");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test571() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test571");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test572() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test572");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 10, (int) ' ');
    }

    @Test
    public void test573() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test573");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', (int) (byte) 100, (int) (byte) 10);
    }

    @Test
    public void test574() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test574");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.quantumExpire();
    }

    @Test
    public void test575() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test575");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (byte) -1, (int) (short) 1);
        schedule3.finishProcess();
    }

    @Test
    public void test576() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test576");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, 0, (int) (short) -1);
        schedule3.quantumExpire();
    }

    @Test
    public void test577() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test577");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 96\n");
    }

    @Test
    public void test578() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test578");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) 'a', (-1), (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test579() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test579");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) (short) 0);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test580() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test580");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 100, (int) '4', (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) -1, (float) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test581() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test581");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((int) (short) 1);
        schedule3.upgradeProcessPrio(1, (float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test582() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test582");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (short) 100, (int) (short) -1);
    }

    @Test
    public void test583() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test583");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 10, 1, (int) (short) 10);
    }

    @Test
    public void test584() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test584");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test585() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test585");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.String str7 = schedule3.toString();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test586() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test586");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 0);
        java.lang.String str12 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str12, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test587() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test587");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) 'a', (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test588() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test588");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) (byte) 10, (int) (short) 0);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test589() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test589");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) (byte) 0, (-1));
    }

    @Test
    public void test590() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test590");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        java.lang.String str5 = schedule0.toString();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test591() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test591");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, 100, (int) '4');
    }

    @Test
    public void test592() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test592");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), 10, (-1));
        schedule3.finishProcess();
    }

    @Test
    public void test593() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test593");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio(100, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test594() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test594");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test595() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test595");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((-1), (int) (byte) 100, (int) (byte) 10);
    }

    @Test
    public void test596() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test596");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) (short) 100, 100);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test597() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test597");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio(1, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test598() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test598");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, 10, (int) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test599() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test599");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test600() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test600");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, (int) (byte) 100, 1);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 101   |  Last: Visited  |  mem_count: 1\nprio_2: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100   |  Last: Visited  |  mem_count: 100\nprio_3: 0   |  Last: Visited  |  mem_count: 1\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 102\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 101   |  Last: Visited  |  mem_count: 1\nprio_2: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100   |  Last: Visited  |  mem_count: 100\nprio_3: 0   |  Last: Visited  |  mem_count: 1\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 102\n");
    }

    @Test
    public void test601() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test601");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test602() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test602");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
        java.lang.String str10 = schedule3.toString();
        java.lang.String str11 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test603() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test603");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess(1.0f);
        schedule3.blockProcess();
    }

    @Test
    public void test604() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test604");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, 0, (int) (byte) 0);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test605() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test605");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.String str7 = schedule3.toString();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio(1, 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test606() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test606");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test607() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test607");
        examples.schedule.Schedule schedule0 = new examples.schedule.Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishProcess();
        schedule0.finishProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test608() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test608");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
    }

    @Test
    public void test609() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test609");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (short) -1, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (byte) 1, (float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test610() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test610");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 1);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test611() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test611");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.Class<?> wildcardClass11 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test612() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test612");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, (int) (byte) 10, (int) '4');
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test613() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test613");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(10, 0, 10);
        schedule3.blockProcess();
    }

    @Test
    public void test614() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test614");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, 0, (int) (short) -1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test615() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test615");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test616() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test616");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test617() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test617");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 10, 10, (int) 'a');
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test618() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test618");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test619() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test619");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) (short) 1, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test620() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test620");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 0, (int) '#', 10);
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test621() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test621");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 1, (int) 'a', (int) (short) -1);
    }

    @Test
    public void test622() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test622");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (short) 1, 100, 0);
        schedule3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((int) '#', 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test623() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test623");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        java.lang.String str12 = schedule3.toString();
        schedule3.addProcess(1);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str12, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test624() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test624");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) 0);
        java.lang.String str6 = schedule3.toString();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134   |  Last: Visited  |  mem_count: 100\nprio_2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 135\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134   |  Last: Visited  |  mem_count: 100\nprio_2: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 135\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test625() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test625");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule((int) (byte) 0, (int) (byte) 10, (int) '4');
    }

    @Test
    public void test626() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleTest0.test626");
        examples.schedule.Schedule schedule3 = new examples.schedule.Schedule(1, (int) ' ', (int) (short) -1);
        schedule3.finishAllProcesses();
    }
}

