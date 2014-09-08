package com.denniskubes.adt;

import java.util.Iterator;

public class ListIterator<T>
  implements Iterator<T> {
  
  private List<T> backing;
  int pos = 0;
  
  public ListIterator(List<T> backing) {
    this.backing = backing;
  }

  @Override
  public boolean hasNext() {
    return pos < backing.size();
  }

  @Override
  public T next() {
    return backing.get(pos++);
  }

  @Override
  public void remove() {
    backing.remove(pos);    
  }

}
