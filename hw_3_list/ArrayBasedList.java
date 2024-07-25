package hw_3_list;

public class ArrayBasedList<T extends Comparable<T>> extends List<T> {

    private static class Wrapper<T> {
        final T t;
        Wrapper(T t) {this.t = t;}
    }

    private final static int MAX_SIZE = 10_000;
    private Wrapper<T>[] list = new Wrapper[MAX_SIZE];

    @Override
    public T get(int index) {
        T element = null;
        if ((index >= 0) && (index < size)){
            element = list[index].t;
        }
        return element;
    }

    @Override
    public void add(T element) {
        if (size < MAX_SIZE){
            Wrapper<T> elementWrapper = new Wrapper<>(element);
            list[size] = elementWrapper;
            size++;
        }
    }

    @Override
    public boolean add(T element, int index) {
        boolean ifAdded = false;
        if (size < MAX_SIZE && ((index >= 0) && (index <= size))){
            if (index < size) {
                Wrapper<T> elementWrapper = new Wrapper<>(element);
                for (int i = size - 1; i >= index; i--) {
                    list[i + 1] = list[i];
                }
                list[index] = elementWrapper;
                size++;
            } else {
                add(element);
            }
            ifAdded = true;
        }
        return ifAdded;
    }

    @Override
    public void addSorted(T element) {
        if (size < MAX_SIZE){
            Wrapper<T> elementWrapper = new Wrapper<>(element);
            boolean ifAdded = false;
            for (int i = 0; (!ifAdded) && (i < size); i++){
                if (elementWrapper.t.compareTo(list[i].t) < 0){
                    ifAdded = add(element, i);
                }
            }
            if (!ifAdded){
                add(element);
            }
        }
    }

    @Override
    public T replace(T element, int index) {
        if ((index >= 0) && (index < size)){
            Wrapper<T> elementWrapper = new Wrapper<>(element);
            T replacedData = list[index].t;
            list[index] = elementWrapper;
            return replacedData;
        }
        return null;
    }

    @Override
    public boolean remove(int index) {
        boolean ifRemoved = false;
        if ((index >= 0) && (index < size)){
            for (int i = index; i < size-1; i++){
                list[i] = list[i+1];
            }
            size--;
            ifRemoved = true;
        }
        return ifRemoved;
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

}