package hw_5_tree;

public class Item<V> {

    private final int key;
    private final V value;

    public Item(V value) {
        key = value.hashCode();
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}