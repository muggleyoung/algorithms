import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DequeTest {
    @Test
    void returnTrueWhenIsEmpty() {
        Deque deque = new Deque();
        assertTrue(deque.isEmpty());
    }

    @Test
    void returnFalseWhenIsNotEmpty() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addFirst(firstItem);
        assertFalse(deque.isEmpty());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAddFirstWithNull() {
        Deque<Object> deque = new Deque<>();
        assertThrows(IllegalArgumentException.class, () -> deque.addFirst(null));
    }

    @Test
    void shouldAddOneItemFromHead() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addFirst(firstItem);
        assertEquals(1, deque.size());
    }

    @Test
    void shouldAddTwoItemsFromHead() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        int secondItem = 2;
        deque.addFirst(firstItem);
        deque.addFirst(secondItem);
        assertEquals(2, deque.size());
    }

    @Test
    void shouldRemoveFirstWhenThereIsOne() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addFirst(firstItem);
        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    void shouldRemoveFirstWhenThereIsMoreThanOne() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addFirst(firstItem);
        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenRemoveFirstFromNull() {
        Deque<Integer> deque = new Deque<>();
        assertThrows(NoSuchElementException.class, deque::removeFirst);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAddLastWithNull() {
        Deque<Object> deque = new Deque<>();
        assertThrows(IllegalArgumentException.class, () -> deque.addLast(null));
    }

    @Test
    void shouldAddOneItemFromTail() {
        Deque<Integer> deque = new Deque<>();
        int lastItem = 1;
        deque.addLast(lastItem);
        assertEquals(1, deque.size());
    }

    @Test
    void shouldAddTwoItemsFromTail() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        int secondItem = 2;
        deque.addLast(firstItem);
        deque.addLast(secondItem);
        assertEquals(2, deque.size());
    }

    @Test
    void shouldRemoveLastWhenThereIsOne() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addLast(firstItem);
        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    @Test
    void shouldRemoveLastWhenAddedFirst() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addFirst(firstItem);
        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    @Test
    void shouldRemoveFistWhenAddedLast() {
        Deque<Integer> deque = new Deque<>();
        int firstItem = 1;
        deque.addLast(firstItem);
        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    void shouldRemoveLastWhenThereIsMoreThanOne() {
        Deque<Integer> deque = new Deque<>();
        int item = 1;
        deque.addLast(item);
        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenRemoveLastFromNull() {
        Deque<Integer> deque = new Deque<>();
        assertThrows(NoSuchElementException.class, deque::removeLast);
    }

    @Test
    void test1() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(0);
        deque.removeFirst();
        deque.addFirst(2);
        deque.removeFirst();
        assertTrue(deque.isEmpty());
        assertTrue(deque.isEmpty());
        deque.addFirst(6);
        deque.addFirst(7);
        deque.removeFirst();
        deque.removeFirst();
    }

    @Test
    void test2() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(0);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);
        deque.addFirst(8);
        deque.removeLast();
    }

    @Test
    void test3() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.removeLast();
    }

    @Test
    void test4() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        assertFalse(deque.isEmpty());
        deque.addFirst(6);
        deque.addFirst(7);
        assertFalse(deque.isEmpty());
        deque.removeLast();
    }
}