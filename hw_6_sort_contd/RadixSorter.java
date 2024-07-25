package hw_6_sort_contd;

import common_classes.TestTimes;

public class RadixSorter extends TestTimes {

    public String[] sort(String[] arr){
        int numItems = arr.length;
        int numDigits = arr[0].length();
        int ASCIISize = 256;
        String[] auxArr = new String[numItems];

        for (int digitIndex = numDigits-1; digitIndex >= 0; digitIndex--){
            int[] charCountArr = new int[ASCIISize]; //ASCIISize+1?

            for (int i = 0; i < numItems; i++){

            }
        }

        return arr;
    }

}