package com.denniskubes.adt;

public class TestLinkedStack
  extends BaseStackTester {

  @Override
  public Stack<String> getStack() {
    return new LinkedStack<String>();
  }
}
