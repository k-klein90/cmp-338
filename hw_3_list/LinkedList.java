package hw_3_list;

import common_classes.LinkedListNode;

public class LinkedList<T extends Comparable<T>> extends List<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    public LinkedList() {
        head = new LinkedListNode<T>(null, null, null);
        tail = new LinkedListNode<T>(null, head, null);
        head.setNext(tail);
    }

    @Override
    public T get(int index) {
        T element = null;
        if ((index >= 0) && (index < size)){
            LinkedListNode<T> currentNode = head.getNext();
            for (int i = 0; i < index; i++){
                currentNode = currentNode.getNext();
            }
            element = currentNode.getData();
        }
        return element;
    }

    @Override
    public void add(T element) {
        addAtNode(element, tail);
    }

    private void addAtNode(T element, LinkedListNode<T> node){
        LinkedListNode<T> elementNode = new LinkedListNode<>(element, node.getPrev(), node);
        node.getPrev().setNext(elementNode);
        node.setPrev(elementNode);
        size++;
    }

    @Override
    public boolean add(T element, int index) {
        boolean ifAdded = false;
        if ((index >= 0) && (index <= size)){
            if (index < size){
                LinkedListNode<T> currentNode = head.getNext();
                for (int i = 0; i < index; i++){
                    currentNode = currentNode.getNext();
                }
                addAtNode(element, currentNode);
            } else {
                add(element);
            }
            ifAdded = true;
        }
        return ifAdded;
    }

    @Override
    public void addSorted(T element) {
        if ((size == 0) || (element.compareTo(tail.getPrev().getData()) >= 0)){
            add(element);
        } else {
            LinkedListNode<T> currentNode = head.getNext();
            while (element.compareTo(currentNode.getData()) >= 0){
                currentNode = currentNode.getNext();
            }
            addAtNode(element, currentNode);
        }
    }

    @Override
    public T replace(T element, int index) {
        T replacedData = null;
        if ((index >= 0) && (index < size)) {
            LinkedListNode<T> currentNode = head.getNext();
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            replacedData = currentNode.getData();
            currentNode.setData(element);
        }
        return replacedData;
    }

    @Override
    public boolean remove(int index) {
        boolean ifRemoved = false;
        if ((index >= 0) && (index < size)){
            LinkedListNode<T> currentNode = head.getNext();
            for (int i = 0; i < index; i++){
                currentNode = currentNode.getNext();
            }
            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode.getNext().setPrev(currentNode.getPrev());
            currentNode.setPrev(null);
            currentNode.setNext(null);
            size--;
            ifRemoved = true;
        }
        return ifRemoved;
    }

    @Override
    public void removeAll() {
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

}