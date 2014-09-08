package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestArrayList {

  @Test
  public void testAdd() {
    
    ArrayList<String> al = new ArrayList<String>();    
    Assert.assertTrue(al.size() == 0);
    al.add("Dennis");
    Assert.assertEquals("Dennis", al.get(0));
    al.add("Bob");
    Assert.assertEquals("Bob", al.get(1));
  }
  
  @Test
  public void testIndexOf() {
  
    ArrayList<String> al = new ArrayList<String>();
    al.add("Dennis");
    al.add("Bob");
    Assert.assertEquals(al.indexOf("Dennis"), 0);
    Assert.assertEquals(al.indexOf("Bob"), 1);    
  }
  
  @Test
  public void testContains() {
  
    ArrayList<String> al = new ArrayList<String>();
    al.add("Bob");
    Assert.assertTrue(al.contains("Bob"));
    Assert.assertFalse(al.contains("John"));    
  }
  
  
  @Test
  public void testRemove() {
    
    ArrayList<String> al = new ArrayList<String>();
    al.add("Dennis");
    al.add("Bob");    
    Assert.assertEquals("Bob", al.remove(1));
    Assert.assertEquals("Dennis", al.remove(0));
    
    ArrayList<String> al2 = new ArrayList<String>();
    al2.add("Dennis");
    al2.add("Bob");   
    al2.add("John");
    al2.add("Suzie"); 
    al2.add("Spot");
    Assert.assertEquals("Suzie", al2.remove(3));
    Assert.assertEquals("Dennis", al2.remove(0));
    Assert.assertEquals("Spot", al2.remove(2));
  }
  
  @Test
  public void testSizeAndCapacity() {
    
    ArrayList<String> al = new ArrayList<String>();
    Assert.assertTrue(al.capacity() == 10);
    
    ArrayList<String> al2 = new ArrayList<String>(2);
    Assert.assertTrue(al2.capacity() == 2);
    
    al2.add("Dennis");
    al2.add("Bob");
    al2.add("John");
    Assert.assertTrue(al2.size() == 3);
    Assert.assertTrue(al2.capacity() == 4);
    
    al2.add("Suzie");
    al2.add("Spot");
    Assert.assertTrue(al2.size() == 5);
    Assert.assertTrue(al2.capacity() == 8);
    
    al2.remove("Dennis");
    al2.remove("Bob");
    al2.remove("John");
    Assert.assertTrue(al2.size() == 2);
    Assert.assertTrue(al2.capacity() == 4);
  }
}
