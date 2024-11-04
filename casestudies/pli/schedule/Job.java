package casestudies.pli.schedule;

public class Job {
    Job next;

    Job prev;

    int val;

    int priority;

    public Job(int newNum) {
        next = null;
        prev = null;
        val = newNum;
    }

    public Job() {
    }

    public Job getNext() {
        return next;
    }

    public void setNext(Job newNext) {
        next = newNext;
    }

    public Job getPrev() {
        return prev;
    }

    public void setPrev(Job newPrev) {
        prev = newPrev;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int newVal) {
        val = newVal;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int newPriority) {
        priority = newPriority;
    }

    public String toString() {
        final StringBuilder buf = new StringBuilder(1);
        // buf.append(this.val);
        // buf.append(",");
        buf.append(this.val);
        return buf.toString();
    }

}