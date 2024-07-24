package examples.schedule;

import org.junit.Test;

public class ScheduleTest {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test001");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        java.lang.Class<?> wildcardClass2 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test002");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test003");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test004");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test005");
        Schedule schedule3 = new Schedule((int) '#', (int) (short) 1, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test006");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test007");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test008");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test009");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test010");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test011");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test012");
        Schedule schedule3 = new Schedule(100, 1, 1);
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test013");
        Schedule schedule3 = new Schedule((int) '#', (int) (short) 1, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test014");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test015");
        Schedule schedule3 = new Schedule(100, 1, 1);
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test016");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test017");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test018");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test019");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test020");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test021");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test022");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test023");
        Schedule schedule0 = new Schedule();
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
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test024");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test025");
        Schedule schedule3 = new Schedule((int) '#', (int) (short) 1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test026");
        Schedule schedule3 = new Schedule(100, 1, 1);
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
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test027");
        Schedule schedule0 = new Schedule();
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
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test028");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
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
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test029");
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test030");
        Schedule schedule0 = new Schedule();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.upgradeProcessPrio((int) (short) 10, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test031");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test032");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test033");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
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
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test034");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test035");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test036");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) 0, 0);
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
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test037");
        Schedule schedule3 = new Schedule((int) '#', (int) (short) 1, (int) 'a');
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test038");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test039");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
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
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test040");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test041");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test042");
        Schedule schedule0 = new Schedule();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass2 = schedule0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test043");
        Schedule schedule3 = new Schedule((int) ' ', (int) '#', (int) (byte) 10);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test044");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) 1);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test045");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test046");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test047");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test048");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test049");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass4 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test050");
        Schedule schedule3 = new Schedule((int) (byte) 1, (int) (byte) 100, 1);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test051");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test052");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test053");
        Schedule schedule0 = new Schedule();
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
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test054");
        Schedule schedule0 = new Schedule();
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
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test055");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test056");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test057");
        Schedule schedule3 = new Schedule((int) '#', (int) (short) 10, (int) (short) 0);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test058");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test059");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test060");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        java.lang.String str6 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: 1\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 97\n" + "'", str6, "curProc: 1\nprio_0: null\nprio_1: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 96\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 97\n");
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test061");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test062");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test063");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test064");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test065");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test066");
        Schedule schedule3 = new Schedule(10, (int) (short) 10, (int) (byte) -1);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test067");
        Schedule schedule0 = new Schedule();
        // The following exception was thrown during execution in test generation
        try {
            schedule0.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test068");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test069");
        Schedule schedule0 = new Schedule();
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
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test070");
        Schedule schedule3 = new Schedule((int) (byte) 10, (int) (short) 10, 0);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test071");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test072");
        Schedule schedule0 = new Schedule();
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
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test073");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test074");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test075");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test076");
        Schedule schedule0 = new Schedule();
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
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test077");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
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
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test078");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test079");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test080");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
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
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test081");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test082");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test083");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.quantumExpire();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str5, "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test084");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test085");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test086");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test087");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test088");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test089");
        Schedule schedule3 = new Schedule(100, 1, 1);
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
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test090");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass4 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test091");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        java.lang.String str9 = schedule3.toString();
        java.lang.String str10 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test092");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test093");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test094");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test095");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test096");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.blockProcess();
        schedule0.blockProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test097");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) 0);
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test098");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test099");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test100");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test101");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass10 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test102");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test103");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test104");
        Schedule schedule0 = new Schedule();
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
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test105");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        java.lang.String str6 = schedule3.toString();
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test106");
        Schedule schedule0 = new Schedule();
        schedule0.quantumExpire();
        java.lang.Class<?> wildcardClass2 = schedule0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test107");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test108");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test109");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test110");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test111");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test112");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) -1, 1);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test113");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test114");
        Schedule schedule0 = new Schedule();
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
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test115");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test116");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((int) (short) 1);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test117");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test118");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.unblockProcess((float) (short) 1);
        java.lang.String str6 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test119");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test120");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.String str8 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test121");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test122");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test123");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) 0, 0);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test124");
        Schedule schedule3 = new Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test125");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test126");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test127");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test128");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) (byte) -1, (int) (short) 10);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test129");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test130");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.finishAllProcesses();
        java.lang.String str4 = schedule0.toString();
        schedule0.finishAllProcesses();
        java.lang.String str6 = schedule0.toString();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str6, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test131");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
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
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test132");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test133");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishAllProcesses();
        schedule0.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test134");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
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
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test135");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test136");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test137");
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass8 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test138");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.blockProcess();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test139");
        Schedule schedule3 = new Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 20\n");
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test140");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        java.lang.String str11 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str11, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test141");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test142");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test143");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.blockProcess();
        java.lang.Class<?> wildcardClass5 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test144");
        Schedule schedule3 = new Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test145");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
        java.lang.String str7 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str7, "curProc: 0\nprio_0: null\nprio_1: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 0   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test146");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.blockProcess();
        schedule0.finishProcess();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test147");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test148");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test149");
        Schedule schedule3 = new Schedule((int) ' ', (int) (short) 10, 100);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test150");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) -1, 1);
        schedule3.blockProcess();
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test151");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test152");
        Schedule schedule3 = new Schedule(10, 0, (int) (byte) 100);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test153");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test154");
        Schedule schedule3 = new Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
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
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test155");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test156");
        Schedule schedule3 = new Schedule((int) (short) 0, (-1), (int) (short) 100);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test157");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test158");
        Schedule schedule0 = new Schedule();
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
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test159");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) (byte) 0, (int) '#');
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test160");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test161");
        Schedule schedule3 = new Schedule((int) (short) 0, (int) '#', 10);
        java.lang.Class<?> wildcardClass4 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test162");
        Schedule schedule3 = new Schedule((int) (byte) 10, (int) (short) 0, (int) (short) 10);
        schedule3.finishProcess();
        java.lang.String str5 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 9\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 19\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: 10 11 12 13 14 15 16 17 18 19   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 9\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 19\n");
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test163");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) (byte) 1);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test164");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test165");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        java.lang.String str3 = schedule0.toString();
        schedule0.unblockProcess((float) 1L);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str3, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test166");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test167");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
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
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test168");
        Schedule schedule3 = new Schedule(100, 1, 1);
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
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test169");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test170");
        Schedule schedule3 = new Schedule((int) (byte) 10, (int) (short) 100, (int) (byte) 100);
        schedule3.unblockProcess(0.0f);
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test171");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test172");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test173");
        Schedule schedule3 = new Schedule((int) (short) 0, (int) '#', 10);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.upgradeProcessPrio((-1), (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test174");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test175");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test176");
        Schedule schedule3 = new Schedule(0, (-1), (int) (short) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test177");
        Schedule schedule3 = new Schedule((int) (short) -1, (int) (short) -1, (int) (short) 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test178");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test179");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test180");
        Schedule schedule3 = new Schedule((int) 'a', 1, 10);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test181");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        java.lang.String str4 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 1\n");
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test182");
        Schedule schedule3 = new Schedule((int) (short) 1, (int) (short) -1, (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            schedule3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test183");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass5 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test184");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass6 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test185");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) 0, 0);
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
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test186");
        Schedule schedule3 = new Schedule((-1), 0, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test187");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
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
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test188");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test189");
        Schedule schedule3 = new Schedule(0, (int) (byte) -1, (int) (short) 1);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test190");
        Schedule schedule3 = new Schedule((int) (short) 100, (int) (byte) 10, (int) (byte) 0);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test191");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.finishAllProcesses();
        java.lang.String str5 = schedule3.toString();
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str5, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test192");
        Schedule schedule0 = new Schedule();
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
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test193");
        Schedule schedule3 = new Schedule((int) '#', (int) (short) 1, (int) 'a');
        schedule3.finishProcess();
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test194");
        Schedule schedule3 = new Schedule((int) '#', (int) (byte) -1, (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            schedule3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test195");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test196");
        Schedule schedule3 = new Schedule((-1), 0, 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test197");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) -1, 0);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test198");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (short) 0, 0);
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test199");
        Schedule schedule3 = new Schedule(0, (int) (byte) 0, (int) (byte) 1);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test200");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test201");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess(1.0f);
        schedule3.quantumExpire();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test202");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.unblockProcess((float) (byte) 0);
        java.lang.String str9 = schedule3.toString();
        schedule3.unblockProcess((float) (short) 0);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test203");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test204");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test205");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test206");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test207");
        Schedule schedule3 = new Schedule((int) (byte) 1, (int) ' ', (int) (byte) 1);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test208");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test209");
        Schedule schedule3 = new Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test210");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test211");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test212");
        Schedule schedule0 = new Schedule();
        schedule0.quantumExpire();
        java.lang.String str2 = schedule0.toString();
        schedule0.blockProcess();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str2, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test213");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test214");
        Schedule schedule3 = new Schedule((int) (short) 0, (int) 'a', (int) (byte) -1);
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
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test215");
        Schedule schedule3 = new Schedule((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
        schedule3.blockProcess();
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test216");
        Schedule schedule3 = new Schedule((int) (short) 100, 100, 0);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test217");
        Schedule schedule3 = new Schedule(0, (-1), (int) (short) 1);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test218");
        Schedule schedule3 = new Schedule(1, (-1), (int) ' ');
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test219");
        Schedule schedule0 = new Schedule();
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
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test220");
        Schedule schedule0 = new Schedule();
        java.lang.String str1 = schedule0.toString();
        schedule0.quantumExpire();
        schedule0.finishProcess();
        java.lang.Class<?> wildcardClass4 = schedule0.getClass();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str1, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test221");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str7 = schedule3.toString();
        schedule3.unblockProcess((float) 1);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n" + "'", str7, "curProc: 2\nprio_0: null\nprio_1: 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 1   |  Last: Visited  |  mem_count: 95\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0 2   |  Last: Visited  |  mem_count: 2\nnum_processes: 97\n");
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test222");
        Schedule schedule3 = new Schedule((int) (short) -1, (-1), 100);
        schedule3.quantumExpire();
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test223");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test224");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test225");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        java.lang.String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n" + "'", str7, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 1\n");
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test226");
        Schedule schedule3 = new Schedule((int) (short) 10, (int) (byte) 100, (int) (byte) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 110 111 112 113 114 115 116 117 118 119   |  Last: Visited  |  mem_count: 10\nprio_2: 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 100\nprio_3: 0 1 2 3 4 5 6 7 8 9   |  Last: Visited  |  mem_count: 10\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 120\n");
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test227");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
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
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test228");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) 'a', 1);
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
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test229");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 100 101 102 103 104 105 106 107 108 109   |  Last: Visited  |  mem_count: 10\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99   |  Last: Visited  |  mem_count: 100\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 110\n");
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test230");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) (short) 0);
        schedule3.quantumExpire();
        java.lang.Class<?> wildcardClass7 = schedule3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test231");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        java.lang.String str4 = schedule3.toString();
        schedule3.unblockProcess((float) (byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        java.lang.Class<?> wildcardClass9 = schedule3.getClass();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96   |  Last: Visited  |  mem_count: 97\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 97\n");
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test232");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test233");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        java.lang.String str6 = schedule3.toString();
        schedule3.blockProcess();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "curProc: 1\nprio_0: null\nprio_1: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134   |  Last: Visited  |  mem_count: 100\nprio_2: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 0   |  Last: Visited  |  mem_count: 34\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 1   |  Last: Visited  |  mem_count: 1\nnum_processes: 135\n" + "'", str6, "curProc: 1\nprio_0: null\nprio_1: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 126 127 128 129 130 131 132 133 134   |  Last: Visited  |  mem_count: 100\nprio_2: 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 0   |  Last: Visited  |  mem_count: 34\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 1   |  Last: Visited  |  mem_count: 1\nnum_processes: 135\n");
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test234");
        Schedule schedule3 = new Schedule((-1), 100, (int) (short) 0);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test235");
        Schedule schedule3 = new Schedule((int) '#', (int) ' ', (int) (byte) -1);
        java.lang.String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n" + "'", str4, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66   |  Last: Visited  |  mem_count: 32\nprio_3: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34   |  Last: Visited  |  mem_count: 35\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 67\n");
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test236");
        Schedule schedule3 = new Schedule((int) (short) -1, 0, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test237");
        Schedule schedule0 = new Schedule();
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
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test238");
        Schedule schedule3 = new Schedule((int) (short) 100, 0, (int) (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((int) (short) 1);
        java.lang.String str9 = schedule3.toString();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "curProc: null\nprio_0: null\nprio_1: 110   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 2\n" + "'", str9, "curProc: null\nprio_0: null\nprio_1: 110   |  Last: Visited  |  mem_count: 1\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: 0   |  Last: Visited  |  mem_count: 1\nnum_processes: 2\n");
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test239");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        java.lang.String str8 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.unblockProcess((float) (byte) 0);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str8, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test240");
        Schedule schedule3 = new Schedule((int) '#', (int) ' ', (int) (byte) -1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test241");
        Schedule schedule3 = new Schedule((int) (short) 1, (int) 'a', (int) (byte) 10);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test242");
        Schedule schedule3 = new Schedule((int) (short) -1, (-1), 100);
        schedule3.finishProcess();
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test243");
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test244");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test245");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test246");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        java.lang.String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n" + "'", str10, "curProc: null\nprio_0: null\nprio_1: Empty  |  Last: null!  |  mem_count: 0\nprio_2: Empty  |  Last: null!  |  mem_count: 0\nprio_3: Empty  |  Last: null!  |  mem_count: 0\nblockQueue: Empty  |  Last: null!  |  mem_count: 0\nnum_processes: 0\n");
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test247");
        Schedule schedule3 = new Schedule((int) (byte) -1, (int) '#', (int) (short) 100);
        schedule3.unblockProcess((float) 0);
        schedule3.quantumExpire();
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test248");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test249");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleRandoopTest0.test250");
        Schedule schedule3 = new Schedule(0, 0, (int) 'a');
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
}

