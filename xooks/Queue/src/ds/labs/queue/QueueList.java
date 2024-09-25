package ds.labs.queue;

import java.util.*;

public class QueueList<Element> implements Queue<Element> {
	private int size = 0;
	private Node<Element> front = null;
	private Node<Element> back = null;
	
	private class Node<T>{
		public T data;
		public Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	@Override
	public void enqueue(Element element) {
		
		if(this.size() == 0) {
			Node<Element> newnode = new Node<Element>(element);
			front = newnode;
			back = newnode;
		
		}
		
		else {
			Node<Element> newback = new Node<Element>(element);
			back.next = newback;
			back = newback;
		}
		
		size++;
		
	}

	@Override
	public void clear() {
		size = 0;
		Node<Element> iterateNode = front;
		
		for(int i = 1; i <= this.size(); i++) {
			iterateNode = null;
			iterateNode = iterateNode.next;
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(this.size() == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Element peek() throws NoSuchElementException {
		if(this.size() == 0) {
			throw new NoSuchElementException();
		}
		else {
			return this.front.data;
		}
	
	}

	@Override
	public Element dequeue() throws NoSuchElementException {
		if(this.size() == 0) {
			size--;
			throw new NoSuchElementException();
		}
		
		else {
			Node<Element> tempfront = front;
			front = front.next;
			size--;
			return tempfront.data;
		}
		
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<Element> toArrayList() {
		ArrayList<Element> list = new ArrayList<Element>();
		Node<Element> iterateNode = front;
		
		for(int i = 1; i <= this.size(); i++) {
			list.add(iterateNode.data);
			iterateNode = iterateNode.next;
		}
		// TODO Auto-generated method stub
		return list;
	}

}
