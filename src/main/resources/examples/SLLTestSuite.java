package examples;

import org.junit.jupiter.api.Test;

public class SLLTestSuite {

  @Test
  public void test0() {
    SLL l = new SLL();
  }

  @Test
  public void test1() {
    SLL l = new SLL();
    l.addLast(1);
    l.addLast(2);
    l.addLast(3);
  }

  @Test
  public void test2() {
    SLL l = new SLL();
    l.addLast(1);
    l.addLast(2);
    l.addLast(3);
    l.addLast(5);
    l.addLast(10);
    l.addLast(0);
    l.addLast(7);
  }

}