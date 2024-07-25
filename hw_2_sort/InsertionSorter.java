package hw_2_sort;

import common_classes.Sorter;

public class InsertionSorter<T extends Comparable> extends Sorter<T> {

    public T[] sort(T[] arrayToSort){
//        T[] arr = new T[](arrayToSort);
        for (int endSortIndex = 0; endSortIndex < arrayToSort.length-1; endSortIndex++){
            for (int i = endSortIndex; (i >= 0) && (arrayToSort[i+1].compareTo(arrayToSort[i]) < 0); i--){
                swap(arrayToSort, i, i+1);
            }
        }
        return arrayToSort;
    }

}