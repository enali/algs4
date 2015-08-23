package com.enalix.algs4.algorithms;

import java.util.Iterator;

/**
 * Created by enali on 4/29/15.
 */
public class Queue<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private Node qFirst = first;
        public boolean hasNext() {
            return qFirst != null;
        }
        public Item next() {
            Item item = qFirst.item;
            qFirst = qFirst.next;
            return item;
        }
        public void remove() {

        }
    }
}