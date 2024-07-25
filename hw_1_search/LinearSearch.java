package hw_1_search;

public class LinearSearch extends Search implements SearchInterface {

    public int search(int[] listOfNumbers, int target) {
        getStartData();
        for (int position = 0; position < listOfNumbers.length; position++) {
            if (listOfNumbers[position] == target) {
                addTestData();
                return position;
            }
        }
        addTestData();
        return -1;
    }

}