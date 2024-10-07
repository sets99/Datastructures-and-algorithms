package ds.labs;

import java.util.EmptyStackException;

public class StackList<Item> implements LifoStack<Item> {
	private int size = 0;
	private Node<Item> head = new Node<Item>(null);
	
	
	private class Node<T> {
		public T data;
		public Node<T> next;
				
		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	
	@Override
	public void push(Item item) {
		size++;

		Node<Item> newnode = new Node<Item>(item);
		
		if(head.data == null) {
			head = newnode;
		}
		
		else {
			newnode.next = head;
			head = newnode;
		}
	
	}


	@Override
	public Item pop() throws EmptyStackException {
		if(this.size() == 0) {
			throw new EmptyStackException();
		}
		
		else {
			size--;
			Item currData = head.data;
			head = head.next;
			return currData;
		
		}
	}

	@Override
	public Item peek() throws EmptyStackException {
		if(this.size() == 0) {
			throw new EmptyStackException();
		}
		else {
			return head.data;
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
	public void makeEmpty() {
		
	}

	@Override
	public int size() {
		return size;
	}

}
