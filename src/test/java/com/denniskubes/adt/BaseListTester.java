package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public abstract class BaseListTester {

  public abstract List<String> getList();

  public static String VALUE_1 = "value1";
  public static String VALUE_2 = "value2";
  public static String VALUE_3 = "value3";
  public static String VALUE_4 = "value4";

  @Test
  public void testInsertIntoEmptyList() {

    List<String> list = getList();
    Assert.assertEquals(list.size(), 0);

    list.insert(0, VALUE_1);

    Assert.assertEquals(list.size(), 1);
    Assert.assertFalse(list.isEmpty());
    Assert.assertSame(VALUE_1, list.get(0));
  }

  @Test
  public void testInsertBetweenElements() {

    List<String> list = getList();
    list.insert(0, VALUE_1);
    list.insert(1, VALUE_2);
    list.insert(1, VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_3, list.get(1));
    Assert.assertSame(VALUE_2, list.get(2));
  }

  @Test
  public void testInsertAfterLastElement() {

    List<String> list = getList();
    list.insert(0, VALUE_1);
    list.insert(1, VALUE_2);

    Assert.assertEquals(list.size(), 2);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
  }

  @Test
  public void testInsertOutOfBounds() {

    List<String> list = getList();

    try {
      list.insert(-1, VALUE_1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.insert(1, VALUE_1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }
  }

  @Test
  public void testAdd() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
    Assert.assertSame(VALUE_3, list.get(2));
  }

  @Test
  public void testSetOutOfBounds() {

    List<String> list = getList();

    try {
      list.set(-1, VALUE_1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.set(0, VALUE_1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.add(VALUE_1);
      list.set(1, VALUE_2);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }
  }

  @Test
  public void testSet() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);

    list.set(1, VALUE_3);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_3, list.get(1));
  }

  @Test
  public void testGetOutOfBounds() {

    List<String> list = getList();

    try {
      list.get(-1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.get(0);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.add(VALUE_1);
      list.get(1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }
  }

  @Test
  public void testRemoveOnlyElement() {

    List<String> list = getList();
    list.add(VALUE_1);

    Assert.assertEquals(list.size(), 1);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_1, list.remove(0));
    Assert.assertEquals(list.size(), 0);
  }

  @Test
  public void testRemoveFirstElement() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
    Assert.assertSame(VALUE_3, list.get(2));

    Assert.assertSame(VALUE_1, list.remove(0));
    Assert.assertEquals(list.size(), 2);
    Assert.assertSame(VALUE_2, list.get(0));
    Assert.assertSame(VALUE_3, list.get(1));
  }

  @Test
  public void testRemoveBetweenElement() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
    Assert.assertSame(VALUE_3, list.get(2));

    Assert.assertSame(VALUE_2, list.remove(1));
    Assert.assertEquals(list.size(), 2);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_3, list.get(1));
  }

  @Test
  public void testRemoveLastElement() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
    Assert.assertSame(VALUE_3, list.get(2));

    Assert.assertSame(VALUE_3, list.remove(2));
    Assert.assertEquals(list.size(), 2);
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
  }

  @Test
  public void testRemoveOutOfBounds() {

    List<String> list = getList();

    try {
      list.remove(-1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.remove(0);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }

    try {
      list.add(VALUE_1);
      list.remove(1);
      Assert.fail();
    }
    catch (IndexOutOfBoundsException iobe) {
      // expected
    }
  }

  @Test
  public void testRemoveByValue() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Assert.assertTrue(list.remove(VALUE_1));
    Assert.assertFalse(list.remove(VALUE_1));
    Assert.assertEquals(list.size(), 2);

    Assert.assertTrue(list.remove(VALUE_2));
    Assert.assertFalse(list.remove(VALUE_2));
    Assert.assertEquals(list.size(), 1);

    Assert.assertTrue(list.remove(VALUE_3));
    Assert.assertFalse(list.remove(VALUE_3));
    Assert.assertEquals(list.size(), 0);
  }

  @Test
  public void testEmptyIteration() {

    List<String> list = getList();
    Iterator<String> iterator = list.iterator();
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
  public void testForwardIteration() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Iterator<String> iterator = list.iterator();
    iterator.first();

    Assert.assertTrue(iterator.hasNext());
    Assert.assertSame(VALUE_1, iterator.next());

    Assert.assertTrue(iterator.hasNext());
    Assert.assertSame(VALUE_2, iterator.next());

    Assert.assertTrue(iterator.hasNext());
    Assert.assertSame(VALUE_3, iterator.next());
    
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

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);

    Iterator<String> iterator = list.iterator();
    iterator.last();

    Assert.assertTrue(iterator.hasPrevious());
    Assert.assertSame(VALUE_3, iterator.previous());

    Assert.assertTrue(iterator.hasPrevious());
    Assert.assertSame(VALUE_2, iterator.previous());

    Assert.assertTrue(iterator.hasPrevious());
    Assert.assertSame(VALUE_1, iterator.previous());
    
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
  public void testIterationAfterChanges() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_4);
    list.remove(VALUE_2);
    list.insert(1, VALUE_2);
    list.set(2, VALUE_3);

    Iterator<String> iterator = list.iterator();
    iterator.first();
    Assert.assertSame(VALUE_1, iterator.next());
    Assert.assertSame(VALUE_2, iterator.next());
    Assert.assertSame(VALUE_3, iterator.next());

    iterator.last();
    Assert.assertSame(VALUE_3, iterator.previous());
    Assert.assertSame(VALUE_2, iterator.previous());
    Assert.assertSame(VALUE_1, iterator.previous());
  }

  @Test
  public void testIndexOf() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    Assert.assertEquals(list.indexOf(VALUE_1), 0);
    Assert.assertEquals(list.indexOf(VALUE_2), 1);
  }

  @Test
  public void testContains() {

    List<String> list = getList();
    list.add(VALUE_1);
    Assert.assertTrue(list.contains(VALUE_1));
    Assert.assertFalse(list.contains(VALUE_2));
  }

  @Test
  public void testSize() {

    List<String> list = getList();
    Assert.assertEquals(list.size(), 0);

    list.add(VALUE_1);
    Assert.assertEquals(list.size(), 1);
    
    list.add(VALUE_2);
    Assert.assertEquals(list.size(), 2);
    
    list.add(VALUE_3);
    Assert.assertEquals(list.size(), 3);

    list.add(VALUE_4);
    Assert.assertEquals(list.size(), 4);

    list.remove(VALUE_1);
    Assert.assertEquals(list.size(), 3);
    
    list.remove(0);
    Assert.assertEquals(list.size(), 2);
    
    list.set(0, VALUE_4);
    Assert.assertEquals(list.size(), 2);
  }

  @Test
  public void testClearIsEmpty() {

    List<String> list = getList();
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_3);
    
    Assert.assertEquals(list.size(), 3);
    Assert.assertFalse(list.isEmpty());

    list.clear();
    Assert.assertEquals(list.size(), 0);
    Assert.assertTrue(list.isEmpty());
  }

}
