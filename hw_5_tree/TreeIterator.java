package hw_5_tree;

import java.util.*;

public class TreeIterator<V> implements Iterator<Item<V>> {

    /**
     * The stack contains only ancestors greater than the current node, the
     * current node's right child, and the leftmost descendants of the current
     * node's right child. The current node is not on the stack; it was popped
     * off in the previous iteration.
     */
    private Stack<Node<V>> stack;

    /**
     * If the root node is not null (i.e. the tree is not empty), then the root
     * is pushed onto the stack, and then the leftmost descendents of the root,
     * until the node of the smallest item in the tree is pushed onto the stack.
     */
    public TreeIterator(Tree<V> tree) {
        stack = new Stack<>();
        Node<V> node = tree.getRootNode();
        if (node != null) {
            do {
                stack.push(node);
                node = node.getLeftChild();
            } while (node != null);
        }
    }

    @Override
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /**
     * The next item is the item held by the top node on the stack. After popping
     * the node off the stack, the node's right child (if not null) is pushed onto
     * the stack, followed by the right child's leftmost descendents. This ensures
     * that, by the time the method completes, the node at the top of the stack
     * holds the next largest item.
     */
    @Override
    public Item<V> next(){
        if (hasNext()){
            Node<V> nodeToReturn = stack.pop();
            if (nodeToReturn.getRightChild() != null){
                Node<V> nodeToPush = nodeToReturn.getRightChild();
                do {
                    stack.push(nodeToPush);
                    nodeToPush = nodeToPush.getLeftChild();
                } while (nodeToPush != null);
            }
            return nodeToReturn.getItem();
        }
        return null;
    }

}