package com.denniskubes.adt;

import java.util.Iterator;

public class ArrayList<T>
  implements List<T> {
  
  private T[] backing = null;
  private int index = 0;
  private int initialCapacity = 10;
  
  private boolean isOutOfBounds(int pos) {
    return pos < 0 || pos > (index + 1);
  }
  
  private void checkOutOfBounds(int pos) {
    if (isOutOfBounds(pos)) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  private void ensureCapacity(int capacity) {
    
    if (capacity > backing.length) {
      T[] biggerBacking = (T[])new Object[backing.length * 2];
      System.arraycopy(backing, 0, biggerBacking, 0, index);
      backing = biggerBacking;
    }
    else if (capacity <= (backing.length / 4) && capacity >= initialCapacity) {
      T[] smallerBacking = (T[])new Object[backing.length / 2];
      System.arraycopy(backing, 0, smallerBacking, 0, index);
      backing = smallerBacking;
    }
  }
  
  public ArrayList() {
    backing = (T[])new Object[initialCapacity];
  }
  
  public ArrayList(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    backing = (T[])new Object[initialCapacity];
  }

  @Override
  public void add(T obj) {
    ensureCapacity(size() + 1);
    backing[index++] = obj;
  }

  @Override
  public T get(int pos) {
    checkOutOfBounds(pos);
    return backing[pos];
  }
  
  @Override
  public int indexOf(T obj) {
    
    for (int i = 0; i < index; i++) {
      T cur = backing[i];
      if (cur != null && cur.equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean contains(T obj) {
    return indexOf(obj) >= 0;
  }

  @Override
  public T remove(int pos) {
    
    checkOutOfBounds(pos);
    T obj = backing[pos];
    backing[pos] = null;
    index--;
    if (pos < index) {
      System.arraycopy(backing, pos + 1, backing, pos, index - pos);
      backing[index] = null;
    }
    ensureCapacity(index);
    
    return obj;
  }

  @Override
  public boolean remove(T obj) {

    int pos = indexOf(obj);
    if (pos >= 0) {
      remove(pos);
      return true;
    }
    
    return false;
  }
  
  @Override
  public int capacity() {
    return backing.length;
  }

  @Override
  public int size() {
    return index;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator<T>(this);
  }

}
