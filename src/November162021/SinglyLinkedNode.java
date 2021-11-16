package November162021;

public class SinglyLinkedNode<T> {

    private T data;
    private SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T data) {
        this.data = data;
        this.next = null;
    }

    public SinglyLinkedNode(T data, SinglyLinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SinglyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
