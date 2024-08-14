package examples.schedulearray;

import org.junit.Test;

public class ScheduleArrayTest {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test001");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test002");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        java.lang.Class<?> wildcardClass1 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test003");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test004");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test005");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test006");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass2 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test007");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test008");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test009");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test010");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) '#', (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test011");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        java.lang.Class<?> wildcardClass3 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test012");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test013");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) 100, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test014");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test015");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((-1), (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test016");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test017");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio(0, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test018");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test019");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 1, 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test020");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test021");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test022");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test023");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test024");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test025");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test026");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 1, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test027");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test028");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio(100, (float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test029");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test030");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test031");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 1, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test032");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test033");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test034");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) -1, (float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test035");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.addProcess((int) (short) 1);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test036");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (byte) 100, 1);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test037");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test038");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test039");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(1, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test040");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test041");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test042");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 0, (float) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test043");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(100, (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test044");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test045");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test046");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test047");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test048");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test049");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test050");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test051");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test052");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test053");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test054");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test055");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((-1), (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test056");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test057");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '#', (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test058");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test059");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((-1), (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test060");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 100, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test061");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test062");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 1, (float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test063");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test064");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test065");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) -1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', (float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test066");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 10, (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test067");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test068");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test069");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test070");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 1, (float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test071");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test072");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) 0, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test073");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) -1, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test074");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test075");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) ' ', 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test076");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 100, (float) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test077");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test078");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '4', (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test079");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, (int) (short) 1, 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test080");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test081");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test082");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (byte) 0, 0);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test083");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test084");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test085");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 100, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test086");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test087");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test088");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test089");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test090");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test091");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test092");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((-1), (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test093");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test094");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 100, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test095");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 100, (float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test096");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test097");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) -1, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test098");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test099");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 0, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test100");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test101");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 0, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test102");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass3 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test103");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test104");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test105");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        java.lang.Class<?> wildcardClass2 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test106");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test107");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test108");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass9 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test109");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test110");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) -1, (int) 'a');
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test111");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 1, (float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test112");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test113");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test114");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test115");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) -1, (float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test116");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) -1, (int) 'a');
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) ' ', (float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test117");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test118");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test119");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test120");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) -1, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) -1, (float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test121");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test122");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (byte) 0, (int) (byte) 1);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test123");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', (float) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test124");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) -1, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test125");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test126");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test127");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) -1, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test128");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test129");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (short) -1);
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test130");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (byte) 1);
        java.lang.Class<?> wildcardClass9 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test131");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) 100, 0);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test132");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test133");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test134");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        java.lang.Class<?> wildcardClass6 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test135");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', (int) (byte) 0, (int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 0, (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test136");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 0, (float) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test137");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test138");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test139");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(0, (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test140");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test141");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (byte) 0, (int) (byte) -1);
        scheduleArray3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test142");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test143");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test144");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test145");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) -1, (int) 'a');
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 10, (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test146");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test147");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) -1, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test148");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test149");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test150");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) -1, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test151");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 1, 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test152");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test153");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test154");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test155");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test156");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(100, (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test157");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        java.lang.Class<?> wildcardClass5 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test158");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test159");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test160");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test161");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        java.lang.Class<?> wildcardClass7 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test162");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, (int) (short) 10, (int) (byte) 1);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test163");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test164");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, 1, (int) (short) 10);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test165");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test166");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test167");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 10, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test168");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test169");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test170");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 10, 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test171");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test172");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test173");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test174");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test175");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) -1, (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test176");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) '#', (int) (short) 100);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test177");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test178");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        java.lang.Class<?> wildcardClass12 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test179");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test180");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((-1), (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test181");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (int) '4', 0);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test182");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test183");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(100, (float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test184");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) '#', 10);
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test185");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) (byte) -1, (-1));
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test186");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        java.lang.Class<?> wildcardClass5 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test187");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test188");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test189");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test190");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (int) (short) 10, (int) (short) 100);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test191");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test192");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.addProcess(1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test193");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishAllProcesses();
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test194");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test195");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test196");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test197");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 100, (int) (short) -1, 100);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test198");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test199");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, 0, 0);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test200");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test201");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test202");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test203");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) ' ', 10);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test204");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test205");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test206");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test207");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test208");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test209");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test210");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) 'a', (int) '4');
        scheduleArray3.finishProcess();
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test211");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test212");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.addProcess((int) (short) 1);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test213");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, 0, 0);
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test214");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, (int) 'a', 1);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test215");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test216");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 100, (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test217");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test218");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) -1, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test219");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test220");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test221");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (short) 1, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test222");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test223");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test224");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio(1, (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test225");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test226");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test227");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test228");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(10, 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test229");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test230");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test231");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess((float) 1L);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test232");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.addProcess(1);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test233");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test234");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) 'a', (int) '4');
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test235");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', (float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test236");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) -1, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test237");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test238");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) -1, 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test239");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.addProcess((int) (byte) 1);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test240");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 0, (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test241");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test242");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test243");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test244");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test245");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test246");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (-1), (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 10, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test247");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test248");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', 1, (-1));
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test249");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) ' ', (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test250");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) ' ', 10);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test251");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test252");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (byte) 0, (int) (byte) -1);
        scheduleArray3.unblockProcess((float) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) -1, (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test253");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 100, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test254");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test255");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test256");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test257");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test258");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(10, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test259");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishAllProcesses();
        java.lang.Class<?> wildcardClass2 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test260");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, 10, (int) 'a');
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test261");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 1, (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test262");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 0, 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test263");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', 10, (int) 'a');
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test264");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, 100, 0);
        scheduleArray3.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test265");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test266");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test267");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test268");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test269");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 1, (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test270");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(0, (float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test271");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test272");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) ' ', 10);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test273");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', 0, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test274");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test275");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (short) 1, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 10, (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test276");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) ' ', 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test277");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test278");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test279");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) 'a', (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test280");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', (int) (short) 1, (int) (short) 1);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test281");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test282");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test283");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test284");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test285");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '4', 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test286");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass10 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test287");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test288");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 1, (int) '#');
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test289");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test290");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, 0, (int) (short) 0);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test291");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 1, (int) '#');
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test292");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 1, (int) '#');
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '4', (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test293");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test294");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 100, (int) (byte) -1);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test295");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (-1), (int) (short) -1);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test296");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((-1), (float) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test297");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test298");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (byte) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test299");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass9 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test300");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) ' ', 0);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test301");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test302");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test303");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.addProcess((int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test304");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.finishProcess();
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test305");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test306");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) -1, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test307");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass10 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test308");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test309");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test310");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) -1, (int) (byte) 10);
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test311");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) '#', 10);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test312");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test313");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test314");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.upgradeProcessPrio((int) (byte) 1, (float) 1);
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test315");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 1, (int) (short) 0);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test316");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test317");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.blockProcess();
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test318");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) (byte) 100, (int) (byte) 0);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test319");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test320");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test321");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(0, (float) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test322");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test323");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, (int) (byte) 1, (int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test324");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.addProcess((int) (short) 1);
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test325");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test326");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test327");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test328");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) '#', 10);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test329");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (short) 10, (int) '4');
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test330");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (byte) 10, (int) (short) 100);
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess((float) 1L);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test331");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.upgradeProcessPrio(1, (float) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) -1, (float) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test332");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test333");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 1, (int) '#');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test334");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 10, (float) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test335");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(0, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test336");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.addProcess(1);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test337");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test338");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test339");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test340");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test341");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess((float) 1);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test342");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        java.lang.Class<?> wildcardClass4 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test343");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test344");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, (int) (byte) 0, (int) (byte) 1);
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test345");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) ' ', (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test346");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test347");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test348");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 0, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test349");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test350");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) '#', (int) '#');
        scheduleArray3.unblockProcess((float) 1L);
        scheduleArray3.finishProcess();
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test351");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test352");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (short) 0);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test353");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) 'a', (int) ' ', (int) ' ');
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test354");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test355");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test356");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test357");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio(0, (float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test358");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 1);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test359");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test360");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.addProcess((int) (short) 1);
        scheduleArray0.blockProcess();
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test361");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test362");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (short) 10, (int) (short) -1);
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test363");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, (int) (short) 100, 0);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test364");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test365");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (byte) 100, (int) (byte) 0);
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test366");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test367");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test368");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, (int) (short) 10, 1);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test369");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) (byte) -1, (int) ' ');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test370");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((-1), 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test371");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 1, (-1), (int) (byte) 0);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test372");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test373");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, 0, (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test374");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (short) 1, 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test375");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', 0, (int) 'a');
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test376");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test377");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess((float) 1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test378");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, 1, (-1));
        scheduleArray3.unblockProcess((float) 0L);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test379");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test380");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, 10, 100);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test381");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, 100, (int) (short) 100);
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test382");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) (byte) -1, (int) ' ');
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test383");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test384");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test385");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.addProcess((int) (short) 1);
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test386");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 10, (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test387");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test388");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (byte) 0, (int) (byte) -1);
        scheduleArray3.unblockProcess((float) 0);
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test389");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test390");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 10, (int) (short) 1);
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test391");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test392");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) '#', 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((-1), (float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test393");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (byte) 10, (int) ' ');
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test394");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        scheduleArray0.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test395");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, (int) (byte) 1, (int) (byte) 100);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test396");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) ' ', (int) ' ');
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '#', (float) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test397");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 1, 0);
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test398");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 1, 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test399");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) 'a', (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test400");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test401");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test402");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test403");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, 0, (int) (short) 0);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test404");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.addProcess(1);
    }

    @Test
    public void test405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test405");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test406");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test407");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test408");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, 0, (int) (short) 0);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.unblockProcess((float) 0L);
    }

    @Test
    public void test409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test409");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 1);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test410");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test411");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', 0, (int) (byte) 0);
    }

    @Test
    public void test412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test412");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) (byte) -1, (int) 'a');
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test413");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (int) (short) 10, (int) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test414");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test415");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test416");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass3 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test417");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.addProcess(1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) 1, 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test418");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.addProcess(1);
    }

    @Test
    public void test419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test419");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', (int) '#', 10);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test420");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test421() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test421");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test422");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (int) (short) 1, (int) (short) 0);
    }

    @Test
    public void test423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test423");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test424");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', 100, 0);
    }

    @Test
    public void test425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test425");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (byte) 100, (int) '4');
    }

    @Test
    public void test426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test426");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) 0);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test427");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) (byte) 1, (int) (short) 1);
    }

    @Test
    public void test428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test428");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) 'a', (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test429");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, 0, (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test430");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test431");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) -1, (int) (short) 10);
        scheduleArray3.finishProcess();
    }

    @Test
    public void test432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test432");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 100, 1);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test433");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, 0, (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test434");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '4', (int) (byte) 0, (int) (byte) -1);
        scheduleArray3.unblockProcess((float) 0);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test435");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) (byte) 1, (int) (byte) 1);
    }

    @Test
    public void test436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test436");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test437");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test438() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test438");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test439() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test439");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test440() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test440");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) 'a', (int) (byte) -1);
    }

    @Test
    public void test441() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test441");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test442() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test442");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '4', (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test443() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test443");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test444() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test444");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.addProcess((int) (short) 1);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 0, (float) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test445() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test445");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (short) 100, (float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test446() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test446");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test447() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test447");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (byte) 1);
        scheduleArray3.finishProcess();
    }

    @Test
    public void test448() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test448");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test449() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test449");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test450() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test450");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.addProcess((int) (short) 1);
    }

    @Test
    public void test451() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test451");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.addProcess((int) (byte) 1);
    }

    @Test
    public void test452() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test452");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test453() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test453");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test454() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test454");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test455() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test455");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess((float) 1L);
        java.lang.Class<?> wildcardClass8 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test456() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test456");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (-1), (-1));
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test457() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test457");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test458() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test458");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', (int) '#', 10);
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass5 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test459() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test459");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test460() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test460");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test461() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test461");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test462() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test462");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 1, (int) '#');
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test463() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test463");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test464() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test464");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test465() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test465");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 0, (float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test466() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test466");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test467() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test467");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test468() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test468");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess((float) (byte) 0);
    }

    @Test
    public void test469() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test469");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(1, (int) 'a', (int) '4');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test470() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test470");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        java.lang.Class<?> wildcardClass9 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test471() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test471");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) 10, (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test472() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test472");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', 10, (int) (byte) 10);
    }

    @Test
    public void test473() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test473");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test474() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test474");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test475() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test475");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 1, 1);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test476() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test476");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) (byte) -1, (int) ' ');
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 10, (float) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test477() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test477");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test478() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test478");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test479() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test479");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) 1);
    }

    @Test
    public void test480() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test480");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) (short) 10, (int) '4');
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test481() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test481");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) 0L);
    }

    @Test
    public void test482() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test482");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.addProcess((int) (byte) 1);
    }

    @Test
    public void test483() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test483");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (short) 1, (int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.upgradeProcessPrio(1, (float) 1L);
    }

    @Test
    public void test484() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test484");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) '#', 0);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test485() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test485");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test486() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test486");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.unblockProcess((float) 0);
    }

    @Test
    public void test487() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test487");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(10, (float) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test488() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test488");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test489() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test489");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, 1, (int) '4');
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test490() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test490");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test491() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test491");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test492() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test492");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 100, (int) (byte) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test493() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test493");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) -1, (float) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test494() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test494");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test495() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test495");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test496() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test496");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test497() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test497");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (short) 100, (int) (short) 0);
    }

    @Test
    public void test498() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test498");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 1);
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess((float) (byte) 0);
    }

    @Test
    public void test499() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test499");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '#', (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test500() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test500");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 100, (int) (short) 1, (int) (short) 100);
    }

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test501");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (short) 1, (int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test502");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test503");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, 1, (int) '4');
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test504");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test505");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test506");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 100, 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((-1), (float) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test507");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass12 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test508");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), 0, (int) ' ');
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test509");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 1);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test510");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test511");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test512");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess(10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test513");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (byte) 0);
        java.lang.Class<?> wildcardClass9 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test514");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, 10, (int) (short) 100);
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test515");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test516");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, 10, 100);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(0, (float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test517");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test518");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test519");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, 0, (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test520");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test521");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, (int) (short) 1, 1);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test522");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.addProcess((int) (short) 1);
        scheduleArray0.finishProcess();
    }

    @Test
    public void test523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test523");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (short) -1);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 10, (float) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test524");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) '#', (int) '#');
        scheduleArray3.unblockProcess((float) 1L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) -1, (float) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test525");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.upgradeProcessPrio(1, (float) (byte) 0);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test526");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test527");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(0.0f);
        java.lang.Class<?> wildcardClass12 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test528");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test529");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test530");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test531");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) 'a', (int) (short) 10, (int) (byte) 0);
    }

    @Test
    public void test532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test532");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test533");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, (int) 'a', (int) '4');
    }

    @Test
    public void test534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test534");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (short) -1, (int) 'a');
    }

    @Test
    public void test535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test535");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test536");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test537");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.addProcess((int) (short) 1);
    }

    @Test
    public void test538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test538");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) 'a', (-1));
    }

    @Test
    public void test539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test539");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (-1), (-1));
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test540");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.blockProcess();
    }

    @Test
    public void test541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test541");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) (byte) 100, (int) 'a');
        scheduleArray3.upgradeProcessPrio((int) (byte) 1, (float) 0L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) ' ', 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test542");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.addProcess(10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test543");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        java.lang.Class<?> wildcardClass8 = scheduleArray0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test544");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (-1), (int) '4');
    }

    @Test
    public void test545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test545");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, 1, 100);
    }

    @Test
    public void test546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test546");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) 10, (float) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test547() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test547");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 10, (float) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test548() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test548");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test549() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test549");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test550() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test550");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test551() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test551");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (-1), (int) (short) 1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test552() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test552");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (short) -1);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) 'a', (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test553() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test553");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 100, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test554() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test554");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 1);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test555() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test555");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) ' ', (float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test556() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test556");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 1, 100, (int) '4');
    }

    @Test
    public void test557() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test557");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 1, (int) '#');
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test558() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test558");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test559() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test559");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (short) 1, (int) '4');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test560() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test560");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) ' ', (int) (byte) 10);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test561() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test561");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test562() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test562");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test563() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test563");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 1);
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
        scheduleArray0.finishAllProcesses();
    }

    @Test
    public void test564() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test564");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, 100, 0);
        scheduleArray3.unblockProcess((float) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) (byte) 100, 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test565() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test565");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) (byte) 100, (int) 'a');
        scheduleArray3.upgradeProcessPrio((int) (byte) 1, (float) 0L);
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(100, (float) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test566() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test566");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test567() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test567");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test568() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test568");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test569() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test569");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (byte) 0, (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test570() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test570");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test571() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test571");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test572() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test572");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.unblockProcess((float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.unblockProcess((float) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test573() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test573");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess((float) 1L);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((int) '#', (float) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test574() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test574");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (int) '4', 0);
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test575() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test575");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test576() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test576");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.unblockProcess((float) (byte) 0);
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test577() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test577");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test578() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test578");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (-1), (int) (short) 0);
    }

    @Test
    public void test579() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test579");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test580() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test580");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test581() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test581");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 1, 0);
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio(0, (float) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test582() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test582");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.addProcess((int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test583() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test583");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 0, 10);
    }

    @Test
    public void test584() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test584");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (short) -1);
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test585() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test585");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test586() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test586");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) 0);
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
    }

    @Test
    public void test587() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test587");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.finishAllProcesses();
    }

    @Test
    public void test588() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test588");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, 0, (int) (short) 10);
    }

    @Test
    public void test589() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test589");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test590() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test590");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 100, (int) 'a');
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test591() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test591");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test592() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test592");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.upgradeProcessPrio(1, (float) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test593() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test593");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.addProcess((int) (short) 1);
    }

    @Test
    public void test594() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test594");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, 10, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test595() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test595");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
    }

    @Test
    public void test596() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test596");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (byte) 10, (int) (byte) 10);
    }

    @Test
    public void test597() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test597");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.unblockProcess((float) 0L);
        scheduleArray0.finishProcess();
        scheduleArray0.finishProcess();
    }

    @Test
    public void test598() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test598");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) ' ', (int) ' ');
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test599() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test599");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 0, (int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass6 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test600() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test600");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) '#', 0);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test601() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test601");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (short) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test602() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test602");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(10, (int) (short) 10, (int) (byte) -1);
        scheduleArray3.blockProcess();
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test603() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test603");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.quantumExpire();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.unblockProcess((float) (byte) 1);
        scheduleArray3.quantumExpire();
        scheduleArray3.unblockProcess(0.0f);
        scheduleArray3.finishProcess();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test604() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test604");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test605() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test605");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (short) 1, (int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess(0.0f);
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.unblockProcess((float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test606() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test606");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(0, (int) (short) 0, 0);
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.quantumExpire();
        scheduleArray3.unblockProcess((float) 0);
    }

    @Test
    public void test607() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test607");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.finishProcess();
        scheduleArray0.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray0.upgradeProcessPrio((int) (short) 0, (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test608() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test608");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', (int) (short) -1, (int) (short) 100);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test609() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test609");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) '#', 0);
        scheduleArray3.quantumExpire();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test610() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test610");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 100, (int) ' ', (int) (byte) 100);
    }

    @Test
    public void test611() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test611");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test612() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test612");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) '#', 0);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test613() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test613");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', (int) '#', 10);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test614() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test614");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test615() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test615");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 10, (int) (short) 0, (int) (byte) 1);
    }

    @Test
    public void test616() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test616");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', 0, (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
    }

    @Test
    public void test617() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test617");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.unblockProcess(1.0f);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test618() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test618");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray(100, (int) '#', 10);
        scheduleArray3.addProcess((int) (short) 1);
        scheduleArray3.unblockProcess(1.0f);
    }

    @Test
    public void test619() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test619");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.addProcess((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test620() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test620");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 1, (int) (short) 1, (int) (short) 100);
        java.lang.Class<?> wildcardClass4 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test621() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test621");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) ' ', (int) (short) 0, (int) (short) 0);
    }

    @Test
    public void test622() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test622");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.finishProcess();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
        scheduleArray0.finishAllProcesses();
        scheduleArray0.blockProcess();
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test623() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test623");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.unblockProcess((float) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
    }

    @Test
    public void test624() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test624");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 10, 0, (int) (byte) 100);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        // The following exception was thrown during execution in test generation
        try {
            scheduleArray3.upgradeProcessPrio((-1), (float) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test625() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test625");
        examples.schedulearray.ScheduleArray scheduleArray0 = new examples.schedulearray.ScheduleArray();
        scheduleArray0.blockProcess();
        scheduleArray0.unblockProcess((float) (short) 1);
        scheduleArray0.unblockProcess((float) (short) 0);
        scheduleArray0.quantumExpire();
    }

    @Test
    public void test626() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test626");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 1, (int) 'a', (int) (byte) -1);
        scheduleArray3.quantumExpire();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test627() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test627");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) '#', 0, (int) (byte) 10);
    }

    @Test
    public void test628() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test628");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.quantumExpire();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.unblockProcess((float) 1);
        scheduleArray3.blockProcess();
    }

    @Test
    public void test629() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test629");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 100, (-1), (int) (short) 100);
    }

    @Test
    public void test630() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test630");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((-1), (int) (byte) 100, (int) 'a');
        scheduleArray3.upgradeProcessPrio((int) (byte) 1, (float) 0L);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.addProcess(1);
    }

    @Test
    public void test631() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test631");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (short) -1);
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
        java.lang.Class<?> wildcardClass7 = scheduleArray3.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test632() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test632");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) 0, (int) (short) 10, 1);
        scheduleArray3.quantumExpire();
    }

    @Test
    public void test633() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test633");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.addProcess((int) (short) 1);
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test634() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test634");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) 0, (int) '4', (int) (byte) 0);
        scheduleArray3.blockProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.blockProcess();
        scheduleArray3.finishProcess();
    }

    @Test
    public void test635() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test635");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (short) -1, (-1), (int) (byte) 1);
    }

    @Test
    public void test636() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ScheduleArrayTest0.test636");
        examples.schedulearray.ScheduleArray scheduleArray3 = new examples.schedulearray.ScheduleArray((int) (byte) -1, (int) (byte) 100, (int) 'a');
        scheduleArray3.finishProcess();
        scheduleArray3.blockProcess();
        scheduleArray3.finishAllProcesses();
        scheduleArray3.finishProcess();
    }
}

