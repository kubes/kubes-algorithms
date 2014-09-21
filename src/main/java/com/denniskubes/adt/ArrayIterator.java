package com.denniskubes.adt;

public class ArrayIterator<T>
  implements Iterator<T> {

  private T[] values;
  private int cur = 0;
  private int start = 0;
  private int end = 0;

  public ArrayIterator(T[] values, int start, int length) {

    if (values == null) {
      throw new NullPointerException();
    }

    this.values = values;
    this.start = start;
    if (start < 0) {
      this.start = 0;
    }
    cur = start;
    
    this.end = start + length;
    if (values.length < end) {
      this.end = values.length;
    }
  }

  @Override
  public void first() {
    cur = start;
  }

  @Override
  public void last() {
    cur = end - 1;    
  }

  @Override
  public boolean hasNext() {
    return cur < end;
  }

  @Override
  public boolean hasPrevious() {
    return cur >= start;
  }

  @Override
  public T next() {
    
    if (cur == end) {
      throw new IndexOutOfBoundsException();
    }
    
    return values[cur++];
  }

  @Override
  public T previous() {
    
    if (cur < start) {
      throw new IndexOutOfBoundsException();
    }
    
    return values[cur--];
  }

}
