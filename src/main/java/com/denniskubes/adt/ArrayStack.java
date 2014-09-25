package com.denniskubes.adt;

import java.util.EmptyStackException;

public class ArrayStack<T>
  implements Stack<T> {

  private ArrayList<T> backing = new ArrayList<T>();

  @Override
  public void push(T value) {
    backing.add(value);
  }

  @Override
  public T pop() {

    if (backing.isEmpty()) {
      throw new EmptyStackException();
    }
    return backing.remove(backing.size() - 1);
  }

  @Override
  public T peek() {

    if (backing.isEmpty()) {
      throw new EmptyStackException();
    }
    return backing.get(backing.size() - 1);
  }

  @Override
  public boolean isEmpty() {
    return backing.isEmpty();
  }

  @Override
  public void clear() {
    backing.clear();
  }
  
  @Override
  public int size() {
    return backing.size();
  }

  @Override
  public Iterator<T> iterator() {

    return new Iterator<T>() {

      private int pos = backing.size();

      @Override
      public void first() {
        pos = backing.size() - 1;
      }

      @Override
      public void last() {
        pos = 0;
      }

      @Override
      public boolean hasNext() {
        return pos >= 0;
      }

      @Override
      public boolean hasPrevious() {
        return pos < backing.size();
      }

      @Override
      public T next() {

        if (pos < 0) {
          throw new IndexOutOfBoundsException();
        }
        return backing.get(pos--);
      }

      @Override
      public T previous() {

        if (pos >= backing.size()) {
          throw new IndexOutOfBoundsException();
        }
        return backing.get(pos++);
      }

    };
  }

}
