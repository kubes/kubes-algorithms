package com.denniskubes.adt;

public interface Iterator<T> {

  public void first();
  
  public void last();
  
  public boolean hasNext();
  
  public boolean hasPrevious();
  
  public T next();
  
  public T previous();
  
}
