package hw_3_list;

/**
 * This interface indicates the public methods that need to be implemented for Homework 3.
 *
 * @author Sameh Fakhouri
 */
public interface ListInterface<T extends Comparable<T>> {

	/**
	 * This method is called to obtain the count of elements in the list.
	 *
	 * @return 	the number of <b>Element</b>s that are currently in the list.
	 */
	int getSize();

	/**
	 * This method is called to determine if the list is empty.
	 *
	 * @return 	boolean of whether the list is empty.
	 */
	boolean getIfEmpty();

	/**
	 * This method is called to add the specified element to the end of the list.
	 *
	 * @param 	element	a reference to the element to be added to the end of the list.
	 */
	void add(T element);

	/**
	 * This method is called to add the specified element to the list at the given index.
	 *
	 * @param 	element	a reference to the element to be added to the list.
	 *
	 * @param 	index 	the position at which to add the specified Element. Using
	 *                  index = 0 indicates that the Element being added should become the
	 *                  <b>head</b> of the list and should succeed even if the list is
	 *                  currently empty.
	 *
	 * @return 	boolean of whether the element was successfully added at the given index.
	 */
	boolean add(T element, int index);

	/**
	 * This method is called to add the specified element to the list in sorted order. More
	 * specifically, the elements preceding the specified element must be "less than" the
	 * specified element, and the elements following the specified element must be "greater
	 * than or equal to" the specified element.
	 *
	 * @param 	element a reference to the <b>element</b> being added, in sorted order,
	 * 					to the list.
	 */
	void addSorted(T element);

	/**
	 * This method is called to retrieve the element at the specified index.
	 *
	 * @param 	index	the position from which to retrieve the element.
	 *
	 * @return	a reference to the <b>Element</b> at the given index, or <b>nullL</b>
	 * 			if the given index is invalid.
	 */
	T get(int index);

	/**
	 * This method is called to replace the current element with the specified <b>element</b> at the specified
	 * <b>index</b>. The method then returns the replaced element or <b>null</b> if no element exists
	 * at the specified <b>index</b>.
	 *
	 * @param 	element	a reference to the <b>element</b> that will replace the current element in the list.
	 *
	 * @param 	index	the position in the list where the replacement should be made.
	 *
	 * @return	a reference to the replaced element, if the replacement is successful. Otherwise,
	 * 			the method will return <b>null</b>.
	 */
	T replace(T element, int index);

	/**
	 * This method is called to remove the element at the specified index.
	 *
	 * @param 	index	the position from which to remove the element.
	 *
	 * @return	boolean of whether the element was successfully removed at the given index.
	 */
	boolean remove(int index);

	/**
	 * This method removes all elements from the list, making the list empty.
	 */
	void removeAll();

}