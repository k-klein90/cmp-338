package hw_6_sort_contd;

import common_classes.*;

public class QuickSorter<T extends Comparable> extends Sorter<T> {

    @Override
    public T[] sort(T[] arrayToSort){
        if (arrayToSort == null){
            throw new IllegalArgumentException("Array provided is null.");
        } else if (arrayToSort.length == 0) {
            throw new IllegalArgumentException("Array provided is empty.");
        } else if (arrayToSort.length == 1){
            return arrayToSort;
        }

        getStartData();
        T[] returnArr = sort(arrayToSort, 0, arrayToSort.length-1);
        addTestData();
        return returnArr;
    }

    private T[] sort(T[] arr, int startIndex, int endIndex){
        //partition portion
        int i = startIndex;
        int j = endIndex;
        T pivotItem = arr[(startIndex + endIndex) / 2]; //pivot could technically be any item

        while (i <= j){
            while (arr[i].compareTo(pivotItem) < 0){    //find item on left side to swap
                i++;
            }
            while (arr[j].compareTo(pivotItem) > 0){    //find item on right side to swap
                j--;
            }

            if (i <= j){                                //check that selected items need to be swapped
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        //recursion portion
        if (j > startIndex){                            //if j is within original index range,
            arr = sort(arr, startIndex, j);             //make recursive call
        }
        if (i < endIndex){                              //if i is within original index range,
            arr = sort(arr, i, endIndex);               //make recursive call
        }

        return arr;
    }

}