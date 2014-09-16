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

    list2.add("Dennis");
    list2.add("Bob");
    list2.add("John");
    Assert.assertTrue(list2.capacity() == 4);

    list2.add("Suzie");
    list2.add("Spot");
    Assert.assertTrue(list2.capacity() == 8);

    list2.remove("Dennis");
    list2.remove("Bob");
    list2.remove("John");
    Assert.assertTrue(list2.capacity() == 4);
  }

}
