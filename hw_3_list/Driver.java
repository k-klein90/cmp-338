package hw_3_list;

import common_classes.TestTimes;
import common_classes.TestTimesPrinter;

public class Driver implements DriverInterface {

    @Override
    public List<Integer> createList(ListType listType) {
        switch (listType) {
            case ArrayBasedList:
                return new ArrayBasedList<>();
            case LinkedList:
                return new LinkedList<>();
            default:
                return null;
        }
    }

    @Override
    public List<Integer> initializeList(List<Integer> list, int firstNumber, int lastNumber, int increment) {
        for (int value = firstNumber; value <= lastNumber; value += increment) {
            list.add(value);
        }
        return list;
    }

    @Override
    public TestTimes runTestCase(ListType listType, TestType testType, int numberOfTimes) {
        TestTimes testTimes = new TestTimes();
        for (int i = 0; i < numberOfTimes; i++) {
            List<Integer> list = createList(listType);
            switch (testType) {
                case AddSortedEvenPrepop:
                    list = initializeList(list, 1, 9_999, 2);
                    break;
                case RemoveAllAtEvenIndex:
                    list = initializeList(list, 1, 10_000, 1);
                    break;
                default:
            }
            testTimes.getStartData();
            switch (testType) {
                case AddSortedEven:
                case AddSortedEvenPrepop:
                    for (int value = 2; value <= 10_000; value += 2) {
                        list.addSorted(value);
                    }
                    break;
                case AddAll:
                    for (int value = 1; value <= 10_000; value++) {
                        list.add(value);
                    }
                    break;
                case AddAllAtIndexZero:
                    for (int value = 1; value <= 10_000; value++) {
                        list.add(value, 0);
                    }
                    break;
                case RemoveAllAtEvenIndex:
                    int increment = 2;
                    if (listType == ListType.LinkedList) {
                        increment = 1;
                    }
                    for (int index = 1; index < list.getSize(); index += increment) {
                        list.remove(index);
                    }
                    break;
            }
            testTimes.addTestData();
        }
        return testTimes;
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        for (TestType testType : TestType.values()) {
            for (ListType listType : ListType.values()) {
                TestTimes testTimes = driver.runTestCase(listType, testType, 10);
                System.out.println("Test " + testType + " for " + listType.name() + ":");
                TestTimesPrinter.print(testTimes);
            }
        }
    }

}