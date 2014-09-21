package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestArrayList
  extends BaseListTester {

  @Override
  public List<String> getList() {
    return new ArrayList<String>();
  }

  @Test
  public void testCapacity() {

    ArrayList<String> list =  new ArrayList<String>();
    Assert.assertTrue(list.capacity() == 10);

    ArrayList<String> list2 = new ArrayList<String>(2);
    Assert.assertTrue(list2.capacity() == 2);

    list2.add(VALUE_1);
    list2.add(VALUE_2);
    list2.add(VALUE_3);
    Assert.assertTrue(list2.capacity() == 4);

    list2.add(VALUE_4);
    list2.add("VALUE_4");
    Assert.assertTrue(list2.capacity() == 8);

    list2.remove(VALUE_1);
    list2.remove(VALUE_2);
    list2.remove(VALUE_3);
    Assert.assertTrue(list2.capacity() == 4);
  }

}
