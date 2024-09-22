package ds.labs;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ds.labs.queue.QueueList;

class QueueListTest {

	
	@Test
	void emptyQueue() {
		//Arrange
		QueueList<Integer> queue = new QueueList<>();
		
		//Assert
		assertAll(()-> assertEquals(0, queue.size()),
				()-> assertTrue(queue.isEmpty()));
	}

	

	
	@Test
	void emptyQueuePeek() {
		//Arrange
		QueueList<Integer> queue = new QueueList<>();
		
		//Act - Assert
		assertThrows(NoSuchElementException.class, () -> {
			 queue.peek();
			  });
	}
	
	@Test
	void emptyQueueDequeue() {
		//Arrange
		QueueList<Integer> queue = new QueueList<>();
		//Act - Assert
		 assertThrows(NoSuchElementException.class, () -> {
			 queue.dequeue();
			  });
	}
	@Test
	void clearQueue() {
		//Arrange
		QueueList<Integer> queue = new QueueList<>();
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		// Act
		queue.clear();
		
		// Assert
		assertAll(()-> assertEquals(0, queue.size()),
				()-> assertTrue(queue.isEmpty()));
	}

	

	
	@Test
	void clearQueuePeek() {
		//Arrange
		QueueList<Integer> queue = new QueueList<>();
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		// Act
		queue.clear();
		// Assert
		 assertThrows(NoSuchElementException.class, () -> {
			 queue.peek();
			  });
	}
	
	@Test
	void clearQueueDequeue() {
		//Arrange
		QueueList<Integer> queue = new QueueList<>();
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		// Act
		queue.clear();
		// Assert
		 assertThrows(NoSuchElementException.class, () -> {
			 queue.dequeue();
			  });
	}

	
	@Test
	void enqueueOneItem() {
		//Arrange 
		QueueList<Integer> queue = new QueueList<>();
		//Act
		queue.enqueue(0);
		//Assert
		assertAll(()-> assertEquals(1, queue.size()),
				()-> assertFalse(queue.isEmpty()));
	}
	
	
		@Test
	void enqueueOneItemDequeueOneItem() {
		
		//Arrange 
		QueueList<Integer> queue = new QueueList<>();
		queue.enqueue(0);
		Integer expected = 0;
		//Act
		Integer actual = queue.dequeue();
		//Assert
		assertAll(()-> assertEquals(expected, actual),
				()-> assertEquals(0, queue.size()),
				()-> assertTrue(queue.isEmpty()));
	}
		
		@Test
		void enqueuetwoItems() {
			//Arrange 
			QueueList<Integer> queue = new QueueList<>();
			queue.enqueue(2);
			queue.enqueue(3);
			Integer expected = 2;
			//Act
			Integer actual = queue.peek();
			//Assert
			assertAll(()-> assertEquals(expected, actual),
					()-> assertEquals(2, queue.size()),
					()-> assertFalse(queue.isEmpty()));
		}
		
		@Test
		void enqueuetwoItemsDequeOneItem() {
			
			//Arrange 
			QueueList<Integer> queue = new QueueList<>();
			queue.enqueue(2);
			queue.enqueue(3);
			Integer expected = 2;
			//Act
			Integer actual = queue.dequeue();
			//Assert
			assertAll(()-> assertEquals(expected, actual),
					()-> assertEquals(1, queue.size()),
					()-> assertFalse(queue.isEmpty()));
		}
		
		@Test
		void enqueuetwoItemsDequeTwoItems() {
			//Arrange 
			QueueList<Integer> queue = new QueueList<>();
			queue.enqueue(2);
			queue.enqueue(3);
			Integer expected = 2;
			Integer expected2 = 3;
			// Act
			Integer actual = queue.dequeue();
			Integer actual2 = queue.dequeue();
			// Assert
			assertAll(()-> assertEquals(expected, actual),
					()-> assertEquals(expected2, actual2),
					()-> assertEquals(0, queue.size()),
					()-> assertTrue(queue.isEmpty()));
		}
		
		
		@Test
		void enqueuefourItemsGetList() {
			// Arrange
			QueueList<Integer> queue = new QueueList<>();
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(5);
			
			Integer expected = 2;
			Integer expected2 = 3;
			Integer expected3 = 4;
			Integer expected4 = 5;
			// Act
			ArrayList<Integer> values = queue.toArrayList();
			
			//Assert
			assertAll(()-> assertEquals(expected, values.get(0)),
					()-> assertEquals(expected2, values.get(1)),
					()-> assertEquals(expected3, values.get(2)),
					()-> assertEquals(expected4, values.get(3)),
					()-> assertEquals(4, queue.size()),
					()-> assertFalse(queue.isEmpty()));
		}
}
