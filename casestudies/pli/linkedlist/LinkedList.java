/*
 * @(#)LinkedList.java	1.46 03/01/23
 *
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package casestudies.pli.linkedlist;

import java.util.*;

/**
 * Linked list implementation of the <tt>List</tt> interface. Implements all
 * optional list operations, and permits all elements (including <tt>null</tt>).
 * In addition to implementing the <tt>List</tt> interface, the
 * <tt>LinkedList</tt> class provides uniformly named methods to <tt>get</tt>,
 * <tt>remove</tt> and <tt>insert</tt> an element at the beginning and end of
 * the list. These operations allow linked lists to be used as a stack, queue,
 * or double-ended queue (deque).
 * <p>
 * <p>
 * All of the stack/queue/deque operations could be easily recast in terms of
 * the standard list operations. They're included here primarily for
 * convenience, though they may run slightly faster than the equivalent List
 * operations.
 * <p>
 * <p>
 * All of the operations perform as could be expected for a doubly-linked list.
 * Operations that index into the list will traverse the list from the begining
 * or the end, whichever is closer to the specified index.
 * <p>
 *
 * <b>Note that this implementation is not synchronized.</b> If multiple threads
 * access a list concurrently, and at least one of the threads modifies the list
 * structurally, it <i>must</i> be synchronized externally. (A structural
 * modification is any operation that adds or deletes one or more elements;
 * merely setting the value of an element is not a structural modification.)
 * This is typically accomplished by synchronizing on some object that naturally
 * encapsulates the list. If no such object exists, the list should be "wrapped"
 * using the Collections.synchronizedList method. This is best done at creation
 * time, to prevent accidental unsynchronized access to the list:
 *
 * <pre>
 *     List list = Collections.synchronizedList(new LinkedList(...));
 * </pre>
 * <p>
 * <p>
 * The iterators returned by the this class's <tt>iterator</tt> and
 * <tt>listIterator</tt> methods are <i>fail-fast</i>: if the list is
 * structurally modified at any time after the iterator is created, in any way
 * except through the Iterator's own <tt>remove</tt> or <tt>add</tt> methods,
 * the iterator will throw a <tt>ConcurrentModificationException</tt>. Thus, in
 * the face of concurrent modification, the iterator fails quickly and cleanly,
 * rather than risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 *
 * <p>
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it
 * is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators throw
 * <tt>ConcurrentModificationException</tt> on a best-effort basis. Therefore,
 * it would be wrong to write a program that depended on this exception for its
 * correctness: <i>the fail-fast behavior of iterators should be used only to
 * detect bugs.</i>
 * <p>
 * <p>
 * This class is a member of the
 * <a href="{@docRoot}/../guide/collections/index.html"> Java Collections
 * Framework</a>.
 *
 * @author Josh Bloch
 * @version 1.46, 01/23/03
 * @see List
 * @see ArrayList
 * @see Vector
 * @see Collections#synchronizedList(List)
 * @since 1.2
 */
public class LinkedList {
    public Entry header = new Entry();
    public int size = 0;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
        header.next = header.previous = header;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public int getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return header.next.element;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public int getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return header.previous.element;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public int removeFirst() {
        int first = header.next.element;
        remove(header.next);
        return first;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list.
     * @throws NoSuchElementException if this list is empty.
     */
    public int removeLast() {
        int last = header.previous.element;
        remove(header.previous);
        return last;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param o the element to be inserted at the beginning of this list.
     */
    public void addFirst(int o) {
        addBefore(o, header.next);
    }

    /**
     * Appends the given element to the end of this list. (Identical in function to
     * the <tt>add</tt> method; included only for consistency.)
     *
     * @param o the element to be inserted at the end of this list.
     */
    public void addLast(int o) {
        addBefore(o, header);
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element. More
     * formally, returns <tt>true</tt> if and only if this list contains at least
     * one element <tt>e</tt> such that <tt>(o==null ? e==null
     * : o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested.
     * @return <tt>true</tt> if this list contains the specified element.
     */
    public boolean contains(int o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param o element to be appended to this list.
     * @return <tt>true</tt> (as per the general contract of
     * <tt>Collection.add</tt>).
     */
    public boolean add(int o) {
        addBefore(o, header);
        return true;
    }

    /**
     * Removes the first occurrence of the specified element in this list. If the
     * list does not contain the element, it is unchanged. More formally, removes
     * the element with the lowest index <tt>i</tt> such that
     * <tt>(o==null ? get(i)==null : o.equals(get(i)))</tt> (if such an element
     * exists).
     *
     * @param o element to be removed from this list, if present.
     * @return <tt>true</tt> if the list contained the specified element.
     */
    public boolean remove(int o) {
        for (Entry e = header.next; e != header; e = e.next) {
            if (o == e.element) {
                remove(e);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        header.next = header.previous = header;
        size = 0;
    }

    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the specified index is is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>).
     */
    public int get(int index) {
        return entry(index).element;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of element to replace.
     * @param element element to be stored at the specified position.
     * @return the element previously at the specified position.
     * @throws IndexOutOfBoundsException if the specified index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>).
     */
    public int set(int index, int element) {
        Entry e = entry(index);
        int oldVal = e.element;
        e.element = element;
        return oldVal;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts
     * the element currently at that position (if any) and any subsequent elements
     * to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted.
     * @param element element to be inserted.
     * @throws IndexOutOfBoundsException if the specified index is out of range
     *                                   (<tt>index &lt; 0 || index &gt; size()</tt>).
     */
    public void add(int index, int element) {
        addBefore(element, (index == size ? header : entry(index)));
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices). Returns
     * the element that was removed from the list.
     *
     * @param index the index of the element to removed.
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException if the specified index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>).
     */
    // public int remove(int index) {
    // Entry e = entry(index);
    // remove(e);
    // return e.element;
    // }

    /**
     * Return the indexed entry.
     */
    private Entry entry(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Entry e = header;
        if (index < (size >> 1)) {
            for (int i = 0; i <= index; i++)
                e = e.next;
        } else {
            for (int i = size; i > index; i--)
                e = e.previous;
        }
        return e;
    }

    // Search Operations

    /**
     * Returns the index in this list of the first occurrence of the specified
     * element, or -1 if the List does not contain this element. More formally,
     * returns the lowest index i such that
     * <tt>(o==null ? get(i)==null : o.equals(get(i)))</tt>, or -1 if there is no
     * such index.
     *
     * @param o element to search for.
     * @return the index in this list of the first occurrence of the specified
     * element, or -1 if the list does not contain this element.
     */
    public int indexOf(int o) {
        int index = 0;
        for (Entry e = header.next; e != header; e = e.next) {
            if (o == e.element)
                return index;
            index++;
        }
        return -1;
    }

    /**
     * Returns the index in this list of the last occurrence of the specified
     * element, or -1 if the list does not contain this element. More formally,
     * returns the highest index i such that
     * <tt>(o==null ? get(i)==null : o.equals(get(i)))</tt>, or -1 if there is no
     * such index.
     *
     * @param o element to search for.
     * @return the index in this list of the last occurrence of the specified
     * element, or -1 if the list does not contain this element.
     */
    public int lastIndexOf(int o) {
        int index = size;
        for (Entry e = header.previous; e != header; e = e.previous) {
            index--;
            if (o == e.element)
                return index;
        }
        return -1;
    }

    private Entry addBefore(int o, Entry e) {
        Entry newEntry = new Entry(o, e, e.previous);
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        size++;
        return newEntry;
    }

    private void remove(Entry e) {
        if (e == header) {
            throw new NoSuchElementException();
        }

        e.previous.next = e.next;
        e.next.previous = e.previous;
        size--;
    }

    /**
     * Returns a shallow copy of this <tt>LinkedList</tt>. (The elements themselves
     * are not cloned.)
     *
     * @return a shallow copy of this <tt>LinkedList</tt> instance.
     */
    public Object clone() {
        LinkedList clone;
        try {
            clone = (LinkedList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }

        // Put clone into "virgin" state
        clone.header = new Entry();
        clone.header.next = clone.header.previous = clone.header;
        clone.size = 0;

        // Initialize clone with our elements
        for (Entry e = header.next; e != header; e = e.next) {
            clone.add(e.element);
        }

        return clone;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nsize: " + size + "\n");
        if (header == null) {
            sb.append("header: null\n");
            return sb.toString();
        }
        String headerStr = "header:" + header.toString();

        sb.append("list: [" + headerStr + ", ");
        Set<Entry> visited = new HashSet<>();
        visited.add(header);
        Entry e = header.next;
        while (e != header) {
            if (e == null) {
                sb.append("null!]");
                return sb.toString();
            }
            if (!visited.add(e)) {
                sb.append("invalidCycle!]");
                return sb.toString();
            }
            sb.append(e.toString() + ", ");
            e = e.next;

        }
        sb.append(headerStr + "]");

        for (Entry entry : visited) {
            String previous = entry.previous == null ? "null" : entry.previous.toString();
            String next = entry.next == null ? "null" : entry.next.toString();
            sb.append("\n" + previous + " <- " + entry.toString() + "-> " + next);
        }
        return sb.toString();
    }

    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nsize: " + size + "\n");
        if (header == null) {
            sb.append("header: null\n");
            return sb.toString();
        }
        sb.append("list: [header, ");
        Set<Entry> visited = new HashSet<>();
        visited.add(header);
        Entry e = header.next;
        while (e != header) {
            if (e == null) {
                sb.append("null!]");
                return sb.toString();
            }
            if (!visited.add(e)) {
                sb.append("invalidCycle!]");
                return sb.toString();
            }
            sb.append(e.element + ", ");
            e = e.next;

        }
        sb.append("header]");
        return sb.toString();
    }

    /**
     * Returns an array containing all of the elements in this list in the correct
     * order.
     *
     * @return an array containing all of the elements in this list in the correct
     * order.
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Entry e = header.next; e != header; e = e.next)
            result[i++] = e.element;
        return result;
    }

    public boolean isCircularLinkedList() {
        Set<Entry> visited = new HashSet<Entry>();
        if (header == null)
            return false;

        if (!visited.add(header))
            return false;
        Entry current = header;

        while (true) {
            Entry next = current.next;
            if (next == null)
                return false;
            if (next.previous != current)
                return false;
            current = next;
            if (!visited.add(next))
                break;
        }
        if (current != header)
            return false;

        return true;
    }

    public static class Entry {
        public int element;
        public Entry next;
        public Entry previous;

        public Entry() {
        }

        Entry(int element, Entry next, Entry previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

}
