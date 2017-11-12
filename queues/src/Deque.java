import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    // construct an empty deque
    public Deque() {
        size = 0;
        head = null;
        tail = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = new Node();
            head.item = item;
            head.previous = null;
            head.next = null;
            tail = head;
        } else {
            Node current = head;
            head.item = item;
            head.next = current;
            head.previous = null;
            current.previous = head;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (tail == null) {
            tail = new Node();
            tail.item = item;
            tail.previous = null;
            tail.next = null;
            head = tail;
        } else {
            Node current = tail;
            tail.item = item;
            tail.next = null;
            tail.previous = current;
            current.next = tail;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node current = head;
        if (head != tail) {
            head = current.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return current.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node current = tail;
        if (head != tail) {
            tail = current.previous;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return current.item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        public DequeIterator() {
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
            current.next.previous = current;
            return item;
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {

    }

}
