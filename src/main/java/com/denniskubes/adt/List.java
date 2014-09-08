package com.denniskubes.adt;

import java.util.Iterator;

public interface List<T> {

  public void add(T obj);
  
  public T get(int pos);
  
  public int indexOf(T obj);
  
  public boolean contains(T obj);
  
  public T remove(int pos);
  
  public boolean remove(T obj);
  
  public int capacity();
  
  public int size();
  
  public Iterator<T> iterator();
}
