package com.denniskubes.adt;

public class DoublyLinkedList<T>
  implements List<T> {

  private class Entry {
    T value;
    Entry previous;
    Entry next;
  }

  private Entry head = new Entry();
  private Entry tail = new Entry();
  private int size = 0;

  private Entry getEntryBefore(int pos) {

    int index = 0;
    Entry entry = head;
    while (index < pos) {
      entry = entry.next;
      index++;
    }

    return entry;
  }

  public DoublyLinkedList() {
    
    head.next = tail;
    head.previous = null;
    tail.previous = head;
    tail.next = null;
  }

  @Override
  public void add(T obj) {
    insert(size, obj);
  }

  @Override
  public void insert(int pos, T obj) {

    // check bounds, can insert at the end
    if (pos < 0 || pos > size) {
      throw new IndexOutOfBoundsException();
    }

    // go to the entry right before the pos
    Entry before = getEntryBefore(pos);
    Entry after = before.next;

    Entry newEntry = new Entry();
    newEntry.value = obj;
    newEntry.previous = before;
    newEntry.next = after;

    after.previous = newEntry;
    before.next = newEntry;
    
    size++;
  }

  @Override
  public T set(int pos, T obj) {

    // check bounds, >= size because can't set something that doesn't exist
    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }

    // get the entry before, after and at the position
    Entry beforePos = getEntryBefore(pos);
    Entry atPos = beforePos.next;
    Entry afterPos = atPos.next;

    Entry newEntry = new Entry();
    newEntry.value = obj;    
    newEntry.next = afterPos;
    newEntry.previous = beforePos;
    
    beforePos.next = newEntry;
    afterPos.previous = newEntry;

    // return the old entry at position
    atPos.next = null;
    atPos.previous = null;
    return atPos.value;
  }

  @Override
  public T get(int pos) {

    // check bounds, can get any index 0 to size - 1
    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }

    // go to the entry right before the pos
    Entry before = getEntryBefore(pos);
    Entry entry = before.next;

    return entry.value;
  }

  @Override
  public int indexOf(T obj) {

    int index = 0;
    Entry current = head.next;
    while (current != tail) {
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

    // check bounds, can remove any index 0 to size - 1
    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }
    
    // get the entry before, after and at the position
    Entry beforePos = getEntryBefore(pos);
    Entry atPos = beforePos.next;
    Entry afterPos = atPos.next;

    // link the before entry to the after entry, removing the entry at pos
    beforePos.next = afterPos;
    afterPos.previous = beforePos;
    
    atPos.next = null;
    atPos.previous = null;
    size--;

    return atPos.value;
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
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<T> iterator() {

    return new Iterator<T>() {

      private Entry current = head;

      @Override
      public void first() {
        current = head;
      }

      @Override
      public void last() {
        current = tail;
      }

      @Override
      public boolean hasNext() {
        return current.next != tail;
      }

      @Override
      public boolean hasPrevious() {
        return current.previous != head;
      }

      @Override
      public T next() {

        if (current.next == tail) {
          throw new IndexOutOfBoundsException();
        }

        current = current.next;
        return current.value;
      }

      @Override
      public T previous() {

        if (current.previous == head) {
          throw new IndexOutOfBoundsException();
        }

        current = current.previous;
        return current.value;
      }

    };
  }

}
