package com.abn.dsalgos.ds.linkedList;

import com.abn.dsalgos.utils.LinkNode;

public class MyCircularLinkedList<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;
    private int size ;

    public MyCircularLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T value) {

        LinkNode<T> newLink = new LinkNode<>(value);

        if(isEmpty()) {
            first = newLink;
            last = newLink;
            newLink.next = first;
        } else {
            LinkNode<T> temp = first;
            first = newLink;
            newLink.next = temp;
            last.next = first;
        }
        size++;
    }


    public void insertLast(T value) {
        LinkNode<T> newLink  = new LinkNode<>(value);
        if(isEmpty()) {
            insertFirst(value);
        } else {
            LinkNode<T> temp = last;
            last = newLink;
            temp.next = newLink;
            last.next = first;
        }
        size++;
    }

    public void deleteFirst() {
        if(isEmpty()) {
            System.out.println("Empty list");
        } else {
            first = first.next;
            last.next = first;
            size--;
        }
    }

    public T elementAt(int index) {
        LinkNode<T> temp = first;
        while(index - 1 !=0) {
            temp = temp.next;
            index --;
        }
        return temp.data;
    }

    public void print(){
        LinkNode<T> temp = first;

        do {
            System.out.println(temp.data + " ");
            temp = temp.next;
        } while(temp!=first);
    }
}
