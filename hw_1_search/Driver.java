package hw_1_search;

import common_classes.TestTimes;

public class Driver implements DriverInterface {

    public int[] getListOfNumbers() {
        int[] listOfNumbers = new int[10_000_000];
        for (int value = 1; value <= listOfNumbers.length; value++){
            listOfNumbers[value-1] = value;
        }
        return listOfNumbers;
    }

    public int[] getTargets() {
        int[] targets = {500, 10_000, 100_000, 1_000_000, 5_000_000, 7_500_000, 10_000_000};
        return targets;
    }

    public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
        LinearSearch linearSearch = new LinearSearch();
        int targetPosition = -1;
        for (int testInstance = 1; testInstance <= numberOfTimes; testInstance++) {
            targetPosition = linearSearch.search(listOfNumbers, target);
        }
        System.out.println("The target value, found using Linear Search, is at position " + targetPosition + ".");
        return linearSearch;
    }

    public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
        BinarySearch binarySearch = new BinarySearch();
        int targetPosition = -1;
        for (int testInstance = 1; testInstance <= numberOfTimes; testInstance++) {
            targetPosition = binarySearch.search(listOfNumbers, target);
        }
        System.out.println("The target value, found using Binary Search, is at position " + targetPosition + ".");
        return binarySearch;
    }

    public static void main(String[] args){
        Driver driver = new Driver();
        for (int target : driver.getTargets()) {
            System.out.println("Target value: " + target);
            double linearSearchAverageTime = driver.runLinearSearch(driver.getListOfNumbers(), target, 8).getAverageTestTime();
            double binarySearchAverageTime = driver.runBinarySearch(driver.getListOfNumbers(), target, 8).getAverageTestTime();
            System.out.println("Average test time for Linear Search (nanoseconds): " + linearSearchAverageTime);
            System.out.println("Average test time for Binary Search (nanoseconds): " + binarySearchAverageTime);
            System.out.println("Factor difference in time between Linear Search and Binary Search: " + (int)(linearSearchAverageTime / binarySearchAverageTime));
            System.out.println();
        }
    }

}