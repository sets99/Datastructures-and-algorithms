package ds.heap;

import java.util.ArrayList;

import org.w3c.dom.Element;

public class MinHeap implements MinHeapInterface<Element> {
	private Comparator<Element> comparator;
	
	ArrayList<Element> heap = new ArrayList<Element>();

	@Override
	public void add(Element element) {
		heap[heap.size()-1] = element;
		int i = heap.size()-1;
		while(heap.get(i).compareTo(heap.get((i-1)/2)) < 0) {
			Element temp = heap.get(i);
			heap.set(i, heap.get((i-1)/2));
			heap.set((i-1)/2, temp);
			i = (i-1)/2;
		}
		
	}

	@Override
	public void clear() {
		for(int i = 0; i <= heap.size(); i++) {
			heap.set(i,  null);
		}
		
	}

	@Override
	public Element get() {
		return heap[0];
	}

	@Override
	public boolean isEmpty() {
		if(heap.size() == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Element peek() {
		return heap[0];
	}

	@Override
	public Element pop() {
		Element temp = heap[0];
		heap[0] = null;
		return temp;
	}

	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public void update(int index) {
		
		
	}

	@Override
	public ArrayList<Element> toArrayList() {
		return heap;
	}

}
