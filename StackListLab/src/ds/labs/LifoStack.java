/**
 * 
 */
package ds.labs;

import java.util.EmptyStackException;

/**
 * An interface representing a resizable stack data structure.
 * This stack supports standard stack operations (push, pop, peek) 
 * and also includes a mechanism for resizing when needed.
 *
 * @param <T> the type of elements held in this stack
 */
public interface LifoStack <Item> {
	
	/**
	 * Insert a new item into the stack.
	 * @param item the item to insert.
	 */
	public void push(Item item) ;
	
	/**
	 * Remove the most recently inserted item from the stack.
	 * @return the item at the top of the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public Item pop() throws EmptyStackException;
	
	/**
	 * Looks at the object at the top of this stack 
	 * without removing it from the stack.
	 * @return the item at the top of the stack
	 * @throws EmptyStackException if the stack is empty
	 * 
	 */
	public Item peek() throws EmptyStackException;
	
	
	/**
	 * Test if the stack is logically empty.
	 *  @return true if empty, false otherwise.
	 */
	public boolean isEmpty();
	/**
	 *Make the stack logically empty.
	 */
	public void makeEmpty();

	/**
	 * Return the number of items currently on the stack.
	 *  @return number of items currently on the stack.
	 */
	int size();
	
	/**
     * Ensures that the stack has enough capacity to accommodate additional elements.
     * This method checks whether the stack needs resizing and resizes it if necessary.
     */
    default void ensureCapacity() {
        if (needsResize()) {
            resize(); // Call the private resize method
        }
    }

    /**
     * Resizes the internal data structure to accommodate more elements.
     * This method is private and can only be called internally within the interface.
     */
    private void resize() {
        //System.out.println("Resizing the stack...");
        // Logic for resizing would go here
    }

    /**
     * Checks if the stack needs to be resized.
     * This is a private method, used internally by the {@code ensureCapacity()} method.
     *
     * @return {@code true} if the stack needs to be resized; {@code false} otherwise
     */
    private boolean needsResize() {
        // Dummy condition to simulate when resizing is needed
        return true;
    }
	
}


