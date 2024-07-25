package hw_4_stack_queue;

/**
 * Generic interface for a LIFO stack.
 *
 * @author Sameh Fakhouri
 */
public interface StackInterface<T> extends Iterable<T> {

	/**
	 * This method is called to determine if the stack is empty.
	 *
	 * @return 	<b>true</b> if the stack is empty.
	 */
	boolean isEmpty();

	/**
	 * This method is called to obtain the number of elements in the stack.
	 *
	 * @return 	the number of elements that are currently in the stack.
	 */
	int getSize();

	/**
	 * This method is called to update the size of the stack when pushed, popped, or cleared.
	 *
	 * @param	newSize	the updated size.
	 */
	void setSize(int newSize);

	/**
	 * This method pushes the specified element onto the stack.
	 *
	 * @param 	t	the element to add.
	 *
	 * @throws 	IllegalStateException	if the element cannot be added because the
	 * 									stack is full.
	 * @throws 	NullPointerException	if the specified element being added is null.
	 */
	void push(T t) throws IllegalStateException, NullPointerException;

	/**
	 * This method retrieves, but does not remove, the top element of the stack.
	 *
	 * @return	the element at the top of the stack or null if the stack is empty.
	 */
	T peek();

	/**
	 * This method retrieves and removes the element at the top of the stack.
	 *
	 * @throws 	IllegalStateException	if there are no elements in the stack to
	 * 									return.
	 *
	 * @return	the element at the top of the stack.
	 */
	T pop() throws IllegalStateException;

	/**
	 * This method removes all elements from the stack.
	 */
	void clear();

}