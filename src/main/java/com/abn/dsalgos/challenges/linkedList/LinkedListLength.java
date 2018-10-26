package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;


/*
Find the length of a linkedlist
 */

public class LinkedListLength<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;

    public LinkedListLength() {
        first = null;
        last = null;
    }

    public void insertFirst(T value) {

        LinkNode<T> node = new LinkNode<>(value);
        if(isEmpty()) {
            last = node;
        } else {
            node.next = first;
        }
        first = node;
    }

    public void insertLast(T value) {
        LinkNode<T>node = new LinkNode<>(value);
        if(isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int length() {
        int count =0 ;

        LinkNode temp = first;
        if(temp == null) {
            return 0;
        }

        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
