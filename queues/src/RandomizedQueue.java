import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node head;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        int random = StdRandom.uniform(size + 1);
        Node current = head;
        if (head == null) {
            head = new Node();
            head.item = item;
            head.next = null;
        } else if (random == 0) {
            head.item = item;
            head.next = current;
        } else {
            for (int i = 1; i < random; i++) {
                current = current.next;
            }
            Node added = new Node();
            added.item = item;
            added.next = current.next;
            current.next = added;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node current = head;
        if (size != 1) {
            head = head.next;
        }
        size--;
        return current.item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class Node {
        private Item item;
        private Node next;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Node current = head;

        public RandomizedQueueIterator() {
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {
    }
}