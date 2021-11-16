package November162021;

public class SinglyLinkedList<T> {

    private SinglyLinkedNode<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public SinglyLinkedList(SinglyLinkedNode<T> head) {
        this.head = head;
        this.size = 1;
    }

    //If the head of the list is null, then the list is empty
    public boolean isEmpty() {
        return this.head == null;
    }

    //Get the current size of the list
    public int getSize() {
        return this.size;
    }

    //Returns the first node of the list which is the head
    public SinglyLinkedNode<T> getFirst() {
        return this.head;
    }

    //Add a new node to the end of the list
    public void add(T data) {
        //Create a new node with given node
        SinglyLinkedNode<T> node = new SinglyLinkedNode<>(data);
        //If the list is already empty then update the head to the new node
        if(isEmpty()) {
            this.head = node;
        } else {
            //Loop through the list till you reach the last node
            SinglyLinkedNode<T> current = this.head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            //Set the next node of the last node in the list to the new node
            current.setNext(node);
        }
        //increase the size
        size++;
    }

    //Add a new Node to the front of the list
    public void addFirst(T data) {
        //Create a new node with the data given
        SinglyLinkedNode<T> node = new SinglyLinkedNode<>(data);
        //Set the next node of the new node to the current head
        node.setNext(this.head);
        //Set the head of the list to the new node created
        this.head = node;
        //Increase the size counter
        size++;
    }

    //Remove a node from the front of the list
    public SinglyLinkedNode<T> removeFirst() {
        //If the list is empty then there's no node to remove
        if(isEmpty()) {
            return null;
        }
        //Get the first node in the list which is the head
        SinglyLinkedNode<T> removed = this.head;
        //Set the head of the list to the current head's next node
        this.head = this.head.getNext();
        //Removed the next property of the removed node, so it's not pointing to the list
        removed.setNext(null);
        //Decrease the size of the list
        size--;
        //Return the removed node
        return removed;
    }

    //Search the list to see if a given data is within the list
    public boolean contains(T data) {
        //If the list is already empty then no need to search, so return false
        if(isEmpty()) {
            return false;
        }

        //Loop through the list and check every value
        SinglyLinkedNode<T> current = this.head;
        while(current != null) {
            //Get the current data
            T currentData = current.getData();
            //If the current data is equal to the given data then it's found so return true
            if(currentData == data) return true;
            current = current.getNext();
        }
        //Looped through the list and didn't find data so return false
        return false;
    }

    //Return a Node given an index
    public SinglyLinkedNode<T> get(int index) {
        //Use a counter to keep track of the current Node's index
        int counter = 0;
        //Loop through the list till the index is found
        SinglyLinkedNode<T> current = this.head;
        while(current != null) {
            //If the current Node's index is equal to the given index break out of the loop
            if(counter == index) break;
            //Increase the counter to update to the next index
            counter++;
            current = current.getNext();
        }
        //Return the Node at the index
        return current;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    //Pretty print method for the list
    public void printList() {
        SinglyLinkedNode<T> current = this.head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current.toString() + " -> ");
            current = current.getNext();
        }
        System.out.print("NULL");
    }
}
