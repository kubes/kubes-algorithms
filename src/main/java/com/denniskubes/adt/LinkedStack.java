package com.denniskubes.adt;

import java.util.EmptyStackException;

public class LinkedStack<T>
  implements Stack<T> {

  private DoublyLinkedList<T> backing = new DoublyLinkedList<T>();

  public void push(T value) {
    backing.addFirst(value);
  }

  public T pop() {

    if (backing.isEmpty()) {
      throw new EmptyStackException();
    }
    return backing.removeFirst();
  }

  public T peek() {

    if (backing.isEmpty()) {
      throw new EmptyStackException();
    }
    return backing.getFirst();
  }

  public boolean isEmpty() {
    return backing.isEmpty();
  }

  public int size() {
    return backing.size();
  }

  public void clear() {
    backing.clear();
  }

  public Iterator<T> iterator() {
    return backing.iterator();
  }

}
