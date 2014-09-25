package com.denniskubes.adt;

public class TestArrayStack
  extends BaseStackTester {

  @Override
  public Stack<String> getStack() {
    return new ArrayStack<String>();
  }

}
