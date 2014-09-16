package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public abstract class BaseListTester {

  public abstract List<String> getList();

  @Test
  public void testAdd() {

    List<String> list = getList();
    Assert.assertTrue(list.size() == 0);
    list.add("Dennis");
    Assert.assertEquals("Dennis", list.get(0));
    list.add("Bob");
    Assert.assertEquals("Bob", list.get(1));
  }

  @Test
  public void testInsert() {

    List<String> list = getList();
    Assert.assertTrue(list.size() == 0);
    list.add("Dennis");
    Assert.assertEquals("Dennis", list.get(0));
    list.add("Bob");
    Assert.assertEquals("Bob", list.get(1));

    list.insert(1, "John");
    Assert.assertEquals("Dennis", list.get(0));
    Assert.assertEquals("John", list.get(1));
    Assert.assertEquals("Bob", list.get(2));
    Assert.assertTrue(list.size() == 3);
  }

  @Test
  public void testSet() {

    List<String> list = getList();
    Assert.assertTrue(list.size() == 0);
    list.add("Dennis");
    Assert.assertEquals("Dennis", list.get(0));
    list.add("Bob");
    Assert.assertEquals("Bob", list.get(1));

    list.set(1, "John");
    Assert.assertEquals("Dennis", list.get(0));
    Assert.assertEquals("John", list.get(1));
    Assert.assertTrue(list.size() == 2);
  }

  @Test
  public void testIndexOf() {

    List<String> list = getList();
    list.add("Dennis");
    list.add("Bob");
    Assert.assertEquals(list.indexOf("Dennis"), 0);
    Assert.assertEquals(list.indexOf("Bob"), 1);
  }

  @Test
  public void testContains() {

    List<String> list =  getList();
    list.add("Bob");
    Assert.assertTrue(list.contains("Bob"));
    Assert.assertFalse(list.contains("John"));
  }

  @Test
  public void testRemove() {

    List<String> list =  getList();
    list.add("Dennis");
    list.add("Bob");
    Assert.assertEquals("Bob", list.remove(1));
    Assert.assertEquals("Dennis", list.remove(0));

    List<String> list2 =  getList();
    list2.add("Dennis");
    list2.add("Bob");
    list2.add("John");
    list2.add("Suzie");
    list2.add("Spot");
    Assert.assertEquals("Suzie", list2.remove(3));
    Assert.assertEquals("Dennis", list2.remove(0));
    Assert.assertEquals("Spot", list2.remove(2));
  }

  @Test
  public void testSize() {

    List<String> list =  getList();
    Assert.assertTrue(list.size() == 0);

    list.add("Dennis");
    list.add("Bob");
    list.add("John");
    Assert.assertTrue(list.size() == 3);

    list.add("Suzie");
    list.add("Spot");
    Assert.assertTrue(list.size() == 5);

    Assert.assertTrue(list.remove("Dennis"));
    Assert.assertTrue(list.remove("Bob"));
    Assert.assertTrue(list.remove("John"));
    Assert.assertTrue(list.size() == 2);
  }
  
  @Test
  public void testClear() {
    
    List<String> list =  getList();
    list.add("Dennis");
    list.add("Bob");
    list.add("John");
    Assert.assertTrue(list.size() == 3);
    
    list.clear();
    Assert.assertTrue(list.size() == 0);
  }
  
  @Test
  public void testIterator() {

    List<String> list =  getList();
    list.add("Dennis");
    list.add("Mark");
    list.add("Suzie");
    list.add("Spot");    
    Iterator<String> it = list.iterator();
    
    Assert.assertTrue(it.hasNext());
    Assert.assertEquals(it.next(), "Dennis");
    Assert.assertTrue(it.hasNext());
    Assert.assertEquals(it.next(), "Mark");
    Assert.assertTrue(it.hasNext());
    Assert.assertEquals(it.next(), "Suzie");
    Assert.assertTrue(it.hasNext());
    Assert.assertEquals(it.next(), "Spot");
    Assert.assertFalse(it.hasNext());
    
    it.last();
    Assert.assertTrue(it.hasPrevious());
    Assert.assertEquals(it.previous(), "Spot");
    Assert.assertTrue(it.hasPrevious());
    Assert.assertEquals(it.previous(), "Suzie");
    Assert.assertTrue(it.hasPrevious());
    Assert.assertEquals(it.previous(), "Mark");
    Assert.assertTrue(it.hasPrevious());
    Assert.assertEquals(it.previous(), "Dennis");
    Assert.assertFalse(it.hasPrevious());
  }
}
