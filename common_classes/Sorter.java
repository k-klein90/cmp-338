package common_classes;

/**
 * This class is used for the Sorter classes in hw2 and hw6.
 */
public abstract class Sorter<T extends Comparable> extends TestTimes implements SorterInterface<T> {

    public abstract T[] sort(T[] arrayToSort);

    protected void swap(T[] arrayToSort, int left, int right){
        T temp = arrayToSort[left];
        arrayToSort[left] = arrayToSort[right];
        arrayToSort[right] = temp;
    }

}