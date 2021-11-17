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

    public T removeFirst() {
        if(this.head == null) throw new NoSuchElementException();
        return removeHeadLink();
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
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
