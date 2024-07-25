package hw_6_sort_contd;

import common_classes.Sorter;
import common_classes.TestTimes;
import common_classes.TestTimesPrinter;

import java.util.Arrays;
import java.util.Random;

public class Driver implements DriverInterface {

    public Integer[] createArray(ArrayType arrayType, int arraySize){
        Integer[] arr = new Integer[arraySize];
        Random random = new Random();
        int num = random.nextInt(1_000_000);
        switch (arrayType){
            case Equal: {
                Arrays.fill(arr, num);
                break;
            }
            case Random: {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = random.nextInt(1_000_000);
                }
                break;
            }
            case Increasing: {
                int numAdd = random.nextInt(1_000) + 1;
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = num;
                    num += numAdd;
                }
                break;
            }
            case Decreasing: {
                int numSubt = random.nextInt(1_000) + 1;
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = num;
                    num -= numSubt;
                }
                break;
            }
            case IncreasingAndRandom: {
                int partition = arr.length * 9 / 10;
                int numAdd = random.nextInt(1_000) + 1;
                for (int i = 0; i < partition; i++) {
                    arr[i] = num;
                    num += numAdd;
                }
                for (int i = partition; i < arr.length; i++) {
                    arr[i] = random.nextInt(1_000_000);
                }
                break;
            }
        }
        return arr;
    }

    @Override
    public TestTimes[] runSorts(ArrayType arrayType, int arraySize, int numberOfTimes) {
        TestTimes[] testTimesArr = new TestTimes[SortType.values().length];
        int count = 0;
        for (SortType sortType : SortType.values()){
            TestTimes testTimes = new TestTimes();
            for (int i = 0; i < numberOfTimes; i++){
                Integer[] arr = createArray(arrayType, arraySize);
                testTimes.getStartData();
                Integer[] sortedArr = (Integer[]) sortType.getImplementation().sort(arr); //Is there a way not to cast the array?
                testTimes.addTestData();
                checkSortedArr(arr);
            }
            testTimesArr[count] = testTimes;
            count++;
        }
        return testTimesArr;
    }

    private void checkSortedArr(Integer[] arr){
        for (int i = 0; i < (arr.length-1); i++){
            if (arr[i].compareTo(arr[i+1]) > 0) {
                System.out.println("Item " + i + " (value: " + arr[i] + ") NOT in correct relative position.");
            }
        }
    }

    public static void main(String[] args){
        Driver driver = new Driver();
        int arrSize = 10_000;
        int numTimes = 10;
        for (ArrayType at : ArrayType.values()) {
            System.out.println(at.name() + " array:");
            TestTimes[] testTimesArr = driver.runSorts(at, arrSize, numTimes);  //Issue: memory usages are zero for QS and HS
            for (TestTimes testTimes : testTimesArr){
                TestTimesPrinter.print(testTimes);  //need to label each TestTimes with its respective Sorter
            }
        }
    }

}