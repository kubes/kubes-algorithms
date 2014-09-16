package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestArrayIterator {

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
