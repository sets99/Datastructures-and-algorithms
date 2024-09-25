package ds.labs.queue;

import java.util.ArrayList;

public interface Queue<Element> {
	
	/**
	 *  Adds an object to the back of the Queue.
	 * @param Element Element
	 */
	public void enqueue(Element element);
	
	/**
	 *   Clears all elements from the Queue.
	 */
	public void clear();
    
    /**
  	 *    Returns true if the queue is empty.
	 *    @return  boolean 
  	 */
	public boolean	isEmpty();
    
     /**
  	 *    Returns the element on the front of Queue but does not remove it.
  	 *    NoSuchElementException - if this queue is empty
	 *    @return  Element 
  	 */
	public Element	peek();
    
     /**
  	 *    Returns the element on the front of the Queue and removes it.
  	 *    NoSuchElementException - if this queue is empty
  	 *    @return  Element 
  	 */
	public Element	dequeue();

     /**
  	 *    Returns the number of elements in this Queue.
  	 *    @return int size
  	 */
    
	public int size();
     /**
   	 *    Returns a string representation of this Queue.
   	 *    @return String : That contains the following:
   	 *    The number of items followed by the items.
   	 *    This Queue has 4 items: a, b, c, d  
   	 */
	public String	toString() ;    
  
    /**
   	 *    Returns a copy of the references to the elements in their current position.
   	 *     @return   ArrayList<Element> 
   	 */
	public ArrayList<Element>	toArrayList() ;
   
	
}
