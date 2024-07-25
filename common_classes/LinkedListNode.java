package common_classes;

/**
 * This class is used for LinkedList in hw3 and for LinkedQueue and LinkedStack in hw4.
 */
public class LinkedListNode<T extends Comparable<T>> {

    private T data;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;

    public LinkedListNode(T data, LinkedListNode<T> prev, LinkedListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedListNode<T> prev) {
        this.prev = prev;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

}