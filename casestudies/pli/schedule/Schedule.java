package casestudies.pli.schedule;

import java.util.HashSet;
import java.util.Set;

public class Schedule {

    final static int MAXPRIO = 3;

    int allocProcNum;
    int numProcesses;

    Job curProc;

    List prio_0;
    List prio_1;
    List prio_2;
    List prio_3;

    List blockQueue;

    // Init the queues with no processes
    public Schedule() {
        initialize();
        initPrioQueue(3, 0);
        initPrioQueue(2, 0);
        initPrioQueue(1, 0);
    }

    public Schedule(int numProc3, int numProc2, int numProc1) {
        initialize();
        initPrioQueue(3, numProc3);
        initPrioQueue(2, numProc2);
        initPrioQueue(1, numProc1);
    }

    private List appendEle(List aList, Job aEle) {
        if (aList == null) {
            aList = new List();/* make list without compare function */
        }

        aEle.setPrev(aList.getLast()); /* insert at the tail */
        if (aList.getLast() != null) {
            aList.getLast().setNext(aEle);
        } else {
            aList.setFirst(aEle);
        }
        aList.setLast(aEle);
        aEle.setNext(null);
        aList.setMemCount(aList.getMemCount() + 1);
        return aList;
    }

    private Job findNth(List fList, int n) {
        Job fEle;

        if (fList == null) {
            return null;
        }
        fEle = fList.getFirst();
        for (int i = 1; fEle != null && i < n; i++) {
            fEle = fEle.getNext();
        }
        return fEle;
    }

    private List delEle(List dList, Job dEle) {
        if (dList == null || dEle == null) {
            return null;
        }

        if (dEle.getNext() != null) {
            dEle.getNext().setPrev(dEle.getPrev());
        } else {
            dList.setLast(dEle.getPrev());
        }
        if (dEle.getPrev() != null) {
            dEle.getPrev().setNext(dEle.getNext());
        } else {
            dList.setFirst(dEle.getNext());
        }
        /* KEEP d_ele's data & pointers intact!! */
        dList.setMemCount(dList.getMemCount() - 1);
        return dList;
    }

    public void finishProcess() {
        schedule();
        if (curProc != null) {
            curProc = null;
            numProcesses--;
        }
    }

    public void finishAllProcesses() {
        int total;
        total = numProcesses;
        for (int i = 0; i < total; i++) {
            finishProcess();
        }
    }

    private void schedule() {
        curProc = null;
        for (int i = MAXPRIO; i > 0; i--) {
            if (getPrioQueue(i).getMemCount() > 0) {
                curProc = getPrioQueue(i).getFirst();
                setPrioQueue(i, delEle(getPrioQueue(i), curProc));
                return;
            }
        }
    }

    public int size() {
        return numProcesses;
    }

    public String test() {
        String s = "hi";
        return s;
    }

    public void upgradeProcessPrio(int prio, float ratio) {
        if (prio < 1 || prio > MAXPRIO)
            throw new IllegalArgumentException();
        if (ratio < 0.0 || ratio > 1.0)
            throw new IllegalArgumentException();

        int count;
        int n;
        Job proc;
        List srcQueue, destQueue;

        if (prio >= MAXPRIO) {
            return;
        }
        srcQueue = getPrioQueue(prio);
        destQueue = getPrioQueue(prio + 1);
        count = srcQueue.getMemCount();

        if (count > 0) {
            n = (int) (count * ratio + 1);
            proc = findNth(srcQueue, n);
            if (proc != null) {
                srcQueue = delEle(srcQueue, proc);
                /* append to appropriate prio queue */
                proc.setPriority(prio + 1);
                destQueue = appendEle(destQueue, proc);
            }
        }
    }

    public void unblockProcess(float ratio) {
        if (ratio < 0.0 || ratio > 1.0)
            throw new IllegalArgumentException();

        int count;
        int n;
        Job proc;
        int prio;
        if (blockQueue != null) {
            count = blockQueue.getMemCount();
            n = (int) (count * ratio + 1);
            proc = findNth(blockQueue, n);
            if (proc != null) {
                blockQueue = delEle(blockQueue, proc);
                /* append to appropriate prio queue */
                prio = proc.getPriority();
                setPrioQueue(prio, appendEle(getPrioQueue(prio), proc));
            }
        }
    }

    public void quantumExpire() {
        int prio;
        schedule();
        if (curProc != null) {
            prio = curProc.getPriority();
            setPrioQueue(prio, appendEle(getPrioQueue(prio), curProc));
        }
    }

    public void blockProcess() {
        schedule();
        if (curProc != null) {
            blockQueue = appendEle(blockQueue, curProc);
        }
    }

    private Job newProcess(int prio) {
        Job proc = new Job(allocProcNum++);
        proc.setPriority(prio);
        numProcesses++;
        return proc;
    }

    public void addProcess(int prio) {
        if (prio < 1 || prio > MAXPRIO)
            throw new IllegalArgumentException();

        Job proc;
        proc = newProcess(prio);

        setPrioQueue(prio, appendEle(getPrioQueue(prio), proc));
    }

    private void initPrioQueue(int prio, int numProc) {
        if (prio < 1 || prio > MAXPRIO)
            throw new IllegalArgumentException();
        List queue;
        Job proc;

        queue = new List();
        for (int i = 0; i < numProc; i++) {
            proc = newProcess(prio);
            queue = appendEle(queue, proc);
        }

        setPrioQueue(prio, queue);
    }

    private void setPrioQueue(int prio, List queue) {
        switch (prio) {
            case 0:
                prio_0 = queue;
                break;
            case 1:
                prio_1 = queue;
                break;
            case 2:
                prio_2 = queue;
                break;
            case 3:
                prio_3 = queue;
                break;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    private List getPrioQueue(int prio) {
        switch (prio) {
            case 0:
                return prio_0;
            case 1:
                return prio_1;
            case 2:
                return prio_2;
            case 3:
                return prio_3;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void initialize() {
        allocProcNum = 0;
        numProcesses = 0;
        blockQueue = new List();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (curProc == null)
            sb.append("curProc: null\n");
        else
            sb.append("curProc: " + curProc.toString() + "\n");
        sb.append("prio_0: " + printList(prio_0) + "\n");
        sb.append("prio_1: " + printList(prio_1) + "\n");
        sb.append("prio_2: " + printList(prio_2) + "\n");
        sb.append("prio_3: " + printList(prio_3) + "\n");
        sb.append("blockQueue: " + printList(blockQueue) + "\n");
        sb.append("num_processes: " + numProcesses + "\n");
        return sb.toString();
    }

    private String printList(List list) {
        if (list == null)
            return "null";
        StringBuilder buf = new StringBuilder();
        Job current = list.getFirst();
        Set<Job> visited = new HashSet<>();
        if (current == null) {
            buf.append("Empty");
        } else {
            while (current != null) {
                if (!visited.add(current)) {
                    buf.append("Cycle!");
                    break;
                }
                buf.append(current.toString() + " ");
                current = current.getNext();
            }
        }
        if (list.getLast() == null)
            buf.append("  |  Last: null!");
        else if (!visited.add(list.getLast()))
            buf.append("  |  Last: Visited");
        else
            buf.append("  |  Last: Not Visited!");
        buf.append("  |  mem_count: " + list.getMemCount());
        return buf.toString();
    }
}
