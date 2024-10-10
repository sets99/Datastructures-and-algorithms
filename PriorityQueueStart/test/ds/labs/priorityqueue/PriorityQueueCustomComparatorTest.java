package ds.labs.priorityqueue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueueCustomComparatorTest {

    @Test
    public void testEnqueue() {
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
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
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(8);
        Integer dequeuedItem = priorityQueue.dequeue();
        
        assertAll("dequeue",
            () -> assertEquals(8, dequeuedItem, "The dequeued item should be the one with the highest priority (largest number)."),
            () -> assertEquals(2, priorityQueue.size(), "Queue size should be 2 after dequeuing 1 element."),
            () -> assertFalse(priorityQueue.isEmpty(), "Queue should not be empty after dequeuing 1 element.")
        );
    }

    @Test
    public void testIsEmpty() {
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
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
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(7);
        Integer peekedItem = priorityQueue.peek();
        
        assertAll("peek",
            () -> assertEquals(10, peekedItem, "The peeked item should be the one with the highest priority (smallest number)."), //pretty sure this test is incorrect, fixed
            () -> assertEquals(3, priorityQueue.size(), "Queue size should not change after peeking."),
            () -> assertFalse(priorityQueue.isEmpty(), "Queue should not be empty after peeking.")
        );
    }

    @Test
    public void testClear() {
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
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
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(5); 
        ArrayList<Integer> list = priorityQueue.toArrayList();
        
        assertAll("toArrayList",
            () -> assertNotNull(list, "ArrayList should not be null."),
            () -> assertEquals(10, list.get(0), "First item in ArrayList should be the one with the highest priority (largest number)."), // wrong test, largest number is 10 not 2 (as written before)
            () -> assertEquals(4, list.size(), "ArrayList size should match the number of enqueued elements.")
        );
    }

    @Test
    public void testMixedEnqueueDequeueOperations() {
        //Comparator<Integer> customComparator = (a, b) -> b - a;
        Comparator<Integer> customComparator = (a, b) -> a.compareTo(b);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        // Step 1: Enqueue some elements
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(5);

        assertAll("Mixed operations - after first enqueue",
            () -> assertEquals(3, priorityQueue.size(), "Queue size should be 3 after enqueuing 3 elements."),
            () -> assertEquals(20, priorityQueue.peek(), "The first element should be 20 after enqueueing 5, 10, and 20.")
        );

        // Step 2: Dequeue one element (should be the largest: 20)
        Integer dequeued = priorityQueue.dequeue();

        assertAll("Mixed operations - after first dequeue",
            () -> assertEquals(20, dequeued, "The dequeued element should be the largest: 20."),
            () -> assertEquals(2, priorityQueue.size(), "Queue size should be 2 after dequeuing 1 element."),
            () -> assertEquals(10, priorityQueue.peek(), "The new front element should be 10 after dequeuing 20.")
        );

        // Step 3: Enqueue a new element and check the priority queue again
        priorityQueue.enqueue(1);

        assertAll("Mixed operations - after enqueueing 1",
            () -> assertEquals(3, priorityQueue.size(), "Queue size should be 3 after enqueuing 1."),
            () -> assertEquals(10, priorityQueue.peek(), "The highest priority element should be 10 after enqueuing 1.")
        );

        // Step 4: Dequeue the highest priority element (10) again
        Integer dequeued2 = priorityQueue.dequeue();

        assertAll("Mixed operations - after second dequeue",
            () -> assertEquals(10, dequeued2, "The dequeued element should be the highest priority: 10."),
            () -> assertEquals(2, priorityQueue.size(), "Queue size should be 2 after dequeuing 1 element."),
            () -> assertEquals(5, priorityQueue.peek(), "The new front element should be 5 after dequeuing 10.")
        );
    }

    @Test
    public void testDequeueFromEmptyQueue() {
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        assertAll("Dequeue from empty queue",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should initially be empty."),
            () -> assertThrows(NoSuchElementException.class, () -> priorityQueue.dequeue(), "Dequeueing from an empty queue should throw an exception.")
        );
    }

    @Test
    public void testEnqueueDequeueMultipleElements() {
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        // Enqueue elements in descending order
        priorityQueue.enqueue(50);
        priorityQueue.enqueue(30);
        priorityQueue.enqueue(40);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(10);

        // Dequeue all elements and ensure they come out in descending order
        //wrong test, fixed
        assertAll("Dequeue multiple elements",
            () -> assertEquals(50, priorityQueue.dequeue(), "Dequeued element should be the highest priority: 50."),
            () -> assertEquals(40, priorityQueue.dequeue(), "Dequeued element should be the highest priority: 40."),
            () -> assertEquals(30, priorityQueue.dequeue(), "Dequeued element should be the highest priority: 30."),
            () -> assertEquals(20, priorityQueue.dequeue(), "Dequeued element should be the highest priority: 20."),
            () -> assertEquals(10, priorityQueue.dequeue(), "Dequeued element should be the highest priority: 10."),
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should be empty after dequeuing all elements.")
        );
    }
    
  
    @Test
    public void testPeekFromEmptyQueue() {
        Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        assertAll("Peek from empty queue",
            () -> assertTrue(priorityQueue.isEmpty(), "Queue should initially be empty."),
            () -> assertThrows(NoSuchElementException.class, 
                               () -> priorityQueue.peek(), 
                               "Peeking from an empty queue should throw NoSuchElementException.")
        );
    }
  
}
