package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestSinglyLinkedList
  extends BaseListTester {

  @Override
  public List<String> getList() {
    return new SinglyLinkedList<String>();
  }
  
  @Test
  public void testAddFirst() {

    SinglyLinkedList<String> list = (SinglyLinkedList<String>)getList();
    Assert.assertEquals(list.size(), 0);

    list.addFirst(VALUE_1);
    list.addFirst(VALUE_2);
    list.addFirst(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertFalse(list.isEmpty());
    Assert.assertSame(VALUE_3, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
    Assert.assertSame(VALUE_1, list.get(2));
  }
}
