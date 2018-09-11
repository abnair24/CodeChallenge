package com.abn.dsalgos.challenges;

import com.abn.dsalgos.ds.MyLinkedList;
import com.abn.dsalgos.utils.LinkNode;

import java.util.NoSuchElementException;

import static java.lang.Math.pow;

public class LinkedListSum<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;
    private int size;

    public LinkedListSum() {
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

    public LinkNode getFirstNode() {
        LinkNode<T> temp = first;
        if(temp == null ){
            throw new NoSuchElementException();
        } else {
            return temp;
        }
    }


    public LinkNode getLastNode() {
        LinkNode<T> temp = last;
        if(temp == null ){
            throw new NoSuchElementException();
        } else {
            return temp;
        }
    }

    public int getNumber() {
        LinkNode temp = getFirstNode();
        int result =0;

        for(int i =0; i <size; i++) {
            result = result + ((int) pow(10,i)  * ((int)(temp.data) % 10));
            temp = temp.next;
        }
        return result;
    }

}
