package ds.labs.priorityqueue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ds.labs.priorityqueue.PriorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueueTest {

 

    @Test
    public void testEnqueue() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(8);
        
        assertAll("enqueue",
            () -> assertEquals(3, priorityQueue.size(), "Queue size should be 3 after enqueuing 3 elements."),
            () -> assertFalse(priorityQueue.isEmpty(), "Queue should not be empty after enqueuing elements.")
        );
    }

    @Test
    public void testDequeue() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(8);
        Integer dequeuedItem = priorityQueue.dequeue();
        
        assertAll("dequeue",
            () -> assertEquals(8, dequeuedItem, "The dequeued item should be the one with the highest priority."),
            () -> assertEquals(2, priorityQueue.size(), "Queue size should be 2 after dequeuing 1 element."),
            () -> assertFalse(priorityQueue.isEmpty(), "Queue should not be empty after dequeuing 1 element.")
        );
    }

    @Test
    public void testIsEmpty() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        assertAll("isEmpty",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should be empty initially."),
            () -> {
                priorityQueue.enqueue(1);
                assertFalse(priorityQueue.isEmpty(), "Queue should not be empty after adding an element.");
            }
        );
    }

    @Test
    public void testPeek() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(7);
        Integer peekedItem = priorityQueue.peek();
        
        assertAll("peek",
            () -> assertEquals(10, peekedItem, "The peeked item should be the one with the highest priority."),
            () -> assertEquals(3, priorityQueue.size(), "Queue size should not change after peeking."),
            () -> assertFalse(priorityQueue.isEmpty(), "Queue should not be empty after peeking.")
        );
    }

    @Test
    public void testClear() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.clear();
        
        assertAll("clear",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should be empty after calling clear."),
            () -> assertEquals(0, priorityQueue.size(), "Queue size should be 0 after clearing.")
        );
    }

    @Test
    public void testToArrayList() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        ArrayList<Integer> list = priorityQueue.toArrayList();
        
        assertAll("toArrayList",
            () -> assertNotNull(list, "ArrayList should not be null."),
            () -> assertEquals(10, list.get(0), "First item in ArrayList should be the one with the highest priority."),
            () -> assertEquals(2, list.size(), "ArrayList size should match the number of enqueued elements.")
        );
    }

    @Test
    public void testMixedEnqueueDequeueOperations() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        // Step 1: Enqueue some elements
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(5);

        assertAll("Mixed operations - after first enqueue",
            () -> assertEquals(3, priorityQueue.size(), "Queue size should be 3 after enqueuing 3 elements."),
            () -> assertEquals(20, priorityQueue.peek(), "The first element should be 5 after enqueueing 5, 10, and 20.")
        );

        // Step 2: Dequeue one element (should be the smallest: 5)
        Integer dequeued = priorityQueue.dequeue();

        assertAll("Mixed operations - after first dequeue",
            () -> assertEquals(20, dequeued, "The dequeued element should be the largest: 20."),
            () -> assertEquals(2, priorityQueue.size(), "Queue size should be 2 after dequeuing 1 element."),
            () -> assertEquals(10, priorityQueue.peek(), "The new front element should be 10 after dequeuing 5.")
        );

        // Step 3: Enqueue a new element and check the priority queue again
        priorityQueue.enqueue(1);

        assertAll("Mixed operations - after enqueueing 1",
            () -> assertEquals(3, priorityQueue.size(), "Queue size should be 3 after enqueuing 1."),
            () -> assertEquals(10, priorityQueue.peek(), "The smallest element should be 10 after enqueuing 1.")
        );

        // Step 4: Dequeue the smallest element (1) again
        Integer dequeued2 = priorityQueue.dequeue();

        assertAll("Mixed operations - after second dequeue",
            () -> assertEquals(10, dequeued2, "The dequeued element should be the largest: 10."),
            () -> assertEquals(2, priorityQueue.size(), "Queue size should be 2 after dequeuing 5 element."),
            () -> assertEquals(5, priorityQueue.peek(), "The new front element should be 5 after dequeuing 10.")
        );
    }

    @Test
    public void testDequeueFromEmptyQueue() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        assertAll("Dequeue from empty queue",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should initially be empty."),
            () -> assertThrows(NoSuchElementException.class, () -> priorityQueue.dequeue(), "Dequeueing from an empty queue should throw an exception.")
        );
    }

    @Test
    public void testEnqueueDequeueMultipleElements() {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        // Enqueue elements in descending order
        priorityQueue.enqueue(50);
        priorityQueue.enqueue(30);
        priorityQueue.enqueue(40);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(10);

        // Dequeue all elements and ensure they come out in ascending order
        assertAll("Dequeue multiple elements",
            () -> assertEquals(50, priorityQueue.dequeue(), "Dequeued element should be the smallest: 50."),
            () -> assertEquals(40, priorityQueue.dequeue(), "Dequeued element should be the smallest: 40."),
            () -> assertEquals(30, priorityQueue.dequeue(), "Dequeued element should be the smallest: 30."),
            () -> assertEquals(20, priorityQueue.dequeue(), "Dequeued element should be the smallest: 20."),
            () -> assertEquals(10, priorityQueue.dequeue(), "Dequeued element should be the smallest: 10."),
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should be empty after dequeuing all elements.")
        );
    }
    
    @Test
    public void testPeekFromEmptyQueue() {
     
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        assertAll("Peek from empty queue",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should initially be empty."),
            () -> assertThrows(NoSuchElementException.class, 
                               () -> priorityQueue.peek(), 
                               "Peeking from an empty queue should throw NoSuchElementException.")
        );
    }
    
    @Test
    public void testDequeuFromEmptyQueue() {
     
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        assertAll("Peek from empty queue",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should initially be empty."),
            () -> assertThrows(NoSuchElementException.class, 
                               () -> priorityQueue.dequeue(), 
                               "Peeking from an empty queue should throw NoSuchElementException.")
        );
    }
}
