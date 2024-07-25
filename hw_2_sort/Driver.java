package hw_2_sort;

import common_classes.*;
import java.util.Random;

public class Driver implements DriverInterface {

    public Integer[] createArray(ArrayType arrayType, int arraySize){
        Integer[] arr = new Integer[arraySize];
        Random random = new Random();
        int num = random.nextInt(1_000_000);
        switch (arrayType){
            case Equal: {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = num;
                }
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

    public TestTimes runSort(Sorter sorter, Integer[] arr, int numberOfTimes){
        TestTimes testTimes = new TestTimes();
        for (int i = 0; i < numberOfTimes; i++){
            testTimes.getStartData();
            Integer[] sortedArr = (Integer[]) sorter.sort(arr); //Is there a way not to cast the array?
            testTimes.addTestData();
            checkSortedArr(sortedArr);
        }
        return testTimes;
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
        int[] sortSampleSizes = {1_000, 10_000};

        for (ArrayType at : ArrayType.values()){
            for (int size : sortSampleSizes){
                System.out.println(at.name() + " array with " + size + " elements:");
                for (SortType st : SortType.values()){
                    System.out.println(st.name() + ":");
                    Integer[] arr = driver.createArray(at, size);
                    TestTimes testTimes = driver.runSort(st.getImplementation(), arr, 10);  //Issue: memory usages are all zero
                    TestTimesPrinter.print(testTimes);
                }
            }
        }
    }

}