package ds.bst;

import static org.junit.jupiter.api.Assertions.fail;//remove once code is complete

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unused")
public class BSTree <Key extends Comparable<Key>, Value> implements BinarySearchTree<Key, Value>  {
	
	
	private Node<Key, Value> root;
	
	private Comparator<Key> comparator;
	
	private int size = 0;

	
	public BSTree() {
		this.comparator = (k1 , k2) -> {return k1.compareTo(k2);};
	}
	
	public BSTree(Comparator<Key> comparator) {
		
		super();
		this.comparator = comparator;
	}
	
	private static class Node<Key extends Comparable<Key>, Value> 
	{
				
		public Node(Key key, Value data) {
			// this is a leaf node
			super();			
			this.data = data;
			this.key = key;
			this.rightChild = null;
			this.leftChild = null;
		}

		 public Key key;		 
		 public Value data;		
		 public Node<Key, Value> rightChild;		
		 public Node<Key, Value> leftChild;
	}
	
	

   
   
 
	@Override
	public void printTree(Traversal order) {
		
	// If only I had a method that got a list of the different traversals...
		fail("Not yet implemented");
		
	}
	
	@Override
	public void clear() {
		fail("Not yet implemented");
	}

	@Override
	public boolean insert(Key key, Value value) {
		fail("Not yet implemented");
		return false;
		
	}

	public boolean isEmpty()
	{
		fail("Not yet implemented");
		return false;
	}
	@Override
	public int size() {
		fail("Not yet implemented");
		return 0;
	}

	@Override
	public boolean contains(Key key) {
		
			fail("Not yet implemented");
			return false;
		
	
	}

	
	public Value remove(Key key) {
		
		fail("Not yet implemented");
		return null;
	}

	
	
	@Override
	public ArrayList<Value> values(Traversal order) {
		
		fail("Not yet implemented");
		return null;
	}
	@Override
	public Value findIteratively(Key key) {
		
		fail("Not yet implemented");
		return null;
	}
	
	
	
	
	@Override
	public Value findRecursively(Key key) {
		
		fail("Not yet implemented");
		return null;
	
	}
	
	

}
