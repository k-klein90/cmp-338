package hw_2_sort;

import common_classes.Sorter;

public class SelectionSorter<T extends Comparable> extends Sorter<T> {

    public T[] sort(T[] arrayToSort){
        for (int i = 0; i < arrayToSort.length-1; i++){
            int minIndex = i;
            for (int j = i+1; j < arrayToSort.length; j++){
                if (arrayToSort[j].compareTo(arrayToSort[minIndex]) < 0){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                swap(arrayToSort, i, minIndex);
            }
        }
        return arrayToSort;
    }

}