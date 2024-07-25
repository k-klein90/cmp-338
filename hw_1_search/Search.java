package hw_1_search;

import common_classes.TestTimes;

public abstract class Search extends TestTimes implements SearchInterface {

    public abstract int search(int[] listOfNumbers, int target);

}