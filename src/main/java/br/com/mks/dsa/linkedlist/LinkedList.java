package br.com.mks.dsa.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.length++;
    }

    public LinkedList() {
    }

    public void append(int value) {
        var node = new Node(value);
        if (this.length == 0) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }

        this.tail = node;
        this.length++;
    }

    public Integer removeLast() {
        if (this.length == 0) return null;

        Node temp = this.head;
        Node pre = this.head;

        while (temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }

        this.tail = pre;
        this.tail.setNext(null);
        this.length--;

        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        return temp.getValue();
    }

    public void prepend(int value) {
        var node = new Node(value);
        if (this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.length++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return this.length;
    }
}
