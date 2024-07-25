package hw_4_stack_queue;

import common_classes.LinkedListNode;

import java.util.Iterator;

public class LinkedQueue<T extends Comparable<T>> extends Queue<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    public LinkedQueue() {
        head = new LinkedListNode<>(null, null, null);
        tail = new LinkedListNode<>(null, head, null);
        head.setNext(tail);
    }

    private class ElementIterator implements Iterator<T> {
        private int elementIndex;
        private LinkedListNode<T> elementNode;

        public ElementIterator() {
            elementIndex = 0;
            elementNode = tail.getPrev(); //Element at tail.getPrev() is at start of queue
        }

        @Override
        public boolean hasNext() {
            return elementIndex < getSize();
        }

        @Override
        public T next() {
            T nextElement = elementNode.getData();
            elementIndex++;
            elementNode = elementNode.getPrev();
            return nextElement;
        }
    }

    @Override
    public void enqueue(T t) {
        if (t == null){
            throw new NullPointerException("Null elements cannot be added to queue.");
        } else {
            LinkedListNode<T> enqueuedNode = new LinkedListNode<>(t, head, head.getNext());
            head.getNext().setPrev(enqueuedNode);
            head.setNext(enqueuedNode);
            setSize(getSize()+1);
        }
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        } else {
            return tail.getPrev().getData();
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("There are no elements in queue to be removed.");
        } else {
            setSize(getSize()-1);
            LinkedListNode<T> dequeuedNode = tail.getPrev();
            tail.setPrev(dequeuedNode.getPrev());
            dequeuedNode.getPrev().setNext(tail);
            return dequeuedNode.getData();
        }
    }

    //    I don't like this method. It is incompatible with the functionality of a queue.
    @Override
    public T dequeue(int index) {
        if (isEmpty()){
            throw new IllegalStateException("There are no elements in queue to be removed.");
        } else if (index > getSize()-1) {
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        } else {
            setSize(getSize()-1);
            LinkedListNode<T> currentNode = head.getNext();
            for (int i = 0; i < index; i++){
                currentNode = currentNode.getNext();
            }
            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode.getNext().setPrev(currentNode.getPrev());
            return currentNode.getData();
        }
    }

    @Override
    public void removeAll() {
        setSize(0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

}