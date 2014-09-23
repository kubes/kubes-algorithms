package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestStack {

  public static String VALUE_1 = "value1";
  public static String VALUE_2 = "value2";
  public static String VALUE_3 = "value3";
  public static String VALUE_4 = "value4";

  public Stack<String> getStack() {
    return new Stack<String>();
  }

  @Test
  public void testPushPop() {

    Stack<String> stack = getStack();
    stack.push(VALUE_1);
    Assert.assertEquals(stack.size(), 1);
    Assert.assertFalse(stack.isEmpty());
    Assert.assertSame(VALUE_1, stack.pop());
    Assert.assertTrue(stack.isEmpty());

    stack.push(VALUE_1);
    stack.push(VALUE_2);
    stack.push(VALUE_3);
    Assert.assertEquals(stack.size(), 3);
    Assert.assertFalse(stack.isEmpty());
    Assert.assertSame(VALUE_3, stack.pop());
    Assert.assertSame(VALUE_2, stack.pop());
    Assert.assertSame(VALUE_1, stack.pop());
    Assert.assertTrue(stack.isEmpty());
  }

  @Test
  public void testPeek() {

    Stack<String> stack = getStack();
    stack.push(VALUE_1);
    stack.push(VALUE_2);
    stack.push(VALUE_3);
    Assert.assertEquals(stack.size(), 3);

    Assert.assertSame(VALUE_3, stack.peek());
    Assert.assertEquals(stack.size(), 3);
    Assert.assertSame(VALUE_3, stack.peek());
    Assert.assertSame(VALUE_3, stack.pop());
    Assert.assertSame(VALUE_2, stack.peek());
    Assert.assertEquals(stack.size(), 2);
  }

  @Test
  public void testForwardIteration() {

    Stack<String> stack = getStack();
    stack.push(VALUE_1);
    stack.push(VALUE_2);
    stack.push(VALUE_3);

    Iterator<String> iterator = stack.iterator();
    iterator.first();

    Assert.assertTrue(iterator.hasNext());
    Assert.assertSame(VALUE_3, iterator.next());

    Assert.assertTrue(iterator.hasNext());
    Assert.assertSame(VALUE_2, iterator.next());

    Assert.assertTrue(iterator.hasNext());
    Assert.assertSame(VALUE_1, iterator.next());

    Assert.assertFalse(iterator.hasNext());
    try {
      iterator.next();
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }
  }

  @Test
  public void testReverseIteration() {

    Stack<String> stack = getStack();
    stack.push(VALUE_1);
    stack.push(VALUE_2);
    stack.push(VALUE_3);

    Iterator<String> iterator = stack.iterator();
    iterator.last();

    Assert.assertTrue(iterator.hasPrevious());
    Assert.assertSame(VALUE_1, iterator.previous());

    Assert.assertTrue(iterator.hasPrevious());
    Assert.assertSame(VALUE_2, iterator.previous());

    Assert.assertTrue(iterator.hasPrevious());
    Assert.assertSame(VALUE_3, iterator.previous());

    Assert.assertFalse(iterator.hasPrevious());
    try {
      iterator.previous();
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }
  }
  
  @Test
  public void testSize() {

    Stack<String> stack = getStack();
    Assert.assertEquals(stack.size(), 0);

    stack.push(VALUE_1);
    Assert.assertEquals(stack.size(), 1);
    
    stack.push(VALUE_2);
    Assert.assertEquals(stack.size(), 2);
    
    stack.push(VALUE_3);
    Assert.assertEquals(stack.size(), 3);

    stack.push(VALUE_4);
    Assert.assertEquals(stack.size(), 4);

    Assert.assertSame(VALUE_4, stack.pop());
    Assert.assertEquals(stack.size(), 3);
    
    Assert.assertSame(VALUE_3, stack.pop());
    Assert.assertEquals(stack.size(), 2);
    
    Assert.assertSame(VALUE_2, stack.pop());
    Assert.assertEquals(stack.size(), 1);
  }

  @Test
  public void testClearIsEmpty() {

    Stack<String> stack = getStack();
    stack.push(VALUE_1);
    stack.push(VALUE_2);
    stack.push(VALUE_3);
    
    Assert.assertEquals(stack.size(), 3);
    Assert.assertFalse(stack.isEmpty());

    stack.clear();
    Assert.assertEquals(stack.size(), 0);
    Assert.assertTrue(stack.isEmpty());
  }

}
