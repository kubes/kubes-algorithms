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
    
    // setup the head and tail to point to each other
    head.next = tail;
    head.previous = null;
    tail.previous = head;
    tail.next = null;
  }

  @Override
  public void add(T obj) {
    insert(size, obj);
  }
  
  public void addFirst(T obj) {
    
    // get the entry after the head, could be the tail
    Entry after = head.next;
    
    // create and link new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;
    newEntry.previous = head;
    newEntry.next = after;
    
    // point head and after entries to new entry
    head.next = newEntry;
    after.previous = newEntry;
    
    // increase the size
    size++;
  }
  
  public void addLast(T obj) {
    
    // get the entry before the tail, could be the head
    Entry before = tail.previous;
    
    // create and link new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;
    newEntry.previous = before;
    newEntry.next = tail;
    
    // point tail and before entries to new entry
    tail.previous = newEntry;
    before.next = newEntry;
    
    // increase the size
    size++;
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

    // create and link new entry
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

    // create and link the new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;    
    newEntry.next = afterPos;
    newEntry.previous = beforePos;
    
    // link the before and after entries to the new entry
    beforePos.next = newEntry;
    afterPos.previous = newEntry;

    // unlink the old entry at the position
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

    return getEntryBefore(pos).next.value;
  }
  
  public T getFirst() {
    
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    
    // optimized version to get the head next value
    return head.next.value;    
  }
  
  public T getLast() {
    
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    
    // optimized version to get the tail previous value
    return tail.previous.value;
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

    // link the before entries
    beforePos.next = afterPos;
    afterPos.previous = beforePos;
    
    // unlink the old entry
    atPos.next = null;
    atPos.previous = null;
    
    // decrement the size of the list
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
  
  public T removeFirst() {
    
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    
    // get the first position and the one after, after could be tail
    Entry first = head.next; 
    Entry after = first.next;

    // link the head to the second position, could be tail
    head.next = after;
    after.previous = head;
    
    // unlink the old first entry
    first.next = null;
    first.previous = null;
    
    // decrement size of the list
    size--;
    
    return first.value;
  }
  
  public T removeLast() {
    
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    
    // get the last position and the one before that, could be head
    Entry last = tail.previous; 
    Entry before = last.previous;

    // link the tail to the second to last position, could be head
    tail.previous = before;
    before.next = tail;
    
    // unlink the old last entry
    last.next = null;
    last.previous = null;
    
    // decrement the size of the list
    size--;
    
    return last.value;
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
