package com.denniskubes.adt;

public interface List<T> {

  public void add(T obj);
  
  public void insert(int pos, T obj);
  
  public T set(int pos, T obj);

  public T get(int pos);

  public int indexOf(T obj);

  public boolean contains(T obj);

  public T remove(int pos);

  public boolean remove(T obj);

  public int capacity();

  public int size();

  public Iterator<T> iterator();
}
