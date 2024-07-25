package hw_2_sort;

import common_classes.Sorter;

import java.io.Serializable;

public class BubbleSorter<T extends Comparable> extends Sorter<T> {

    public T[] sort(T[] arrayToSort){
        boolean swapOccurred;
        do {
            swapOccurred = false;
            for (int i = 0; i < arrayToSort.length-1; i++){
                if (arrayToSort[i].compareTo(arrayToSort[i+1]) > 0){
                    swap(arrayToSort, i, i+1);
                    swapOccurred = true;
                }
            }
        } while (swapOccurred);
        return arrayToSort;
    }

}