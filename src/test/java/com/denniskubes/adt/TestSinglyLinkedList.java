package com.denniskubes.adt;

public class TestSinglyLinkedList
  extends BaseListTester {

  @Override
  public List<String> getList() {
    return new SinglyLinkedList<String>();
  }
}
