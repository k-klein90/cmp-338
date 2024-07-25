package hw_5_tree;

import java.util.*;

public class Tree<V> implements Iterable {

    private int size = 0;
    private Node<V> rootNode = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        rootNode = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public int getHeight(){
        return getHeight(rootNode);
    }

    private int getHeight(Node<V> node){
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.getLeftChild()),
                    getHeight(node.getRightChild()));
        }
    }

    public Node<V> getRootNode() {
        return rootNode;
    }

    private int compareKeys(int k1, int k2) {
        return Integer.compare(k1, k2);
    }

    public Item<V> findItem(int key) {
        return findNode(rootNode, key).getItem();
    }

    private Node<V> findNode(Node<V> node, int key) {
        if (node == null) {
            throw new IllegalArgumentException("Item to find is not in tree.");
        } else if (compareKeys(node.getKey(), key) == 0) {  //Is switch statement preferable?
            return node;
        } else if (compareKeys(node.getKey(), key) > 0) {
            return findNode(node.getLeftChild(), key);
        } else {
            return findNode(node.getRightChild(), key);
        }
    }

    public void insertItem(Item<V> item) {
        if (item != null) {
            Node<V> itemNode = new Node<>(item);
            insertNode(rootNode, itemNode);
        } else throw new NullPointerException("Item to insert is null.");
    }

    private void insertNode(Node<V> parentNode, Node<V> itemNode) {
        if (isEmpty()){
            rootNode = itemNode;
        } else if (compareKeys(parentNode.getKey(), itemNode.getKey()) > 0){
            if (parentNode.getLeftChild() == null){
                itemNode.setParent(parentNode);
                parentNode.setLeftChild(itemNode);
            } else {
                insertNode(parentNode.getLeftChild(), itemNode);
            }
        } else {
            if (parentNode.getRightChild() == null){
                itemNode.setParent(parentNode);
                parentNode.setRightChild(itemNode);
            } else {
                insertNode(parentNode.getRightChild(), itemNode);
            }
        }
        size++;
    }

    public void deleteItem(int key) {
        Node<V> itemNode = findNode(rootNode, key);
        Node<V> replacement;
        if (itemNode.getLeftChild() == null && itemNode.getRightChild() == null){
            replacement = null;
        } else if (itemNode.getLeftChild() == null){
            replacement = itemNode.getRightChild();
        } else if (itemNode.getRightChild() == null){
            replacement = itemNode.getLeftChild();
        } else {
            replacement = itemNode.getRightChild();
            while (replacement.getLeftChild() != null){
                replacement = replacement.getLeftChild();
            }
        }

        if (itemNode != rootNode){
            if (itemNode == itemNode.getParent().getLeftChild()){
                itemNode.getParent().setLeftChild(replacement);
            } else {
                itemNode.getParent().setRightChild(replacement);
            }
        }
        if (replacement != null){
            replacement.setParent(itemNode.getParent());
        }
        size--;
    }

    public void populateBST(ArrayList<Item<V>> treeItems){
        for (int i = 0; i < treeItems.size(); i++) {
            insertItem(treeItems.get(i));
        }
    }

    public void balanceBST() {
        ArrayList<Item<V>> treeItems = new ArrayList<>();
        for (TreeIterator<V> iterator = iterator(); iterator.hasNext(); ){
            treeItems.add(iterator.next());
        }
        makeEmpty();
        rootNode = placeChildrenBalanced(treeItems);
    }

    /**
     * This method populates the tree recursively to produce a balanced tree. The
     * method takes a sublist (subtree) of the sorted list of items, inserts the
     * midpoint value, and then calls itself for the list of items left of the
     * midpoint (left subtree) and for the list of items right of the midpoint
     * (right subtree).
     *
     * Note: This will not work properly if there are repeating keys.
     */
    private Node<V> placeChildrenBalanced(List<Item<V>> subtreeItems){
        if (subtreeItems.size() != 0){
            int midpoint = subtreeItems.size() / 2;
            Node<V> node = new Node<>(subtreeItems.get(midpoint));
            node.setLeftChild(placeChildrenBalanced(subtreeItems.subList(0, midpoint)));
            if (subtreeItems.size() > 2){
                node.setRightChild(placeChildrenBalanced(
                        subtreeItems.subList(midpoint + 1, subtreeItems.size())
                ));
            }
            size++;
            return node;
        }
        return null;
    }

    @Override
    public TreeIterator<V> iterator() {
        return new TreeIterator<>(this);
    }

}