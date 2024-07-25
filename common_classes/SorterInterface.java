package common_classes;

/**
 * This interface is used by various classes to sort an array of objects.
 *
 * @author Sameh A. Fakhouri
 */

public interface SorterInterface<T extends Comparable> {

	/**
	 * This method is called to sort the given array of objects.
	 * Objects in the array must either implement the Comparable interface or
	 * extend a class that does.
	 * The method must create and add test data to an internal TestTimes object.
	 *
	 * @param arrayToSort	array that contains the objects to be sorted.
	 */
	public T[] sort(T[] arrayToSort);

}