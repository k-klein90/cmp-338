package hw_4_stack_queue;

import common_classes.LinkedListNode;

import java.util.Iterator;

public class LinkedStack<T extends Comparable<T>> extends Stack<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    public LinkedStack() {
        head = new LinkedListNode<>(null, null, null);
        tail = new LinkedListNode<>(null, head, null);
        head.setNext(tail);
    }

    private class ElementIterator implements Iterator<T> {
        private int elementIndex;
        private LinkedListNode<T> elementNode;

        public ElementIterator() {
            elementIndex = 0;
            elementNode = head.getNext(); //Element at head.getNext() is at top of stack
        }

        @Override
        public boolean hasNext() {
            return elementIndex < getSize();
        }

        @Override
        public T next() {
            T nextElement = elementNode.getData();
            elementIndex++;
            elementNode = elementNode.getNext();
            return nextElement;
        }
    }

    @Override
    public void push(T t) {
        if (t == null){
            throw new NullPointerException("Null elements cannot be pushed onto stack.");
        } else {
            LinkedListNode<T> pushedNode = new LinkedListNode<>(t, head, head.getNext());
            head.getNext().setPrev(pushedNode);
            head.setNext(pushedNode);
            setSize(getSize()+1);
        }
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        } else {
            return head.getNext().getData();
        }
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("There are no elements in stack to be popped off.");
        } else {
            setSize(getSize()-1);
            LinkedListNode<T> poppedNode = head.getNext();
            head.setNext(poppedNode.getNext());
            poppedNode.getNext().setPrev(head);
            return poppedNode.getData();
        }
    }

    @Override
    public void clear() {
        setSize(0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

}