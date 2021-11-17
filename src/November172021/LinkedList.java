package November172021;

import java.util.Iterator;

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

    public void add(T data) {
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

    public Node<T> get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = this.head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
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
