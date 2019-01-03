package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.Node;

import java.util.NoSuchElementException;

public class MergeSortedLinkedList {

    private Node first;
    private Node last;
    private int size;

    public MergeSortedLinkedList() {
        first =null;
        last = null;
        size=0;
    }

    public void insertFirst(int value) {
        Node newLink = new Node(value);
        if(isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
        }
        first = newLink;
        size++;
    }

    public void insertLast(int value) {
        Node  newLink = new Node(value);
        if(isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
        size ++;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int deleteFirst() throws Exception {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            Node temp = first;
            first = first.next;
            size--;
            return temp.data;
        }
    }

    public int find(int value) {
        Node current = first;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            while (current.data != value) {
                if (current.next == null) {
                    throw new IndexOutOfBoundsException();
                } else {
                    current = current.next;
                }
            }
        }
        return current.data;
    }

    public int delete(int value) {

        Node current = first;
        Node prev = first;
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            while (current.data != value) {
                if (current.next == null) {
                    throw new IndexOutOfBoundsException();
                } else {
                    prev = current;
                    current = current.next;
                }
            }
            if (current == first) {
                first = first.next;
            } else {
                prev.next = current.next;
            }
        }
        return current.data;
    }

    public int getFirst() {
        Node temp = first;
        if(temp == null){
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    public int getLast() {
        Node temp = last;
        if(temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    /*
    Helper methode to fetch first node from linkedlist . Used for removeDuplicates method to get handle of first method
     */

    public Node getFirstNode() {
        Node temp = first;
        if(temp == null ){
            throw new NoSuchElementException();
        } else {
            return temp;
        }
    }

    public void print() {
        Node n = first;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public int size() {
        return size;
    }


    public void mergeSortedList(Node node1, Node node2) {
        Node dummy = new Node(0);

        Node tail = dummy;

        while(true) {
            if(node1 == null) {
                tail.next = node2;
                break;
            }

            if(node2 == null) {
                tail.next = node1;
                break;
            }

            if(node1.data <= node2.data) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }

            tail = tail.next;
        }

        first = dummy.next;
        print();
    }
}
