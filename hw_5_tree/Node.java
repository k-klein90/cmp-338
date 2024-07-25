package hw_5_tree;

public class Node<V> {

    private final int key;
    private final Item<V> item;

    private Node<V> parent = null;
    private Node<V> leftChild = null;
    private Node<V> rightChild = null;

    public Node(Item<V> item) {
        key = item.getKey();
        this.item = item;
    }

    public int getKey(){
        return key;
    }

    public Item<V> getItem() {
        return item;
    }

    public void setFamily(Node<V> parent, Node<V> leftChild, Node<V> rightChild){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node<V> getParent() {
        return parent;
    }

    public void setParent(Node<V> parent) {
        this.parent = parent;
    }

    public Node<V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<V> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<V> rightChild) { this.rightChild = rightChild; }

}