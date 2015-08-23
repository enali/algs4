package com.enalix.algs4.algorithms;

import java.util.Iterator;

/**
 * Created by enali on 5/1/15.
 */
public class Bag<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {

        }
    }
}
