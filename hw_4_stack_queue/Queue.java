package hw_4_stack_queue;

public abstract class Queue<T> implements QueueInterface<T> {

    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    //I want this method to be protected
    @Override
    public void setSize(int newSize) { size = newSize; }

    public abstract void enqueue(T t);

    public abstract T peek();

    public abstract T dequeue();

    public abstract T dequeue(int index);

    public abstract void removeAll();

}