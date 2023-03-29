package dataStructureAlgorithms.collection.LinkedList;

//https://crunchify.com/how-to-implement-a-linkedlist-class-from-scratch-in-java/

import java.util.Objects;

public class LinkedNode {
    LinkedNode next;
    Object data;

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedNode)) return false;
        LinkedNode that = (LinkedNode) o;
        return Objects.equals(getNext(), that.getNext()) && getData().equals(that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNext(), getData());
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                " data=" + data +
                //" :: next=" + next +
                '}';
    }
}
