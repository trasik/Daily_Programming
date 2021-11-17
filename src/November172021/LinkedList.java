package November172021;

import java.util.NoSuchElementException;

public class LinkedList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean contains(T data) {
        if(isEmpty()) {
            return false;
        }

        Node<T> current = this.head;
        while(current != null) {
            T currentData = current.getData();
            if(currentData == data) return true;
            current = current.getNext();
        }
        return false;
    }

    private void addTailLink(T data) {
        //Create a new node with the given data with the tail as it's prev node and the next node to null
        Node<T> node = new Node<>(data, this.tail, null);
        //If the tail of the list is null, then it's the first node to be added
        if(this.tail == null) {
            //Set the head to the new node
            this.head = node;
        } else {
            //Set the current tail's next node to the new node
            this.tail.setNext(node);
        }
        //Update the tail to the new node
        this.tail = node;
        //Update the size
        size++;
    }

    private void addTailLinkBefore(int index, T data) {
        Node<T> nodeAtIndex = this.head;
        for(int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.getNext();
        }
        Node<T> nodeAtIndexPrev = nodeAtIndex.getPrev();
        Node<T> newNode = new Node<>(data, nodeAtIndexPrev, nodeAtIndex);
        if(nodeAtIndexPrev == null) {
            this.head = newNode;
        } else {
            nodeAtIndexPrev.setNext(newNode);
        }
        nodeAtIndex.setPrev(newNode);
        size++;
    }

    private T removeHeadLink() {
        //Store the current heads data
        T removedData = this.head.getData();
        //Get the heads next node
        Node<T> headNext = this.head.getNext();
        //If the next node is null then set the tail to null
        if(headNext == null) {
            this.tail = null;
        } else {
            //More than 1 node in the list so set the next nodes previous value to null
            headNext.setPrev(null);
        }
        //Help GC by setting current head properties to null
        this.head.setNext(null);
        this.head.setData(null);
        this.head = headNext;
        //Decrease the size of the list
        size--;
        return removedData;
    }

    public void add(T data) {
        addTailLink(data);
    }

    public void add(int index, T data) {
        if(index <  0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            addLast(data);
        } else {
            addTailLinkBefore(index, data);
        }
    }

    public void addLast(T data) {
        addTailLink(data);
    }

    public void addFirst(T data) {
        //Create a new node with the given data with the head as it's next node and the prev node to null
        Node<T> node = new Node<>(data, null, this.head);
        //If the head of the list is null, then it's the first node to be added
        if(this.head == null) {
            //Set the tail of the list to the new node
            this.tail = node;
        } else {
            //Set the current heads previous node to the new node
            this.head.setPrev(node);
        }
        //Update the head of the list to the new node
        this.head = node;
        //Update the size of the list
        size++;
    }

    public T remove() {
        if(this.head == null) throw new NoSuchElementException();
        return removeHeadLink();
    }

    public T remove(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        //Get the node to be removed based on the index
        Node<T> nodeToRemove = this.head;
        for(int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.getNext();
        }

        //Get the Previous, Next and Data properties of the node to be removed
        T nodeToRemoveData = nodeToRemove.getData();
        Node<T> nodeToRemovePrev = nodeToRemove.getPrev();
        Node<T> nodeToRemoveNext = nodeToRemove.getNext();

        //If the previous node is null then it's the head
        if(nodeToRemovePrev == null) {
            //Set the head of the list to the next Node of the node to be removed
            this.head = nodeToRemoveNext;
        } else {
            //Set the next node of the previous node  to the node after the removed node
            nodeToRemovePrev.setNext(nodeToRemoveNext);
            //Set the previous value of the removed node to null GC
            nodeToRemove.setPrev(null);
        }

        //If the next node is null then it's the tail
        if(nodeToRemoveNext == null) {
            //Set the tail of the list to the previous Node of the node to be removed
            this.tail = nodeToRemovePrev;
        } else {
            //Set the previous value of the Node next to the one removed to the previous node
            nodeToRemoveNext.setPrev(nodeToRemovePrev);
            //Set the next value of the removed node to null GC
            nodeToRemove.setNext(null);
        }

        //Remove the data inside the node for GC
        nodeToRemove.setData(null);
        //Decrease the size
        size--;

        return nodeToRemoveData;
    }

    public T removeFirst() {
        if(this.head == null) throw new NoSuchElementException();
        return removeHeadLink();
    }

    public T get(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = this.head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T getFirst() {
        if(this.head == null) throw new NoSuchElementException();
        return this.head.getData();
    }

    public T getLast() {
        if(this.tail == null) throw new NoSuchElementException();
        return this.tail.getData();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = this.head;
        while(current != null) {
            sb.append(current.toString());
            current = current.getNext();
        }
        return sb.toString();
    }
}
