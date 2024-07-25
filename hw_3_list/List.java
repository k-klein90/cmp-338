package hw_3_list;

public abstract class List<T extends Comparable<T>> implements ListInterface<T> {

    int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean getIfEmpty() {
        return (size == 0);
    }

    public abstract void add(T element);

    public abstract boolean add(T element, int index);

    public abstract void addSorted(T element);

    public abstract T get(int index);

    public abstract T replace(T element, int index);

    public abstract boolean remove(int index);

    public abstract void removeAll();

}