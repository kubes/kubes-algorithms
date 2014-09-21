package com.denniskubes.adt;

import junit.framework.Assert;

import org.junit.Test;

public class TestDoublyLinkedList
  extends BaseListTester {

  @Override
  public List<String> getList() {
    return new DoublyLinkedList<String>();
  }
  
  @Test
  public void testAddFirst() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
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
  
  @Test
  public void testAddLast() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
    Assert.assertEquals(list.size(), 0);

    list.addLast(VALUE_1);
    list.addLast(VALUE_2);
    list.addLast(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertFalse(list.isEmpty());
    Assert.assertSame(VALUE_1, list.get(0));
    Assert.assertSame(VALUE_2, list.get(1));
    Assert.assertSame(VALUE_3, list.get(2));
  }
  
  @Test
  public void testGetFirst() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
    Assert.assertEquals(list.size(), 0);

    list.addFirst(VALUE_1);
    list.addFirst(VALUE_2);
    list.addFirst(VALUE_3);

    Assert.assertSame(VALUE_3, list.getFirst());
    list.remove(0);
    Assert.assertSame(VALUE_2, list.getFirst());
    list.remove(0);
    Assert.assertSame(VALUE_1, list.getFirst());
  }
  
  @Test
  public void testGetLast() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
    Assert.assertEquals(list.size(), 0);

    list.addLast(VALUE_1);
    list.addLast(VALUE_2);
    list.addLast(VALUE_3);

    Assert.assertSame(VALUE_3, list.getLast());
    list.remove(list.size() - 1);
    Assert.assertSame(VALUE_2, list.getLast());
    list.remove(list.size() - 1);
    Assert.assertSame(VALUE_1, list.getLast());
  }
  
  @Test
  public void testRemoveFirst() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
    Assert.assertEquals(list.size(), 0);

    list.addFirst(VALUE_1);
    list.addFirst(VALUE_2);
    list.addFirst(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_3, list.removeFirst());
    Assert.assertEquals(list.size(), 2);
    Assert.assertSame(VALUE_2, list.removeFirst());
    Assert.assertEquals(list.size(), 1);
    Assert.assertSame(VALUE_1, list.removeFirst());
  }
  
  @Test
  public void testRemoveLast() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
    Assert.assertEquals(list.size(), 0);

    list.addLast(VALUE_1);
    list.addLast(VALUE_2);
    list.addLast(VALUE_3);

    Assert.assertEquals(list.size(), 3);
    Assert.assertSame(VALUE_3, list.removeLast());
    Assert.assertEquals(list.size(), 2);
    Assert.assertSame(VALUE_2, list.removeLast());
    Assert.assertEquals(list.size(), 1);
    Assert.assertSame(VALUE_1, list.removeLast());
  }
  
  @Test
  public void testIterationAfterFirstLastChanges() {

    DoublyLinkedList<String> list = (DoublyLinkedList<String>)getList();
    
    list.add(VALUE_1);
    list.add(VALUE_2);
    list.add(VALUE_4);
    
    list.remove(VALUE_2);
    list.insert(1, VALUE_2);
    list.set(2, VALUE_3);
    
    list.addFirst(VALUE_1);
    list.addLast(VALUE_4);
    list.removeFirst();
    list.removeLast();

    Assert.assertEquals(list.size(), 3);    

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
}
