package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import sun.awt.image.ImageWatched;

import java.util.NoSuchElementException;

public class LinkedListPartitionAroundX<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;
    private int size;

    public LinkedListPartitionAroundX() {
        first =null;
        last = null;
        size=0;
    }

    public void insertFirst(T value) {
        LinkNode<T> newLink = new LinkNode<>(value);
        if(isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
        }
        first = newLink;
        size++;
    }

    public void insertLast(T value) {
        LinkNode <T> newLink = new LinkNode<>(value);
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

    public T deleteFirst() throws Exception {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            LinkNode<T> temp = first;
            first = first.next;
            size--;
            return temp.data;
        }
    }

    public T find(T value) {
        LinkNode<T> current = first;
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

    public T delete(T value) {

        LinkNode<T> current = first;
        LinkNode<T> prev = first;
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

    public T getFirst() {
        LinkNode<T> temp = first;
        if(temp == null){
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    public T getLast() {
        LinkNode<T> temp = last;
        if(temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    /*
    Logic : Create two seperate pointers: one for adding lower values and other for higher values:
    Merge after looping through all.
     */
    public void partition(LinkNode node, int k) {
        LinkNode head = null;
        LinkNode tail =null;
        LinkNode headPtr =null;
        LinkNode tailPtr = null;

        while(node!=null) {
            LinkNode current = node;
            if ((int) node.data < k) {
                if (headPtr == null) {
                    head = current;
                    headPtr = head;
                } else {
                    headPtr.next = current;
                    headPtr = current;
                }
            } else {
                if (tailPtr == null) {
                    tail = current;
                    tailPtr = tail;
                } else {
                    tail.next = current;
                    tail = current;
                }
            }

            node = node.next;
        }

        /*
        In case when values are all higher than partition, so headptr will be always null.
         */
        if(headPtr==null) {
            head = tailPtr;
        } else {
            headPtr.next = tailPtr;
        }

        LinkNode n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public void print() {
        LinkNode n = first;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public LinkNode getFirstNode() {
        LinkNode<T> temp = first;
        if(temp == null ){
            throw new NoSuchElementException();
        } else {
            return temp;
        }
    }
}
