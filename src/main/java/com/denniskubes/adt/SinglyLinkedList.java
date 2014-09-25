package com.denniskubes.adt;

public class SinglyLinkedList<T>
  implements List<T> {

  private class Entry {
    T value;
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

  public SinglyLinkedList() {
    head.next = tail;
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
    newEntry.next = after;

    // point head and after entries to new entry
    head.next = newEntry;

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

    // create the new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;

    // insert the new entry in the chain
    newEntry.next = before.next;
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

    // create a new entry, point its next to after position and point before
    // entry's next to the new entry
    Entry newEntry = new Entry();
    newEntry.value = obj;
    newEntry.next = afterPos;
    beforePos.next = newEntry;

    atPos.next = null;
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
    size--;

    atPos.next = null;
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
  public boolean isEmpty() {
    return size == 0;
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
      private int pos = 0;

      @Override
      public void first() {
        current = head;
        pos = 0;
      }

      @Override
      public void last() {
        current = tail;
        pos = size();
      }

      @Override
      public boolean hasNext() {

        // is the next one the end
        return current.next != tail;
      }

      @Override
      public boolean hasPrevious() {
        return pos > 0;
      }

      @Override
      public T next() {

        // we have reached the end, no next
        if (current.next == tail) {
          throw new IndexOutOfBoundsException();
        }

        pos++;
        current = current.next;
        return current.value;
      }

      @Override
      public T previous() {

        // we have reached the beginning, no previous
        if (pos == 0) {
          throw new IndexOutOfBoundsException();
        }

        // each call to preview requires searching all the way through the
        // entire list to the position because of singly linked structure
        T value = get(pos - 1);
        pos--;
        return value;
      }

    };
  }

}
