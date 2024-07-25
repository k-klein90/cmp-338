package hw_6_sort_contd;

import common_classes.*;
import java.util.LinkedList;
import java.util.List;

public class MergeSorter<T extends Comparable<T>> extends Sorter<T> {

    private T[] arr = null;

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
        return sort(0, arrayToSort.length).toArray(arrayToSort);
    }

    private List<T> sort(int startIndex, int endIndex){   //endIndex is non-inclusive.
        if (endIndex-startIndex == 1){
            LinkedList<T> list = new LinkedList<>();
            list.add(arr[startIndex]);
            return list;
        } else {
            int midpoint = (startIndex + endIndex) / 2;
            List<T> leftList = sort(startIndex, midpoint);
            List<T> rightList = sort(midpoint, endIndex);
            return merge(leftList, rightList);
        }
    }

    private List<T> merge(List<T> leftList, List<T> rightList){
        LinkedList<T> mergedList = new LinkedList<>();

        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftList.size() && rightIndex < rightList.size()){
            if (leftList.get(leftIndex).compareTo(rightList.get(rightIndex)) <= 0){
                mergedList.add(leftList.get(leftIndex));
                leftIndex++;
            } else {
                mergedList.add(rightList.get(rightIndex));
                rightIndex++;
            }
        }
        while (leftIndex < leftList.size()){
            mergedList.add(leftList.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < rightList.size()){
            mergedList.add(rightList.get(rightIndex));
            rightIndex++;
        }

        return mergedList;
    }

}