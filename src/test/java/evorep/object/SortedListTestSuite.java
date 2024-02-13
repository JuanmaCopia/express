package evorep.object;

import org.junit.jupiter.api.Test;

public class SortedListTestSuite {

  @Test
  public void test0() {
    SortedList l = new SortedList();
    l.insert(1);
    l.insert(2);
    l.insert(3);
  }

  @Test
  public void test1() {
    SortedList l = new SortedList();
    l.insert(3);
    l.insert(2);
  }

  @Test
  public void test2() {
    SortedList l = new SortedList();
    l.insert(3);
    l.insert(2);
    l.insert(1);
    l.insert(0);
    l.insert(5);
  }

}
