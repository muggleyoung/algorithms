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
        head = new Node(item, head);
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(size) + 1;
        Node current = head;
        Item item;
        if (random == 1) {
            item = current.item;
            head = current.next;
        } else {
            for (int i = 2; i < random; i++) {
                current = current.next;
            }
            item = current.next.item;
            current.next = current.next.next;
        }
        size--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(size) + 1;
        Node current = new Node(head);
        if (random == 1) {
            return current.item;
        } else {
            for (int i = 2; i < random; i++) {
                current = current.next;
            }
            return current.next.item;
        }
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
        private Node iteratorHead;
        private int iteratorSize;

        public RandomizedQueueIterator() {
            this.iteratorHead = null;
            this.iteratorSize = size;
            Node current = head;
            while (current != null) {
                this.iteratorHead = new Node(current.item, iteratorHead);
                current = current.next;
            }
        }

        public boolean hasNext() {
            return iteratorSize != 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int random = StdRandom.uniform(this.iteratorSize) + 1;
            Item item;
            Node current = iteratorHead;
            if (random == 1) {
                item = current.item;
                this.iteratorHead = current.next;
            } else {
                for (int i = 2; i < random; i++) {
                    current = current.next;
                }
                item = current.next.item;
                current.next = current.next.next;
            }
            iteratorSize--;
            return item;
        }
    }
}