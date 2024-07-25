package hw_4_stack_queue;

import common_classes.TestTimes;

public interface DriverInterface {

//	enum DataStruct {
//		Queue (QueueType, QueueTestType),
//		Stack (StackType, StackTestType);
//
//		public enum Type {QueueType, StackType};
//		public enum Test {QueueTestType, StackTestType};
//
//		public Type type;
//		public Test test;
//
//		DataStruct(Type type, Test test) {
//			this.type = type;
//			this.test = test;
//		}
//	}

	/**
	 * This enum has the following values:
	 * 		<ol>
	 * 			<li>ArrayBasedQueue</li>
	 * 			<li>LinkedQueue</li>
	 * 		</ol>
	 */
	enum QueueType {ArrayBasedQueue, LinkedQueue}

	/**
	 * This enum has the following values:
	 * 		<ol>
	 * 			<li>Enqueue</li>
	 * 			<li>Dequeue</li>
	 * 			<li>Iterate</li>
	 * 		</ol>
	 */
	enum QueueTestType {Enqueue, Dequeue, Iterate}

	/**
	 * This enum has the following values:
	 * 		<ol>
	 * 			<li>ArrayBasedStack</li>
	 * 			<li>LinkedStack</li>
	 * 		</ol>
	 */
	enum StackType {ArrayBasedStack, LinkedStack}

	/**
	 * This enum has the following values:
	 * 		<ol>
	 * 			<li>Push</li>
	 * 			<li>Pop</li>
	 * 			<li>Iterate</li>
	 * 		</ol>
	 */
	enum StackTestType {Push, Pop, Iterate}

	/**
	 * This method creates a new queue of the specified queue type. Depending
	 * on the specified queue test type, this method may need to initialize the
	 * queue with some entries.
	 *
	 * @param queueType		the type of queue to create.
	 *
	 * @param queueTestType	the type of test that the queue is being created for.
	 *
	 * @return		the created queue as a QueueInterface&lt;String&gt;.
	 */
	Queue<String> createQueue(QueueType queueType, QueueTestType queueTestType);

	/**
	 * This method creates a new stack of the specified stack type. Depending on
	 * the specified stack test type, this method may need to initialize the queue
	 * with some entries.
	 *
	 * @param stackType		the type of stack to create.
	 *
	 * @param stackTestType	the type of test that the stack is being created for.
	 *
	 * @return		the created stack as a StackInterface&lt;String&gt;.
	 */
	Stack<String> createStack(StackType stackType, StackTestType stackTestType);

	/**
	 * This method runs a specified test case on a specified queue type the specified
	 * number of times. The run time and memory usage for each run is saved in
	 * the TestTimes class.
	 *
	 * @param 	queueType		the type of queue needed for the test case.
	 * @param 	queueTestType	the type of test case being run.
	 * @param 	numberOfTimes 	the number of times to run the specified test.
	 *
	 * @return	a TestTimes object containing the saved test times and memory usages.
	 */
	TestTimes runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes);

	/**
	 * This method runs a specified test case on a specified stack type the specified
	 * number of times. The run time and memory usage for each run is saved in
	 * the TestTimes class.
	 *
	 * @param 	stackType		the type of stack needed for the test case.
	 * @param 	stackTestType	the type of test case being run.
	 * @param 	numberOfTimes 	the number of times to run the specified test.
	 *
	 * @return	a TestTimes object containing the saved test times and memory usages.
	 */
	TestTimes runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes);

}