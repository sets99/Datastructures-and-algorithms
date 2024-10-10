package ds.labs.priorityqueue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {


		Comparator<Integer> customComparator = (a, b) -> b - a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(customComparator);
        
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(7);
        Integer peekedItem = priorityQueue.peek();
			
		
	}

}
