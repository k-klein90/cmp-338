package hw_4_stack_queue;

/**
 * Generic interface for a FIFO queue.
 *
 * @author Sameh Fakhouri
 */
public interface QueueInterface<T> extends Iterable<T> {

	/**
	 * This method is called to determine if the queue is empty.
	 *
	 * @return 	<b>true</b> if the queue is empty.
	 */
	boolean isEmpty();

	/**
	 * This method is called to obtain the number of elements in the queue.
	 *
	 * @return 	the number of elements that are currently in the queue.
	 */
	int getSize();

	/**
	 * This method is called to update the size of the stack when pushed, popped, or cleared.
	 *
	 * @param	newSize	the updated size.
	 */
	void setSize(int newSize);

	/**
	 * This method adds the specified element into the queue.
	 *
	 * @param 	t	the element to add.
	 *
	 * @throws 	IllegalStateException   if the element cannot be added because the
	 *  								stack is full.
	 * @throws 	NullPointerException	if the specified element being added is null.
	 */
	void enqueue(T t) throws IllegalStateException, NullPointerException;

	/**
	 * This method retrieves, but does not remove, the head of the queue.
	 *
	 * @return	the element at the head of the queue or null if the queue is empty.
	 */
	T peek();

	/**
	 * This method retrieves and removes the element at the head of the queue.
	 *
	 * @throws 	IllegalStateException   if the queue is empty.
	 *
	 * @return	the element at the head of the queue.
	 */
	T dequeue() throws IllegalStateException;

	/**
	 * This method retrieves and removes the element at the specified index.
	 *
	 * @param	index	the index of the element to be removed.
	 *
	 * @throws 	IllegalStateException       if the queue is empty.
	 * @throws  IndexOutOfBoundsException	if the specified index is invalid.
	 *
	 * @return	the element at the specified index.
	 *
	 */
	T dequeue(int index) throws IllegalStateException, IndexOutOfBoundsException;

	/**
	 * This method removes all elements from the queue.
	 */
	void removeAll();

}