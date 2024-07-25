package hw_4_stack_queue;

import common_classes.TestTimes;
import java.util.Iterator;

public class Driver implements DriverInterface {

    @Override
    public Queue<String> createQueue(QueueType queueType, QueueTestType queueTestType) {
        Queue<String> queue = null;
        switch (queueType){
            case ArrayBasedQueue:
                queue = new ArrayBasedQueue<>();
                break;
            case LinkedQueue:
                queue = new LinkedQueue<>();
                break;
        }
        switch (queueTestType) {
            case Dequeue:
            case Iterate:
                for (int i = 1; i <= 1_000; i++) {
                    queue.enqueue("String " + i);
                }
                break;
            default:
        }
        return queue;
    }

    @Override
    public Stack<String> createStack(StackType stackType, StackTestType stackTestType) {
        Stack<String> stack = null;
        switch (stackType) {
            case ArrayBasedStack:
                stack = new ArrayBasedStack<>();
                break;
            case LinkedStack:
                stack = new LinkedStack<>();
                break;
        }
        switch (stackTestType) {
            case Pop:
            case Iterate:
                for (int i = 1; i <= 1_000; i++) {
                    stack.push("String " + i);
                }
                break;
            default:
        }
        return stack;
    }

    @Override
    public TestTimes runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes) {
        TestTimes queueTestTimes = new TestTimes();
        for (int j = 0; j < numberOfTimes; j++) {
            Queue<String> queue = createQueue(queueType, queueTestType);
            queueTestTimes.getStartData();
            switch (queueTestType) {
                case Enqueue:
                    for (int i = 1; i <= 1_000; i++) {
                        queue.enqueue("String " + i);
                    }
                    break;
                case Dequeue:
                    for (int i = 0; i < queue.getSize(); i++) {
                        queue.dequeue();
                    }
                    break;
                case Iterate:
                    Iterator<String> iterator = queue.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
            }
            queueTestTimes.addTestData();
        }
        return queueTestTimes;
    }

    @Override
    public TestTimes runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes) {
        TestTimes stackTestTimes = new TestTimes();
        for (int j = 0; j < numberOfTimes; j++) {
            Stack<String> stack = createStack(stackType, stackTestType);
            stackTestTimes.getStartData();
            switch (stackTestType) {
                case Push:
                    for (int i = 1; i <= 1_000; i++) {
                        stack.push("String " + i);
                    }
                    break;
                case Pop:
                    for (int i = 0; i < stack.getSize(); i++) {
                        stack.pop();
                    }
                    break;
                case Iterate:
                    Iterator<String> iterator = stack.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
            }
            stackTestTimes.addTestData();
        }
        return stackTestTimes;
    }

    //Can the queues and stacks be tested in the same code block?
    //check out DataStruct in interface
    //Issue: First (and often second) run is long, especially for Iterate.
    public static void main(String[] args){
        Driver driver = new Driver();
        for (QueueType queueType : QueueType.values()) {
            for (QueueTestType queueTestType : QueueTestType.values()) {
                TestTimes testTimes = driver.runQueueTestCase(queueType, queueTestType, 10);
                testTimes.setTimeUnits(TestTimes.TimeUnits.MicroSeconds);
                testTimes.setMemoryUnits(TestTimes.MemoryUnits.KiloBytes);
                double[] arrOfTimes = testTimes.getTestTimes();
                double[] arrOfMems = testTimes.getMemoryUsages();

                System.out.println("Test " + queueTestType.name() + " for " + queueType.name() + ":");
                System.out.print(queueTestType.name() + " test times (" + testTimes.getTimeUnits().name() + "): ");
                for (int i = 0; i < arrOfTimes.length; i++){
                    System.out.print(arrOfTimes[i]);
                    if (i < (arrOfTimes.length-1)){
                        System.out.print(", ");
                    } else {System.out.println();}
                }
                System.out.println("Average test time (" + testTimes.getTimeUnits().name() + "): " + testTimes.getAverageTestTime());

                System.out.print(queueTestType.name() + " memory usages (" + testTimes.getMemoryUnits().name() + "): ");
                for (int i = 0; i < arrOfMems.length; i++){
                    System.out.print(arrOfMems[i]);
                    if (i < (arrOfMems.length-1)){
                        System.out.print(", ");
                    } else {System.out.println();}
                }
                System.out.println("Memory usage (" + testTimes.getMemoryUnits().name() + "): " + testTimes.getAverageMemoryUsage());
                System.out.println();
            }
        }

        for (StackType stackType : StackType.values()) {
            for (StackTestType stackTestType : StackTestType.values()) {
                TestTimes testTimes = driver.runStackTestCase(stackType, stackTestType, 10);
                testTimes.setTimeUnits(TestTimes.TimeUnits.MicroSeconds);
                testTimes.setMemoryUnits(TestTimes.MemoryUnits.KiloBytes);
                double[] arrOfTimes = testTimes.getTestTimes();
                double[] arrOfMems = testTimes.getMemoryUsages();

                System.out.println("Test " + stackTestType.name() + " for " + stackType.name() + ":");
                System.out.print(stackTestType.name() + " test times (" + testTimes.getTimeUnits().name() + "): ");
                for (int i = 0; i < arrOfTimes.length; i++){
                    System.out.print(arrOfTimes[i]);
                    if (i < (arrOfTimes.length-1)){
                        System.out.print(", ");
                    } else {System.out.println();}
                }
                System.out.println("Average test time (" + testTimes.getTimeUnits().name() + "): " + testTimes.getAverageTestTime());

                System.out.print(stackTestType.name() + " memory usages (" + testTimes.getMemoryUnits().name() + "): ");
                for (int i = 0; i < arrOfMems.length; i++){
                    System.out.print(arrOfMems[i]);
                    if (i < (arrOfMems.length-1)){
                        System.out.print(", ");
                    } else {System.out.println();}
                }
                System.out.println("Memory usage (" + testTimes.getMemoryUnits().name() + "): " + testTimes.getAverageMemoryUsage());
                System.out.println();
            }
        }
    }

}