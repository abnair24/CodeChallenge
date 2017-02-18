package com.abn.dsalgos.ds;

import com.abn.dsalgos.exceptions.EmptyLinkedListException;
import com.abn.dsalgos.utils.DoubleLinkNode;
import java.util.NoSuchElementException;

/**
 * Created by aswathyn on 17/02/17.
 */
public class MyDoublyLinkedList<T> {

    private DoubleLinkNode<T> first;
    private DoubleLinkNode<T> last;
    private int size;

    public MyDoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T value) {
        DoubleLinkNode<T> newLink = new DoubleLinkNode<>(value);
        if(isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
        size++;
    }

    public void insertLast(T value){
        DoubleLinkNode<T> newLink = new DoubleLinkNode<>(value);
        if(isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;

        size++;
    }

    public void insertAfter(T value,T data) {
        DoubleLinkNode<T> current = first;
        DoubleLinkNode<T> newLink = new DoubleLinkNode<>(data);
        while(current.data != value) {
            current = current.next;
            if(current == null) {
                throw new NoSuchElementException();
            }
        }

        if(current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;

        size++;

    }

    public T deleteFirst() throws Exception{
        if(isEmpty()) {
            throw new EmptyLinkedListException();
        } else {
            DoubleLinkNode<T> temp = first;
            if(first.next == null) {
                last = null;
            } else {
                first.next.previous = null;
            }
            first = first.next;
            size--;
            return temp.data;
        }
    }

    public T deleteLast() throws Exception {
        if(isEmpty()) {
            throw new EmptyLinkedListException();
        } else {
            DoubleLinkNode<T> temp = last;
            if(first.next == null) {
                first = null;
            } else {
                last.previous.next = null;
            }
            last = last.previous;
            size--;
            return temp.data;
        }
    }

    public T delete(T value) {
        DoubleLinkNode<T> current = first;

        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            while (current.data != value) {
                current = current.next;
                if (current.next == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            if (current == first) {
                first = current.next;
            } else {
                current.previous.next = current.next;
            }
            if(current == last) {
                last = current.previous;
            } else {
                current.next.previous = current.previous;
            }
        }
        size--;
        return current.data;
    }

    public int size() {
        return size;
    }

    public T peek() {
        DoubleLinkNode<T> temp = first;
        if(temp == null){
            throw new NoSuchElementException();
        } else {
            return first.data;
        }
    }
}