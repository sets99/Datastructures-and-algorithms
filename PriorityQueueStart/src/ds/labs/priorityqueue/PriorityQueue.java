package ds.labs.priorityqueue;

import java.util.*;

@SuppressWarnings("unused")
public class PriorityQueue<Item extends Comparable<Item>> implements Queue<Item> {

	
	private int size = 0;
	private Node<Item> front;
	private Node<Item> back;
	private Comparator<Item> compare;
    
	public PriorityQueue()
    {
    	this.compare = (a, b) -> a.compareTo(b);
    	
    	
    }
    public PriorityQueue(Comparator<Item> compare )
    {
    	 this.compare = compare;
    }  
   
    
    
	private static class Node<Item>
	{
	   private Item data;
	   private Node<Item> next;

	 
	public Node(Item data, Node<Item> next)
	   {
	      this.data = data;
	      this.next = next;
	   }	   
	   public Node(Item data)
	   {
	      this.data = data;
	      this.next = null;
	   }	   
	   public Node()
	   {
	      this.data = null;
	      this.next = null;
	   }
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Item dequeue() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		size--;
		Node<Item> currFront = front;
		front = front.next;
		return currFront.data;
		
	}

	@Override
	public void enqueue(Item item) {
		Node<Item> newNode = new Node<Item>(item);
		
		if(size == 0) {
			size++;
			front = newNode;
			back = newNode;
		}
		
		else {
			Node<Item> traverseNode = front;
			
			if(item.compareTo(front.data) >= 0) {
				newNode.next = front;
				front = newNode;
			}
			
			else if(item.compareTo(back.data) <= 0) {
				back.next = newNode;
				back = newNode;
			}
			
			else{


				while(!(compare.compare(item, traverseNode.data) >= 0 && compare.compare(item, traverseNode.next.data) <= 0)){
					traverseNode = traverseNode.next;
				}

				newNode.next = traverseNode.next;
				traverseNode.next = newNode;
			}
			
			
			size++;
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	@Override
	public void clear() {
		size = 0;
		
		Node<Item> iterateNode = front;
		
		for(int i = 1; i <= this.size(); i++) {
			iterateNode.data = null;
			iterateNode = iterateNode.next;
		}
	}
	@Override
	public Item peek() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		return front.data;
	}
	@Override
	public ArrayList<Item> toArrayList() {
		ArrayList<Item> list = new ArrayList<Item>();
		Node<Item> iterateNode = front;
		
		for(int i = 1; i <= this.size(); i++) {
			list.add(iterateNode.data);
			iterateNode = iterateNode.next;
		}

		return list;
	}
	
	
	
	

}
