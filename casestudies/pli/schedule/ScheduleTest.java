package casestudies.pli.schedule;

import org.junit.Test;

public class ScheduleTest {

    @Test
    public void test001() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        Class<?> wildcardClass2 = schedule3.getClass();
    }

    @Test
    public void test002() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test003() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
    }

    @Test
    public void test004() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
    }

    @Test
    public void test005() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
    }

    @Test
    public void test006() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test007() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test008() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
    }

    @Test
    public void test009() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test010() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
    }

    @Test
    public void test011() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        schedule3.quantumExpire();
    }

    @Test
    public void test012() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
    }

    @Test
    public void test013() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
    }

    @Test
    public void test014() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
    }

    @Test
    public void test015() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
    }

    @Test
    public void test016() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
    }

    @Test
    public void test017() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test018() throws Throwable {
        Schedule schedule3 = new Schedule();
    }

    @Test
    public void test019() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
    }

    @Test
    public void test020() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
    }

    @Test
    public void test021() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test022() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test023() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test024() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
    }

    @Test
    public void test025() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.quantumExpire();
    }

    @Test
    public void test026() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test027() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test028() throws Throwable {
        Schedule schedule3 = new Schedule();
    }

    @Test
    public void test029() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test030() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test031() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test032() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test033() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
    }

    @Test
    public void test034() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test035() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test036() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test037() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        schedule3.quantumExpire();
    }

    @Test
    public void test038() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
    }

    @Test
    public void test039() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test040() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        Class<?> wildcardClass2 = schedule3.getClass();
    }

    @Test
    public void test041() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
    }

    @Test
    public void test042() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
    }

    @Test
    public void test043() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
    }

    @Test
    public void test044() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test045() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test046() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test047() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test048() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test049() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
    }

    @Test
    public void test050() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
    }

    @Test
    public void test051() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
    }

    @Test
    public void test052() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
    }

    @Test
    public void test053() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test054() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
    }

    @Test
    public void test055() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test056() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test057() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test058() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test059() throws Throwable {
        Schedule schedule3 = new Schedule();
    }

    @Test
    public void test060() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test061() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test062() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test063() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test064() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
    }

    @Test
    public void test065() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test066() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
    }

    @Test
    public void test067() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
    }

    @Test
    public void test068() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test069() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
    }

    @Test
    public void test070() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        String str4 = schedule3.toString();
    }

    @Test
    public void test071() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test072() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test073() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test074() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.quantumExpire();
    }

    @Test
    public void test075() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test076() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test077() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test078() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test079() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((float) 0);
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test080() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test081() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test082() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        Class<?> wildcardClass12 = schedule3.getClass();
    }

    @Test
    public void test083() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test084() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test085() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
    }

    @Test
    public void test086() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        String str7 = schedule3.toString();
    }

    @Test
    public void test087() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        Class<?> wildcardClass2 = schedule3.getClass();
    }

    @Test
    public void test088() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
    }

    @Test
    public void test089() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) -1,
                1);
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test090() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((short) 1);
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test091() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
    }

    @Test
    public void test092() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
    }

    @Test
    public void test093() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
        String str6 = schedule3.toString();
    }

    @Test
    public void test094() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test095() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test096() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
        schedule3.quantumExpire();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test097() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test098() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishProcess();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test099() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.quantumExpire();
    }

    @Test
    public void test100() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
    }

    @Test
    public void test101() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test102() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
    }

    @Test
    public void test103() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test104() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test105() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test106() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test107() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test108() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test109() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test110() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) -1,
                1);
        schedule3.blockProcess();
    }

    @Test
    public void test111() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
    }

    @Test
    public void test112() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
    }

    @Test
    public void test113() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test114() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test115() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, (-1),
                (short) 100);
    }

    @Test
    public void test116() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test117() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, '#', 10);
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test118() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
        schedule3.finishProcess();
        String str5 = schedule3.toString();
    }

    @Test
    public void test119() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.finishProcess();
        String str8 = schedule3.toString();
    }

    @Test
    public void test120() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test121() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
        schedule3.blockProcess();
        String str13 = schedule3.toString();
    }

    @Test
    public void test122() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        schedule3.quantumExpire();
    }

    @Test
    public void test123() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test124() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test125() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 100,
                (byte) 100);
        schedule3.unblockProcess(0.0f);
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test126() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test127() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test128() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, '#', 10);
    }

    @Test
    public void test129() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
    }

    @Test
    public void test130() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
        schedule3.quantumExpire();
        String str13 = schedule3.toString();
    }

    @Test
    public void test131() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (short) -1,
                (short) 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test132() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.unblockProcess((byte) 1);
    }

    @Test
    public void test133() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test134() throws Throwable {
        Schedule schedule3 = new Schedule((short) 1, (short) -1,
                (short) 1);
    }

    @Test
    public void test135() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.quantumExpire();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test136() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test137() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test138() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test139() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test140() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, (byte) 10,
                (byte) 0);
    }

    @Test
    public void test141() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
    }

    @Test
    public void test142() throws Throwable {
        Schedule schedule3 = new Schedule('#', (byte) -1,
                '#');
    }

    @Test
    public void test143() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        String str8 = schedule3.toString();
    }

    @Test
    public void test144() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test145() throws Throwable {
        Schedule schedule3 = new Schedule(0, (byte) 0, (byte) 1);
    }

    @Test
    public void test146() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
    }

    @Test
    public void test147() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test148() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test149() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, ' ',
                (byte) 1);
    }

    @Test
    public void test150() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test151() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test152() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        String str2 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test153() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test154() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 'a',
                (byte) -1);
        schedule3.finishProcess();
    }

    @Test
    public void test155() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 100, 0);
    }

    @Test
    public void test156() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((short) 1);
    }

    @Test
    public void test157() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test158() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        String str7 = schedule3.toString();
        schedule3.unblockProcess((float) 1);
    }

    @Test
    public void test159() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test160() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test161() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test162() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        String str4 = schedule3.toString();
    }

    @Test
    public void test163() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test164() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.quantumExpire();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test165() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test166() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test167() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        String str6 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test168() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 100, (short) 0);
    }

    @Test
    public void test169() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
    }

    @Test
    public void test170() throws Throwable {
        Schedule schedule3 = new Schedule((short) 1, 'a',
                (byte) 10);
    }

    @Test
    public void test171() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        String str11 = schedule3.toString();
        schedule3.unblockProcess(1.0f);
        schedule3.quantumExpire();
    }

    @Test
    public void test172() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((float) 0);
        schedule3.quantumExpire();
    }

    @Test
    public void test173() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test174() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
    }

    @Test
    public void test175() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test176() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
    }

    @Test
    public void test177() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
    }

    @Test
    public void test178() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.quantumExpire();
        String str5 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test179() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test180() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((short) 1);
    }

    @Test
    public void test181() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (short) -1,
                (short) 10);
        String str4 = schedule3.toString();
    }

    @Test
    public void test182() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 10,
                0);
        schedule3.finishProcess();
    }

    @Test
    public void test183() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, (byte) 0,
                '#');
    }

    @Test
    public void test184() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test185() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test186() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, (byte) -1,
                (byte) -1);
    }

    @Test
    public void test187() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test188() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test189() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test190() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        String str9 = schedule3.toString();
    }

    @Test
    public void test191() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test192() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass14 = schedule3.getClass();
    }

    @Test
    public void test193() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test194() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test195() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.blockProcess();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test196() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, 100,
                (byte) 10);
    }

    @Test
    public void test197() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess(1);
    }

    @Test
    public void test198() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test199() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test200() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test201() throws Throwable {
        Schedule schedule3 = new Schedule(0, (-1), (short) 1);
    }

    @Test
    public void test202() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
    }

    @Test
    public void test203() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test204() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test205() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test206() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
    }

    @Test
    public void test207() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test208() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test209() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 0, 0);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test210() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.finishAllProcesses();
    }

    @Test
    public void test211() throws Throwable {
        Schedule schedule3 = new Schedule('a', 1, 10);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test212() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test213() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test214() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test215() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test216() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 'a',
                (byte) -1);
    }

    @Test
    public void test217() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 0, 0);
        schedule3.finishProcess();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test218() throws Throwable {
        Schedule schedule3 = new Schedule(10, (short) 10,
                (byte) -1);
        schedule3.quantumExpire();
    }

    @Test
    public void test219() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test220() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 0, 0);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
    }

    @Test
    public void test221() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test222() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test223() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test224() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test225() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test226() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test227() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio((byte) 1, (float) 1L);
        schedule3.blockProcess();
    }

    @Test
    public void test228() throws Throwable {
        Schedule schedule3 = new Schedule(100, '#', 0);
    }

    @Test
    public void test229() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, (byte) 10);
    }

    @Test
    public void test230() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        Class<?> wildcardClass3 = schedule3.getClass();
    }

    @Test
    public void test231() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((short) 1);
    }

    @Test
    public void test232() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((byte) 0);
    }

    @Test
    public void test233() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test234() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
    }

    @Test
    public void test235() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        Class<?> wildcardClass3 = schedule3.getClass();
    }

    @Test
    public void test236() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test237() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test238() throws Throwable {
        Schedule schedule3 = new Schedule('4', 100, 0);
    }

    @Test
    public void test239() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test240() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        String str4 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test241() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test242() throws Throwable {
        Schedule schedule3 = new Schedule(' ', '#',
                (byte) 10);
    }

    @Test
    public void test243() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        schedule3.finishAllProcesses();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test244() throws Throwable {
        Schedule schedule3 = new Schedule(1, 100, 10);
    }

    @Test
    public void test245() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test246() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test247() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test248() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.quantumExpire();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test249() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test250() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 'a',
                (byte) -1);
    }

    @Test
    public void test251() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
    }

    @Test
    public void test252() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test253() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, (short) 1,
                (short) 0);
    }

    @Test
    public void test254() throws Throwable {
        Schedule schedule3 = new Schedule(10, (short) 10, 1);
    }

    @Test
    public void test255() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test256() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
    }

    @Test
    public void test257() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test258() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test259() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test260() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) 1);
        schedule3.blockProcess();
    }

    @Test
    public void test261() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        String str7 = schedule3.toString();
    }

    @Test
    public void test262() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test263() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test264() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test265() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test266() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
        String str7 = schedule3.toString();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test267() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        schedule3.finishProcess();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test268() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        String str4 = schedule3.toString();
        schedule3.quantumExpire();
        String str6 = schedule3.toString();
    }

    @Test
    public void test269() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 100,
                (byte) 100);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test270() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test271() throws Throwable {
        Schedule schedule3 = new Schedule(' ', (byte) 1,
                (short) 10);
    }

    @Test
    public void test272() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test273() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.addProcess(1);
        schedule3.finishProcess();
    }

    @Test
    public void test274() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test275() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
    }

    @Test
    public void test276() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test277() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
    }

    @Test
    public void test278() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test279() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio((byte) 1, (float) 1L);
    }

    @Test
    public void test280() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test281() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test282() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test283() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test284() throws Throwable {
        Schedule schedule3 = new Schedule('a', 1, 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
    }

    @Test
    public void test285() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, 0, 100);
        String str4 = schedule3.toString();
    }

    @Test
    public void test286() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 0, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test287() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
    }

    @Test
    public void test288() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test289() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test290() throws Throwable {
        Schedule schedule3 = new Schedule(0, '#', (short) 100);
    }

    @Test
    public void test291() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test292() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        String str4 = schedule3.toString();
    }

    @Test
    public void test293() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        String str7 = schedule3.toString();
        String str8 = schedule3.toString();
        Class<?> wildcardClass9 = schedule3.getClass();
    }

    @Test
    public void test294() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        String str2 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test295() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, (byte) -1,
                (short) 10);
        schedule3.blockProcess();
    }

    @Test
    public void test296() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test297() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test298() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        String str8 = schedule3.toString();
    }

    @Test
    public void test299() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test300() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        String str4 = schedule3.toString();
    }

    @Test
    public void test301() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 0, 0);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test302() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test303() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test304() throws Throwable {
        Schedule schedule3 = new Schedule(' ', (short) 10, 100);
    }

    @Test
    public void test305() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test306() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test307() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (-1),
                (byte) 10);
    }

    @Test
    public void test308() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test309() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test310() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test311() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test312() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test313() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (short) -1,
                (byte) 10);
    }

    @Test
    public void test314() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        String str4 = schedule3.toString();
    }

    @Test
    public void test315() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((short) 0);
    }

    @Test
    public void test316() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test317() throws Throwable {
        Schedule schedule3 = new Schedule((short) 1, (short) -1,
                (byte) 0);
    }

    @Test
    public void test318() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        String str11 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test319() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test320() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (-1), 100);
        schedule3.quantumExpire();
    }

    @Test
    public void test321() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, ' ',
                'a');
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test322() throws Throwable {
        Schedule schedule3 = new Schedule(100, (byte) 10, '#');
    }

    @Test
    public void test323() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        String str4 = schedule3.toString();
        String str5 = schedule3.toString();
    }

    @Test
    public void test324() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, (byte) 100,
                1);
    }

    @Test
    public void test325() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 10, (-1));
    }

    @Test
    public void test326() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, 100,
                (byte) 100);
    }

    @Test
    public void test327() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test328() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test329() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test330() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 'a',
                (byte) -1);
        schedule3.finishProcess();
        String str5 = schedule3.toString();
    }

    @Test
    public void test331() throws Throwable {
        Schedule schedule3 = new Schedule(' ', (short) 10, 100);
    }

    @Test
    public void test332() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test333() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test334() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
    }

    @Test
    public void test335() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, (byte) -1,
                (byte) 1);
        schedule3.blockProcess();
    }

    @Test
    public void test336() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test337() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test338() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test339() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        String str8 = schedule3.toString();
    }

    @Test
    public void test340() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test341() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        String str5 = schedule3.toString();
    }

    @Test
    public void test342() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test343() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (byte) 0,
                (byte) 0);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test344() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test345() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
    }

    @Test
    public void test346() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        String str13 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test347() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, '4',
                (short) 10);
    }

    @Test
    public void test348() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
    }

    @Test
    public void test349() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
        String str4 = schedule3.toString();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test350() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 10);
    }

    @Test
    public void test351() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) 0, 0);
    }

    @Test
    public void test352() throws Throwable {
        Schedule schedule3 = new Schedule(' ', '#', 10);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test353() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.unblockProcess(0.0f);
        schedule3.quantumExpire();
    }

    @Test
    public void test354() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str6 = schedule3.toString();
    }

    @Test
    public void test355() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.unblockProcess(0.0f);
        schedule3.finishProcess();
        schedule3.unblockProcess(1.0f);
    }

    @Test
    public void test356() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, 0, 100);
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test357() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test358() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 100,
                (byte) 100);
    }

    @Test
    public void test359() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test360() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.unblockProcess((float) 0L);
    }

    @Test
    public void test361() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                ' ');
    }

    @Test
    public void test362() throws Throwable {
        Schedule schedule3 = new Schedule();
        Class<?> wildcardClass1 = schedule3.getClass();
    }

    @Test
    public void test363() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        String str7 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test364() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        String str7 = schedule3.toString();
    }

    @Test
    public void test365() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess(1.0f);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test366() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((float) 0);
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test367() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        String str4 = schedule3.toString();
    }

    @Test
    public void test368() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (byte) 0,
                (byte) 0);
    }

    @Test
    public void test369() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, (byte) 10,
                (short) 0);
    }

    @Test
    public void test370() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) -1,
                0);
    }

    @Test
    public void test371() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((byte) 0);
    }

    @Test
    public void test372() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test373() throws Throwable {
        Schedule schedule3 = new Schedule(0, (-1), (short) 10);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test374() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test375() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (-1), 100);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test376() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.quantumExpire();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test377() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test378() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
        String str9 = schedule3.toString();
    }

    @Test
    public void test379() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test380() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test381() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.unblockProcess((float) 1);
        schedule3.finishProcess();
    }

    @Test
    public void test382() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass11 = schedule3.getClass();
    }

    @Test
    public void test383() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.blockProcess();
        String str5 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test384() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 10,
                0);
        String str4 = schedule3.toString();
    }

    @Test
    public void test385() throws Throwable {
        Schedule schedule3 = new Schedule(' ', (short) 10, 0);
        schedule3.blockProcess();
    }

    @Test
    public void test386() throws Throwable {
        Schedule schedule3 = new Schedule(1, (short) 100,
                (short) 1);
    }

    @Test
    public void test387() throws Throwable {
        Schedule schedule3 = new Schedule(1, (-1), ' ');
        schedule3.blockProcess();
    }

    @Test
    public void test388() throws Throwable {
        Schedule schedule3 = new Schedule(100, (short) 100, '4');
    }

    @Test
    public void test389() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test390() throws Throwable {
        Schedule schedule3 = new Schedule(0, (-1), (short) 10);
        schedule3.finishProcess();
    }

    @Test
    public void test391() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 10, (-1));
        schedule3.upgradeProcessPrio((short) 1, (float) 0L);
    }

    @Test
    public void test392() throws Throwable {
        Schedule schedule3 = new Schedule(0, (short) 0, 0);
    }

    @Test
    public void test393() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test394() throws Throwable {
        Schedule schedule3 = new Schedule(1, ' ', (short) 10);
    }

    @Test
    public void test395() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        String str9 = schedule3.toString();
    }

    @Test
    public void test396() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.quantumExpire();
    }

    @Test
    public void test397() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        String str13 = schedule3.toString();
    }

    @Test
    public void test398() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test399() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test400() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test401() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
        schedule3.blockProcess();
        String str13 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test402() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((short) 1);
        String str9 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test403() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, 10, 'a');
        schedule3.quantumExpire();
    }

    @Test
    public void test404() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str11 = schedule3.toString();
    }

    @Test
    public void test405() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test406() throws Throwable {
        Schedule schedule3 = new Schedule(10, (byte) 10, '#');
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test407() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess(0.0f);
        schedule3.finishProcess();
        String str14 = schedule3.toString();
    }

    @Test
    public void test408() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.unblockProcess((byte) 1);
    }

    @Test
    public void test409() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, (byte) 0,
                0);
    }

    @Test
    public void test410() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 10);
        schedule3.unblockProcess((float) 0);
    }

    @Test
    public void test411() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 100,
                (byte) 100);
        schedule3.unblockProcess(0.0f);
        schedule3.unblockProcess(0.0f);
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test412() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test413() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        String str9 = schedule3.toString();
        schedule3.unblockProcess((short) 0);
    }

    @Test
    public void test414() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        String str9 = schedule3.toString();
        String str10 = schedule3.toString();
    }

    @Test
    public void test415() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio((byte) 1, (float) 1L);
    }

    @Test
    public void test416() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 1);
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test417() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 10,
                (short) 0);
        String str4 = schedule3.toString();
    }

    @Test
    public void test418() throws Throwable {
        Schedule schedule3 = new Schedule(' ', '#', '4');
    }

    @Test
    public void test419() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        String str4 = schedule3.toString();
        schedule3.unblockProcess(0.0f);
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test420() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test421() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
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
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
    }

    @Test
    public void test423() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        String str11 = schedule3.toString();
        schedule3.unblockProcess(1.0f);
        schedule3.blockProcess();
    }

    @Test
    public void test424() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test425() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test426() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        String str13 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test427() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test428() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test429() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test430() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 1);
        schedule3.addProcess(1);
    }

    @Test
    public void test431() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        String str10 = schedule3.toString();
    }

    @Test
    public void test432() throws Throwable {
        Schedule schedule3 = new Schedule('a', ' ',
                (short) 10);
    }

    @Test
    public void test433() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        String str11 = schedule3.toString();
        String str12 = schedule3.toString();
        String str13 = schedule3.toString();
        schedule3.unblockProcess((float) 0L);
    }

    @Test
    public void test434() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test435() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio((byte) 1, (float) 1L);
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test436() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((short) 1);
        String str9 = schedule3.toString();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test437() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (byte) -1,
                (short) 10);
    }

    @Test
    public void test438() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
    }

    @Test
    public void test439() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 100, (byte) 0,
                'a');
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test440() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test441() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test442() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test443() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test444() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        String str11 = schedule3.toString();
        String str12 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test445() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test446() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        String str4 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test447() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.upgradeProcessPrio((byte) 1, (byte) 0);
    }

    @Test
    public void test448() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test449() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        String str10 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        Class<?> wildcardClass15 = schedule3.getClass();
    }

    @Test
    public void test450() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test451() throws Throwable {
        Schedule schedule3 = new Schedule(0, (-1), (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test452() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        schedule3.quantumExpire();
        schedule3.upgradeProcessPrio((short) 1, (float) 0L);
    }

    @Test
    public void test453() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 0, 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test454() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 100, '4', 10);
    }

    @Test
    public void test455() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, '#', 10);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test456() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        String str9 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test457() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
    }

    @Test
    public void test458() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test459() throws Throwable {
        Schedule schedule3 = new Schedule(0, (short) 100,
                (byte) 10);
    }

    @Test
    public void test460() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test461() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test462() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 10,
                (byte) -1);
        schedule3.blockProcess();
    }

    @Test
    public void test463() throws Throwable {
        Schedule schedule3 = new Schedule(10, 0, (byte) 100);
        schedule3.finishProcess();
    }

    @Test
    public void test464() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 0, '4');
        schedule3.addProcess(1);
    }

    @Test
    public void test465() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        String str10 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test466() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test467() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test468() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test469() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess(1.0f);
        schedule3.blockProcess();
    }

    @Test
    public void test470() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (byte) 100);
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test471() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test472() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.unblockProcess((short) 1);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.addProcess(1);
    }

    @Test
    public void test473() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 100,
                (byte) 100);
        String str4 = schedule3.toString();
    }

    @Test
    public void test474() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, 'a', 1);
        String str4 = schedule3.toString();
        schedule3.unblockProcess((float) 1L);
    }

    @Test
    public void test475() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (short) -1,
                (short) 10);
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test476() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        String str4 = schedule3.toString();
        String str5 = schedule3.toString();
    }

    @Test
    public void test477() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.unblockProcess(0.0f);
        schedule3.finishProcess();
        schedule3.blockProcess();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test478() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test479() throws Throwable {
        Schedule schedule3 = new Schedule(0, (-1), (short) 10);
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test480() throws Throwable {
        Schedule schedule3 = new Schedule(1, (-1), ' ');
        schedule3.finishAllProcesses();
    }

    @Test
    public void test481() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 10);
        String str4 = schedule3.toString();
    }

    @Test
    public void test482() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        String str9 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test483() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
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
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test485() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test486() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test487() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
        schedule3.blockProcess();
        String str5 = schedule3.toString();
    }

    @Test
    public void test488() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test489() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        String str9 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        String str13 = schedule3.toString();
        String str14 = schedule3.toString();
    }

    @Test
    public void test490() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
    }

    @Test
    public void test491() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test492() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test493() throws Throwable {
        Schedule schedule3 = new Schedule('a', (short) 1,
                (short) 1);
    }

    @Test
    public void test494() throws Throwable {
        Schedule schedule3 = new Schedule(0, (-1), '4');
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test495() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((short) 1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test496() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test497() throws Throwable {
        Schedule schedule3 = new Schedule(' ', (short) 10, 100);
    }

    @Test
    public void test498() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test499() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, (byte) 100,
                (byte) 10);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test500() throws Throwable {
        Schedule schedule3 = new Schedule('a', 1, 10);
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test501() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test502() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, (-1), 100);
        String str4 = schedule3.toString();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test503() throws Throwable {
        Schedule schedule3 = new Schedule((short) 1, 100,
                (short) 1);
    }

    @Test
    public void test504() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, 0, 100);
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test505() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
    }

    @Test
    public void test506() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 'a',
                (short) 10);
    }

    @Test
    public void test507() throws Throwable {
        Schedule schedule3 = new Schedule((short) 1, 1, '4');
        schedule3.quantumExpire();
        String str5 = schedule3.toString();
    }

    @Test
    public void test508() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, (byte) 100,
                1);
        schedule3.finishAllProcesses();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test509() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
    }

    @Test
    public void test510() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test511() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.quantumExpire();
        String str5 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test512() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test513() throws Throwable {
        Schedule schedule3 = new Schedule(1, (short) -1, '4');
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test514() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test515() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
        String str6 = schedule3.toString();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test516() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test517() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test518() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test519() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 0, 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test520() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test521() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str4 = schedule3.toString();
        schedule3.unblockProcess((short) 0);
    }

    @Test
    public void test522() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, 1, (byte) 10);
    }

    @Test
    public void test523() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
    }

    @Test
    public void test524() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 10,
                (short) 100);
    }

    @Test
    public void test525() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, (byte) 10,
                (byte) -1);
    }

    @Test
    public void test526() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test527() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test528() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        String str9 = schedule3.toString();
    }

    @Test
    public void test529() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.unblockProcess((byte) 0);
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test530() throws Throwable {
        Schedule schedule3 = new Schedule(0, 100, '#');
    }

    @Test
    public void test531() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test532() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 100,
                (byte) 1);
    }

    @Test
    public void test533() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, (byte) -1,
                (byte) 1);
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test534() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test535() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test
    public void test536() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 0,
                (byte) 1);
        String str4 = schedule3.toString();
        schedule3.quantumExpire();
    }

    @Test
    public void test537() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
        String str4 = schedule3.toString();
        String str5 = schedule3.toString();
        schedule3.addProcess((short) 1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test538() throws Throwable {
        Schedule schedule3 = new Schedule('4', '#', 100);
        String str4 = schedule3.toString();
    }

    @Test
    public void test539() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
    }

    @Test
    public void test540() throws Throwable {
        Schedule schedule3 = new Schedule(100, 0, 1);
    }

    @Test
    public void test541() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        Class<?> wildcardClass10 = schedule3.getClass();
    }

    @Test
    public void test542() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, (byte) 10,
                (short) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test543() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test544() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test545() throws Throwable {
        Schedule schedule3 = new Schedule('a', (-1), (short) 0);
        String str4 = schedule3.toString();
    }

    @Test
    public void test546() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test547() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 10,
                0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test548() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, '4',
                (short) 100);
    }

    @Test
    public void test549() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
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
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        String str6 = schedule3.toString();
        String str7 = schedule3.toString();
    }

    @Test
    public void test551() throws Throwable {
        Schedule schedule3 = new Schedule((short) -1, 0, 0);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
    }

    @Test
    public void test552() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str11 = schedule3.toString();
    }

    @Test
    public void test553() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.addProcess(1);
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test554() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 100,
                (byte) 100);
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test555() throws Throwable {
        Schedule schedule3 = new Schedule(100, 1, 1);
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        String str7 = schedule3.toString();
    }

    @Test
    public void test556() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.unblockProcess((byte) 0);
        schedule3.quantumExpire();
    }

    @Test
    public void test557() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test558() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, 10, (byte) 1);
    }

    @Test
    public void test559() throws Throwable {
        Schedule schedule3 = new Schedule(100, '4', (short) 1);
    }

    @Test
    public void test560() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
    }

    @Test
    public void test561() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, (byte) 1,
                (short) 0);
    }

    @Test
    public void test562() throws Throwable {
        Schedule schedule3 = new Schedule(0, (short) 0,
                (byte) 100);
    }

    @Test
    public void test563() throws Throwable {
        Schedule schedule3 = new Schedule('#', (byte) 100, 10);
        schedule3.finishProcess();
    }

    @Test
    public void test564() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
    }

    @Test
    public void test565() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test566() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, (short) 0,
                (short) 10);
    }

    @Test
    public void test567() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test568() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 'a',
                'a');
        schedule3.blockProcess();
    }

    @Test
    public void test569() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        String str6 = schedule3.toString();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test570() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((short) 0);
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test571() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test572() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 10, ' ');
    }

    @Test
    public void test573() throws Throwable {
        Schedule schedule3 = new Schedule('a', (byte) 100,
                (byte) 10);
    }

    @Test
    public void test574() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.quantumExpire();
    }

    @Test
    public void test575() throws Throwable {
        Schedule schedule3 = new Schedule(0, (byte) -1,
                (short) 1);
        schedule3.finishProcess();
    }

    @Test
    public void test576() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, 0,
                (short) -1);
        schedule3.quantumExpire();
    }

    @Test
    public void test577() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.finishProcess();
    }

    @Test
    public void test578() throws Throwable {
        Schedule schedule3 = new Schedule('a', (-1), (short) 0);
    }

    @Test
    public void test579() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.unblockProcess((byte) 0);
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((short) 0);
    }

    @Test
    public void test580() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 100, '4',
                'a');
    }

    @Test
    public void test581() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.blockProcess();
        schedule3.addProcess((short) 1);
        schedule3.upgradeProcessPrio(1, (short) 1);
    }

    @Test
    public void test582() throws Throwable {
        Schedule schedule3 = new Schedule(0, (short) 100,
                (short) -1);
    }

    @Test
    public void test583() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 10, 1,
                (short) 10);
    }

    @Test
    public void test584() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
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
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        String str7 = schedule3.toString();
        Class<?> wildcardClass8 = schedule3.getClass();
    }

    @Test
    public void test586() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 0);
        String str12 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test587() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.finishProcess();
    }

    @Test
    public void test588() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, (byte) 10,
                (short) 0);
        Class<?> wildcardClass4 = schedule3.getClass();
    }

    @Test
    public void test589() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, (byte) 0,
                (-1));
    }

    @Test
    public void test590() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        String str5 = schedule3.toString();
    }

    @Test
    public void test591() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, 100, '4');
    }

    @Test
    public void test592() throws Throwable {
        Schedule schedule3 = new Schedule((-1), 10, (-1));
        schedule3.finishProcess();
    }

    @Test
    public void test593() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        String str3 = schedule3.toString();
        String str4 = schedule3.toString();
    }

    @Test
    public void test594() throws Throwable {
        Schedule schedule3 = new Schedule('#', (short) 1,
                'a');
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
    }

    @Test
    public void test595() throws Throwable {
        Schedule schedule3 = new Schedule((-1), (byte) 100,
                (byte) 10);
    }

    @Test
    public void test596() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, (short) 100,
                100);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test597() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test598() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, 10,
                (byte) -1);
    }

    @Test
    public void test599() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test
    public void test600() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, (byte) 100,
                1);
        String str4 = schedule3.toString();
    }

    @Test
    public void test601() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.unblockProcess((float) 0);
        schedule3.blockProcess();
    }

    @Test
    public void test602() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.unblockProcess(0.0f);
        String str10 = schedule3.toString();
        String str11 = schedule3.toString();
    }

    @Test
    public void test603() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
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
        Schedule schedule3 = new Schedule(1, 0, (byte) 0);
        schedule3.quantumExpire();
        Class<?> wildcardClass5 = schedule3.getClass();
    }

    @Test
    public void test605() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.unblockProcess((byte) 1);
        String str7 = schedule3.toString();
        String str8 = schedule3.toString();
        schedule3.blockProcess();
    }

    @Test
    public void test606() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
    }

    @Test
    public void test607() throws Throwable {
        Schedule schedule3 = new Schedule();
        String str1 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test608() throws Throwable {
        Schedule schedule3 = new Schedule('#', ' ',
                (byte) -1);
        String str4 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishAllProcesses();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test609() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (short) -1,
                0);
    }

    @Test
    public void test610() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        String str8 = schedule3.toString();
        schedule3.finishProcess();
        schedule3.unblockProcess((byte) 1);
    }

    @Test
    public void test611() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        String str7 = schedule3.toString();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        Class<?> wildcardClass11 = schedule3.getClass();
    }

    @Test
    public void test612() throws Throwable {
        Schedule schedule3 = new Schedule(0, (byte) 10, '4');
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test613() throws Throwable {
        Schedule schedule3 = new Schedule(10, 0, 10);
        schedule3.blockProcess();
    }

    @Test
    public void test614() throws Throwable {
        Schedule schedule3 = new Schedule((short) 10, 0,
                (short) -1);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test615() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        String str4 = schedule3.toString();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test616() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
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
        Schedule schedule3 = new Schedule((short) 10, 10, 'a');
        schedule3.finishProcess();
        schedule3.finishProcess();
    }

    @Test
    public void test618() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.quantumExpire();
    }

    @Test
    public void test619() throws Throwable {
        Schedule schedule3 = new Schedule((short) 100, 0,
                (short) 10);
        schedule3.blockProcess();
        schedule3.finishAllProcesses();
        schedule3.finishAllProcesses();
        schedule3.addProcess((short) 1);
    }

    @Test
    public void test620() throws Throwable {
        Schedule schedule3 = new Schedule((short) 0, '#', 10);
        schedule3.finishProcess();
        schedule3.finishProcess();
        Class<?> wildcardClass6 = schedule3.getClass();
    }

    @Test
    public void test621() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 1, 'a',
                (short) -1);
    }

    @Test
    public void test622() throws Throwable {
        Schedule schedule3 = new Schedule((short) 1, 100, 0);
        schedule3.finishProcess();
    }

    @Test
    public void test623() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 'a');
        schedule3.finishAllProcesses();
        schedule3.unblockProcess((float) 0L);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishAllProcesses();
        schedule3.blockProcess();
        String str12 = schedule3.toString();
        schedule3.addProcess(1);
    }

    @Test
    public void test624() throws Throwable {
        Schedule schedule3 = new Schedule((byte) -1, '#',
                (short) 100);
        schedule3.unblockProcess((float) 0);
        String str6 = schedule3.toString();
        Class<?> wildcardClass7 = schedule3.getClass();
    }

    @Test
    public void test625() throws Throwable {
        Schedule schedule3 = new Schedule((byte) 0, (byte) 10,
                '4');
    }

    @Test
    public void test626() throws Throwable {
        Schedule schedule3 = new Schedule(1, ' ', (short) -1);
        schedule3.finishAllProcesses();
    }

    @Test()
    public void test00() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        Schedule schedule1 = new Schedule(3, 3, 3);
        schedule3.addProcess(3);
        schedule1.finishProcess();
        Schedule schedule2 = new Schedule(3, 4, 4);
        schedule2.quantumExpire();
        Schedule schedule4 = new Schedule();
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test()
    public void test01() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test()
    public void test02() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess(0.0F);
    }

    @Test()
    public void test03() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.addProcess(3);
    }

    @Test()
    public void test04() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        Schedule schedule1 = new Schedule(3, 7, 2);
        schedule1.finishProcess();
        schedule1.unblockProcess(0.0F);
        schedule3.addProcess(3);
    }

    @Test()
    public void test05() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.finishProcess();
        schedule3.unblockProcess(0.0F);
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess(0.0F);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio(2, 0.0F);
    }

    @Test()
    public void test06() throws Throwable {
        Schedule schedule3 = new Schedule(2, 2, 3);
        schedule3.finishProcess();
        schedule3.addProcess(2);
    }

    @Test()
    public void test07() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        schedule3.blockProcess();
    }

    @Test()
    public void test08() throws Throwable {
        Schedule schedule3 = new Schedule(2, 2, 2);
        schedule3.blockProcess();
    }

    @Test()
    public void test09() throws Throwable {
        Schedule schedule3 = new Schedule(2, 9, 7);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test()
    public void test10() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.addProcess(2);
        schedule3.finishProcess();
    }

    @Test()
    public void test11() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test()
    public void test12() throws Throwable {
        Schedule schedule3 = new Schedule(7, 5, 9);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.addProcess(2);
        schedule3.finishProcess();
    }

    @Test()
    public void test13() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.finishProcess();
    }

    @Test()
    public void test14() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test()
    public void test15() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        schedule3.addProcess(1);
    }

    @Test()
    public void test16() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
    }

    @Test()
    public void test17() throws Throwable {
        Schedule schedule3 = new Schedule(1, 1, 1);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test()
    public void test18() throws Throwable {
        Schedule schedule3 = new Schedule(4, 0, 0);
    }

    @Test()
    public void test19() throws Throwable {
        Schedule schedule3 = new Schedule(0, 4, 0);
    }

    @Test()
    public void test20() throws Throwable {
        Schedule schedule3 = new Schedule(0, 0, 4);
    }

    @Test()
    public void test21() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.addProcess(1);
        schedule3.unblockProcess(1.0F);
        schedule3.quantumExpire();
        schedule3.finishProcess();
    }

    @Test()
    public void test22() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.finishAllProcesses();
    }

    @Test()
    public void test23() throws Throwable {
        Schedule schedule3 = new Schedule(0, 1, 1);
    }

    @Test()
    public void test24() throws Throwable {
        Schedule schedule3 = new Schedule(1, 0, 1);
    }

    @Test()
    public void test25() throws Throwable {
        Schedule schedule3 = new Schedule(1, 1, 0);
    }

    @Test()
    public void test26() throws Throwable {
        Schedule schedule3 = new Schedule(5, 5, 5);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.finishProcess();
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.unblockProcess(1.0F);
        schedule3.blockProcess();
    }

    @Test()
    public void test27() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio(2, 1.0F);
        schedule3.finishProcess();
    }

    @Test()
    public void test28() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess(0.0F);
    }

    @Test()
    public void test29() throws Throwable {
        Schedule schedule3 = new Schedule(3, 3, 3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio(3, 1.0F);
        schedule3.finishProcess();
        schedule3.blockProcess();
    }

    @Test()
    public void test30() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.upgradeProcessPrio(3, 0.0F);
        schedule3.finishProcess();
    }

    @Test()
    public void test31() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test()
    public void test32() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.quantumExpire();
        schedule3.unblockProcess(1);
    }

    @Test()
    public void test33() throws Throwable {
        Schedule schedule3 = new Schedule();
    }

    @Test()
    public void test34() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.blockProcess();
        schedule3.finishProcess();
    }

    @Test()
    public void test35() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.finishProcess();
        schedule3.unblockProcess(0.0F);
        schedule3.finishProcess();
        schedule3.blockProcess();
        schedule3.finishProcess();
        schedule3.unblockProcess(0.0F);
        schedule3.finishProcess();
        schedule3.quantumExpire();
        schedule3.blockProcess();
        schedule3.upgradeProcessPrio(2, 1.0F);
    }

    @Test
    public void test1926() throws Throwable {
        Schedule schedule3 = new Schedule(7, 10, 9);
        schedule3.finishAllProcesses();
    }

    @Test
    public void test1927() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.addProcess(3);
        schedule3.blockProcess();
    }

    @Test
    public void test1928() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
    }

    @Test
    public void test1929() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(1);
        schedule3.addProcess(1);
        schedule3.addProcess(1);
    }

    @Test
    public void test1930() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
    }

    @Test
    public void test1931() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.addProcess(1);
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test1932() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
    }

    @Test
    public void test1933() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
        schedule3.blockProcess();
    }

    @Test
    public void test19134() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
    }

    @Test
    public void test1135() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
    }

    @Test
    public void test1136() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
    }

    @Test
    public void test1137() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.blockProcess();
    }

    @Test
    public void test1138() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.blockProcess();
    }

    @Test
    public void test1139() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.blockProcess();
    }

    @Test
    public void test1140() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.quantumExpire();
    }

    @Test
    public void test1141() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.quantumExpire();
    }

    @Test
    public void test1142() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.quantumExpire();
    }

    @Test
    public void test1143() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.quantumExpire();
    }

    @Test
    public void test1144() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.quantumExpire();
    }

    @Test
    public void test1145() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.quantumExpire();
    }

    @Test
    public void test1146() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
    }

    @Test
    public void test1147() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
    }

    @Test
    public void test1148() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(1);
        schedule3.quantumExpire();
    }

    @Test
    public void test1149() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.blockProcess();
    }

    @Test
    public void test1150() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.blockProcess();
    }

    @Test
    public void test1151() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.blockProcess();
    }

    @Test
    public void test1152() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.blockProcess();
    }

    @Test
    public void test1153() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(3);
        schedule3.blockProcess();
    }

    @Test
    public void test1154() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(1);
        schedule3.blockProcess();
    }

    @Test
    public void test1155() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
    }

    @Test
    public void test1156() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(1);
    }

    @Test
    public void test957() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
    }

    @Test
    public void test958() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
    }

    @Test
    public void test959() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(3);
    }

    @Test
    public void test960() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(1);
    }

    @Test
    public void test961() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
    }

    @Test
    public void test962() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(1);
    }

    @Test
    public void test963() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
    }

    @Test
    public void test964() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.blockProcess();
    }

    @Test
    public void test965() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(1);
        schedule3.blockProcess();
    }

    @Test
    public void test966() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.blockProcess();
    }

    @Test
    public void test967() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
        schedule3.quantumExpire();
    }

    @Test
    public void test968() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(1);
        schedule3.quantumExpire();
    }

    @Test
    public void test969() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
    }

    @Test
    public void test970() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.quantumExpire();
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
    }

    @Test
    public void test971() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.quantumExpire();
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.addProcess(1);
        schedule3.addProcess(3);
    }

    @Test
    public void test972() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.quantumExpire();
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.addProcess(1);
    }

    @Test
    public void test973() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.blockProcess();
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.addProcess(1);
    }

    @Test
    public void test974() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(2);
        schedule3.blockProcess();
        schedule3.addProcess(3);
        schedule3.addProcess(1);
        schedule3.addProcess(2);
    }

    @Test
    public void test975() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(3);
        schedule3.blockProcess();
        schedule3.addProcess(3);
        schedule3.addProcess(2);
        schedule3.addProcess(1);
    }

    @Test
    public void test976() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.quantumExpire();
    }

    @Test
    public void test977() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test978() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test979() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test980() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test981() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
        schedule3.quantumExpire();
    }

    @Test
    public void test982() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
    }

    @Test
    public void test984() throws Throwable {
        Schedule schedule3 = new Schedule();
        schedule3.addProcess(1);
        schedule3.addProcess(2);
        schedule3.addProcess(3);
        schedule3.quantumExpire();
        schedule3.quantumExpire();

    }

}
