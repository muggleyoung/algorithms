import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {
    @Test
    void returnTrueWhenIsEmpty() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        assertTrue(randomizedQueue.isEmpty());
    }

    @Test
    void returnFalseWhenIsNotEmpty() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        int item = 1;
        randomizedQueue.enqueue(item);
        assertFalse(randomizedQueue.isEmpty());
    }

    @Test
    void increaseSizeAfterEnqueue() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        int item = 1;
        randomizedQueue.enqueue(item);
        assertEquals(1, randomizedQueue.size());
    }

    @Test
    void decreaseSizeAfterDequeue() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        int item = 1;
        randomizedQueue.enqueue(item);
        randomizedQueue.dequeue();
        assertEquals(0, randomizedQueue.size());
    }

    @Test
    void throwExceptionWhenEnqueueWithNull() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        assertThrows(IllegalArgumentException.class, () -> randomizedQueue.enqueue(null));
    }

    @Test
    void throwExceptionWhenDequeueWithEmptyQueue() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        assertThrows(NoSuchElementException.class, randomizedQueue::dequeue);
    }

    @Test
    void throwExceptionWhenSampleWithEmptyQueue() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        assertThrows(NoSuchElementException.class, randomizedQueue::sample);
    }

    @Test
    void addElementAfterEnqueue() {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        int item = 1;
        randomizedQueue.enqueue(item);
        int actualItem = randomizedQueue.dequeue();
        assertEquals(item, actualItem);
    }
}