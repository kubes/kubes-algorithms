package com.denniskubes.adt;

public class ArrayList<T>
  implements List<T> {

  private T[] backing = null;
  private int size = 0;
  private int initialCapacity = 10;

  private void ensureCapacity(int capacity) {

    if (capacity > backing.length) {
      T[] biggerBacking = (T[])new Object[backing.length * 2];
      System.arraycopy(backing, 0, biggerBacking, 0, size);
      backing = biggerBacking;
    }
    else if (capacity <= (backing.length / 4) && capacity >= initialCapacity) {
      T[] smallerBacking = (T[])new Object[backing.length / 2];
      System.arraycopy(backing, 0, smallerBacking, 0, size);
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
    backing[size++] = obj;
  }

  @Override
  public void insert(int pos, T obj) {

    if (pos < 0 || pos > size) {
      throw new IndexOutOfBoundsException();
    }
    
    ensureCapacity(size + 1);
    if (pos < size) {
      System.arraycopy(backing, pos, backing, pos + 1, size - pos);
    }
    backing[pos] = obj;
    size++;
  }

  @Override
  public T set(int pos, T obj) {

    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }
    
    T old = backing[pos];
    backing[pos] = obj;
    return old;
  }

  @Override
  public T get(int pos) {

    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }
    
    return backing[pos];
  }

  @Override
  public int indexOf(T obj) {

    for (int i = 0; i < size; i++) {
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

    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }
    
    T obj = backing[pos];
    backing[pos] = null;
    size--;
    if (pos < size) {
      System.arraycopy(backing, pos + 1, backing, pos, size - pos);
      backing[size] = null;
    }
    ensureCapacity(size);

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

  public int capacity() {
    return backing.length;
  }

  @Override
  public int size() {
    return size;
  }
  
  @Override
  public void clear() {
    backing = (T[])new Object[initialCapacity];
    size = 0;
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator<T>(backing, 0, size);
  }

}
