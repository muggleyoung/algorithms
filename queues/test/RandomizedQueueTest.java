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

    @Test
    void test1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(3);
        rq.enqueue(3);
        rq.enqueue(2);
        rq.enqueue(1);
        rq.enqueue(4);
    }

    @Test
    void test2() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(287);
        rq.enqueue(405);
        rq.enqueue(430);
        rq.enqueue(150);
        rq.dequeue();
        rq.enqueue(310);
        rq.dequeue();
        rq.enqueue(204);
        rq.enqueue(356);
        rq.enqueue(461);
    }
}