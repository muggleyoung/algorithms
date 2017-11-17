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

        public Node(Node node) {
            this.item = node.item;
            this.next = node.next;
            this.previous = node.previous;
        }

        public Node() {
        }

        public Node(Item item, Node previous, Node next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

        public boolean equal(Node b) {
            return this.item == b.item && this.previous == b.previous && this.next == b.next;
        }
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
        if (size == 0) {
            addFirstNode(item);
        } else if (size == 1) {
            Node current = new Node(item, null, head);
            head.previous = current;
            tail.previous = head;
            head = current;
        } else {
            Node current = new Node(item, null, head);
            head.previous = current;
            head = current;
        }
        size++;
    }

    private void addFirstNode(Item item) {
        Node node = new Node(item, null, null);
        head = node;
        tail = node;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            addFirstNode(item);
        } else if (size == 1) {
            Node current = new Node(item, tail, null);
            tail.next = current;
            head.next = tail;
            tail = current;
        } else {
            Node current = new Node(item, tail, null);
            tail.next = current;
            tail = current;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node current = new Node(head);
        if (!head.equal(tail)) {
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
        Node current = new Node(tail);
        if (!head.equal(tail)) {
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
}
