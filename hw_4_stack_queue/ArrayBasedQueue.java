package hw_4_stack_queue;

import java.util.Iterator;

public class ArrayBasedQueue<T> extends Queue<T> {

    private static class Wrapper<T> {
        final T t;
        Wrapper(T t) {this.t = t;}
    }

    private final static int MAX_SIZE = 10_000;
    private int headIndex = 0;
    private Wrapper<T>[] queue = new Wrapper[MAX_SIZE];

    private class ElementIterator implements Iterator<T> {
        private int elementIndex;

        public ElementIterator() {
            elementIndex = headIndex; //Element at index = headIndex is at start of queue
        }

        @Override
        public boolean hasNext() {
            return elementIndex < getSize();
        }

        @Override
        public T next() {
            T nextElement = queue[elementIndex].t;
            elementIndex = (elementIndex+1) % MAX_SIZE;
            return nextElement;
        }
    }

    @Override
    public void enqueue(T t) {
        if (t == null){
            throw new NullPointerException("Null elements cannot be added to queue.");
        } else if (getSize() >= MAX_SIZE){
            throw new IllegalStateException("Elements cannot be added to full queue.");
        } else {
            queue[(headIndex + getSize()) % MAX_SIZE] = new Wrapper<>(t);
            setSize(getSize()+1);
        }
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        } else {
            return queue[headIndex].t;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("There are no elements in queue to be removed.");
        } else {
            T dequeuedElement = queue[headIndex].t;
            headIndex = (headIndex+1) % MAX_SIZE;
            setSize(getSize()-1);
            return dequeuedElement;
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
            T dequeuedElement = queue[(headIndex + index) % MAX_SIZE].t;
            for (int i = (headIndex + index) % MAX_SIZE; i != headIndex; i = (i-1) % MAX_SIZE){
                queue[i] = queue[(i-1) % MAX_SIZE];
            }
            headIndex = (headIndex+1) % MAX_SIZE;
            setSize(getSize()-1);
            return dequeuedElement;
        }
    }

    @Override
    public void removeAll() {
        setSize(0);
        headIndex = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

}