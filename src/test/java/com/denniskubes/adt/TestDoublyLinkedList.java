package com.denniskubes.adt;

public class TestDoublyLinkedList
  extends BaseListTester {

  @Override
  public List<String> getList() {
    return new DoublyLinkedList<String>();
  }
}
