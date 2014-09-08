package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestArrayIterator {

  @Test
  public void testForward() {

    String[] strings = {
      "Dennis", "Mark", "Suzie", "Spot"
    };
    ArrayIterator<String> arIt = new ArrayIterator<String>(strings, 0,
      strings.length);
    Assert.assertTrue(arIt.hasNext());
    Assert.assertEquals(arIt.next(), "Dennis");
    Assert.assertTrue(arIt.hasNext());
    Assert.assertEquals(arIt.next(), "Mark");
    Assert.assertTrue(arIt.hasNext());
    Assert.assertEquals(arIt.next(), "Suzie");
    Assert.assertTrue(arIt.hasNext());
    Assert.assertEquals(arIt.next(), "Spot");
    Assert.assertFalse(arIt.hasNext());
  }

  @Test
  public void testBackwards() {

    String[] strings = {
      "Dennis", "Mark", "Suzie", "Spot"
    };
    ArrayIterator<String> arIt = new ArrayIterator<String>(strings, 0,
      strings.length);
    arIt.last();
    Assert.assertTrue(arIt.hasPrevious());
    Assert.assertEquals(arIt.previous(), "Spot");
    Assert.assertTrue(arIt.hasPrevious());
    Assert.assertEquals(arIt.previous(), "Suzie");
    Assert.assertTrue(arIt.hasPrevious());
    Assert.assertEquals(arIt.previous(), "Mark");
    Assert.assertTrue(arIt.hasPrevious());
    Assert.assertEquals(arIt.previous(), "Dennis");
    Assert.assertFalse(arIt.hasPrevious());
  }

  @Test
  public void testSubArray() {

    String[] strings = {
      "Dennis", "Mark", "Suzie", "Spot"
    };
    ArrayIterator<String> arIt = new ArrayIterator<String>(strings, 1, 2);
    Assert.assertTrue(arIt.hasNext());
    Assert.assertEquals(arIt.next(), "Mark");
    Assert.assertTrue(arIt.hasNext());
    Assert.assertEquals(arIt.next(), "Suzie");
    Assert.assertFalse(arIt.hasNext());
  }
}
