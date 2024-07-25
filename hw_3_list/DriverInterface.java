package hw_3_list;

import common_classes.TestTimes;

/**
 * This is the DriverInterface for Homework 3
 *
 * @author Sameh A. Fakhouri
 */
public interface DriverInterface {

	/**
	 * This <code>enum</code> is used to specify which list implementation to use.
	 * All list implementations used in this assignment will be lists of <b>Integer</b>.
	 * The <code>ListType</code> enum has the following choices:
	 * 		<ol>
	 * 			<li>ArrayBasedList</li>
	 * 			<li>LinkedList</li>
	 * 		</ol>
	 */
	enum ListType {ArrayBasedList, LinkedList}

	/**
	 * This <code>enum</code> is used to specify which test scenario will be executed.
	 * The <code>TestType</code> enum has the following choices:
	 * 		<ol>
	 * 			<li>AddSortedEven</li>
	 * 			<li>AddSortedEvenPrepop</li>
	 * 			<li>AddAll</li>
	 * 			<li>AddAllAtIndexZero</li>
	 * 			<li>RemoveAllAtEvenIndex</li>
	 * 		</ol>
	 */
	enum TestType {AddSortedEven, AddSortedEvenPrepop, AddAll, AddAllAtIndexZero, RemoveAllAtEvenIndex}

	/**
	 * This method is used to create a new list of the specified <b>ListType</b>.
	 *
	 * @param listType	the type of list to create.
	 *
	 * @return	the created list as a List.
	 */
	List<Integer> createList(ListType listType);

	/**
	 * This method is called by the createList() method to initialize the test list.
	 * The test list could either be an ArrayList or a LinkedList. In either case,
	 * it will implement the List.
	 *
	 * @param 	list		the list to be initialized.
	 *
	 * @param 	firstNumber	the first number to be added to the list.
	 *
	 * @param 	lastNumber	the last number to be added to the list.
	 *
	 * @param 	increment	the increment to be used by the for loop for each iteration.
	 *                      If the increment is zero, the test list is left empty.
	 *
	 * @return	the initialized list.
	 */
	List<Integer> initializeList(List<Integer> list,  int firstNumber, int lastNumber, int increment);

	/**
	 * This method is called to run a particular test case on a list type up to a
	 * total of ten times. The test time for each run is saved in the TestTimes class.
	 *
	 * @param 	listType		the type of list needed.
	 * @param 	testType		the type of test case being run.
	 * @param 	numberOfTimes 	the number of times to run the specified test.
	 *
	 * @return	an instance of the <code>TestTimes</code> class.
	 */
	TestTimes runTestCase(ListType listType, TestType testType, int numberOfTimes);

}