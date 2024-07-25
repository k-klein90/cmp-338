package hw_4_stack_queue;

import java.util.Iterator;

public class ArrayBasedStack<T> extends Stack<T> {

    private static class Wrapper<T> {
        final T t;
        Wrapper(T t) {this.t = t;}
    }

    private final static int MAX_SIZE = 10_000;
    private Wrapper<T>[] stack = new Wrapper[MAX_SIZE];

    private class ElementIterator implements Iterator<T> {
        private int elementIndex;

        public ElementIterator() {
            elementIndex = getSize() - 1; //Element at index = size-1 is at top of stack
        }

        @Override
        public boolean hasNext() {
            return elementIndex >= 0;
        }

        @Override
        public T next() {
            T nextElement = stack[elementIndex].t;
            elementIndex--;
            return nextElement;
        }
    }

    @Override
    public void push(T t) {
        if (t == null){
            throw new NullPointerException("Null elements cannot be pushed onto stack.");
        } else if (getSize() >= MAX_SIZE){
            throw new IllegalStateException("Elements cannot be pushed onto full stack.");
        } else {
            stack[getSize()] = new Wrapper<>(t);
            setSize(getSize()+1);
        }
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        } else {
            return stack[getSize()-1].t;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("There are no elements in stack to be popped off.");
        } else {
            setSize(getSize()-1);
            return stack[getSize()].t;
        }
    }

    @Override
    public void clear() {
        setSize(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

}