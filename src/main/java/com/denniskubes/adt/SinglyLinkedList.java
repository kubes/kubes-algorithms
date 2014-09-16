package com.denniskubes.adt;

public class SinglyLinkedList<T>
  implements List<T> {

  private class Entry {
    T value;
    Entry next;
  }

  private Entry head = new Entry();
  private int size = 0;

  private boolean isOutOfBounds(int pos) {
    return pos < 0 || pos > (size + 1);
  }

  private void checkOutOfBounds(int pos) {
    if (isOutOfBounds(pos)) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  @Override
  public void add(T obj) {
    insert(size, obj);
  }

  @Override
  public void insert(int pos, T obj) {

    checkOutOfBounds(pos);

    // go to the entry right before the pos
    int index = 0;
    Entry entry = head;
    while (index < pos) {
      entry = entry.next;
      index++;
    }
    
    // create the new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;
    
    // insert the new entry in the chain
    newEntry.next = entry.next;
    entry.next = newEntry;
    
    size++;
  }

  @Override
  public T set(int pos, T obj) {

    checkOutOfBounds(pos);

    // position before the node to set
    int index = 0;
    Entry entry = head;
    while (index < pos) {
      entry = entry.next;
      index++;
    }
    
    // get the entry before, after and at the position
    Entry beforePos = entry;
    Entry atPos = entry.next;
    Entry afterPos = (atPos != null) ? atPos.next : null;
    
    // create a new entry, point its next to after position and point before
    // entry's next to the new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;
    newEntry.next = afterPos;
    beforePos.next = newEntry;
    
    // return the old entry at position
    if (atPos != null) {
      atPos.next = null;
      return atPos.value;
    }   
    
    return null;
  }

  @Override
  public T get(int pos) {

    int index = 0;
    Entry entry = head;
    while (index <= pos) {
      entry = entry.next;
      index++;
    }
    
    return (entry != null) ? entry.value : null;
  }

  @Override
  public int indexOf(T obj) {

    int index = 0;
    Entry current = head.next;
    while (current != null) {
      if (current.value != null && current.value.equals(obj)) {
        return index;
      }
      current = current.next;
      index++;
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

    // position before the node to set
    int index = 0;
    Entry entry = head;
    while (index < pos) {
      entry = entry.next;
      index++;
    }
    
    // get the entry before, after and at the position
    Entry beforePos = entry;
    Entry atPos = entry.next;
    Entry afterPos = (atPos != null) ? atPos.next : null;
    
    // link the before entry to the after entry, removing the entry at pos
    beforePos.next = afterPos;
    size--;
    
    // return the old entry at position
    if (atPos != null) {
      atPos.next = null;
      return atPos.value;
    }   
    
    return null;
  }

  @Override
  public boolean remove(T obj) {

    int pos = indexOf(obj);
    if (pos < 0) {
      return false;
    }
    remove(pos);
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    head.next = null;
    size = 0;
  }

  @Override
  public Iterator<T> iterator() {

    return new Iterator<T>() {
      
      private Entry current = head;
      int pos = 0;

      @Override
      public void first() {
        current = head.next;        
        pos = 0;
      }

      @Override
      public void last() {
        pos = size();      
      }

      @Override
      public boolean hasNext() {
        return current.next != null;
      }

      @Override
      public boolean hasPrevious() {
        return pos > 0;
      }

      @Override
      public T next() {
        pos++;
        current = current.next;
        return current != null ? current.value : null;
      }

      @Override
      public T previous() {
        T value =  pos > 0 ? get(pos - 1) : null;
        pos--;
        return value;
      }
      
    };
  }

}
