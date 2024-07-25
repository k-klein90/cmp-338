package hw_6_sort_contd;

import common_classes.*;

public class HeapSorter<T extends Comparable> extends Sorter<T> {

    private T[] arr = null;
    private int heapSize;

    @Override
    public T[] sort(T[] arrayToSort){
        if (arrayToSort == null){
            throw new IllegalArgumentException("Array provided is null.");
        } else if (arrayToSort.length == 0) {
            throw new IllegalArgumentException("Array provided is empty.");
        } else if (arrayToSort.length == 1){
            return arrayToSort;
        }

        arr = arrayToSort;
        heapSize = arr.length;

        buildMaxHeap(arr.length-1);
        for (int i = arr.length-1; i > 0; i--){
            swap(arr, 0, i);
            heapSize--;
            heapify(0);
        }
        return arr;
    }

    private int getSiblingIndex(int currIndex){
        if ((currIndex == (heapSize-1)) && (heapSize % 2 == 0)){    //If currItem is last item and tree is
            return -1;                                              //not full, then currItem has no sibling.
        } else {
            if (currIndex % 2 == 0){    //If currItem is right child
                return currIndex-1;
            } else {
                return currIndex+1;
            }
        }
    }

    private int getLargestChildIndex(int currIndex){
        int siblingIndex = getSiblingIndex(currIndex);
        if ((siblingIndex != -1) && (arr[siblingIndex].compareTo(arr[currIndex]) >= 0)){
            return siblingIndex;
        } else {
            return currIndex;
        }
    }

    private void buildMaxHeap(int currIndex){
        if (currIndex < 1){     //If currItem is not a child
            return;
        }

        int parentIndex = (currIndex-1) / 2;
        heapify(parentIndex);

        buildMaxHeap(currIndex-2);
    }

    private int getLeftChildIndex(int currIndex){
        int leftChildIndex = (2*currIndex) + 1;
        if (leftChildIndex >= heapSize){    //If left child does not exist
            return -1;
        } else {
            return leftChildIndex;
        }
    }

    private void heapify(int currIndex){
        boolean swapped = true;
        while   (swapped &&
                (currIndex < heapSize) &&
                (getLeftChildIndex(currIndex) != -1)){
            int largestChildIndex = getLargestChildIndex( getLeftChildIndex(currIndex) );

            if (arr[largestChildIndex].compareTo(arr[currIndex]) > 0){
                swap(arr, currIndex, largestChildIndex);
                currIndex = largestChildIndex;
            } else {
                swapped = false;
            }
        }
    }

}