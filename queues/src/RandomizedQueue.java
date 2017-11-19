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
        if (size == 0) {
            head = new Node(item, null);
        } else if (random == 0) {
            Node added = new Node(item, head);
            head = added;
        } else {
            Node current = head;
            for (int i = 2; i <= random; i++) {
                current = current.next;
            }
            Node added = new Node(item, current.next);
            current.next = added;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node current = new Node(head);
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

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(Node node) {
            this.item = node.item;
            this.next = node.next;
        }
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

}