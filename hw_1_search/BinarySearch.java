package hw_1_search;

public class BinarySearch extends Search implements SearchInterface {

    public int search(int[] listOfNumbers, int target){
        getStartData();
        int startIndex = 0;
        int endIndex = listOfNumbers.length - 1;

        while (startIndex <= endIndex){
            int midpoint = (startIndex + endIndex)/2;

            if (listOfNumbers[midpoint] == target){
                addTestData();
                return midpoint;
            }

            if (listOfNumbers[midpoint] < target){
                startIndex = midpoint + 1;
            }

            if (listOfNumbers[midpoint] > target){
                endIndex = midpoint - 1;
            }
        }

        addTestData();
        return -1;
    }

}