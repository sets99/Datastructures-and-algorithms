package ds.labs;

import java.util.EmptyStackException;

import ds.stockspan.LifoStack;

public class StackArray<Item> implements LifoStack<Item> {
	private Item[] array;
	
	public int emptyBlock = 0;
	
	@SuppressWarnings("unchecked")
	public StackArray(){
		array = (Item[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public StackArray(int size){
		array = (Item[]) new Object[size];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void push(Item item) {
		if(emptyBlock == array.length) {
			Item[] array2 = array;
			array = (Item[]) new Object[array2.length+1];
			for(int i = 0; i < array2.length; i++) {
				array[i] = array2[i];
			}
		}
		
		
		
		array[emptyBlock] = item;
		emptyBlock++;
	}

	@Override
	public Item pop() throws EmptyStackException {
		if(emptyBlock == 0) {
			throw new EmptyStackException();
		}
		
		else {
			int oldEmptyBlock = emptyBlock;
			emptyBlock--;
			return array[oldEmptyBlock-1];
		}
	}

	@Override
	public Item peek() throws EmptyStackException {
		if(emptyBlock == 0) {
			throw new EmptyStackException();
		}
		
		else {
			return array[emptyBlock-1];
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(emptyBlock == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public void makeEmpty() {
		for(int i = 0; i <= array.length; i++) {
			array[i] = null;
		}
		
	}

	@Override
	public int size() {
		return emptyBlock;
	}

}
