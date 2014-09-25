package com.denniskubes.adt;

public interface Stack<T> {

  public void push(T value);

  public T pop();

  public T peek();

  public boolean isEmpty();

  public void clear();
  
  public int size();

  public Iterator<T> iterator();
}
