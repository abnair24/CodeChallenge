package com.abn.dsalgos.ds.queue;

import com.abn.dsalgos.exceptions.EmptyQException;
import com.abn.dsalgos.utils.LinkNode;

import java.util.NoSuchElementException;


/**
 * Created by aswathyn on 15/02/17.
 */
public class QLinkList<T> {

    private LinkNode<T> front;
    private LinkNode<T> rear;
    private int size;

    public QLinkList() {
        front = null;
        rear = null;
        size = 0;
    }

    public void insertLast(T value) {
        LinkNode<T> newLink = new LinkNode<>(value);
        if (isEmpty()) {
            front = newLink;
        } else {
            rear.next = newLink;
        }
        rear = newLink;
        size++;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T deleteFirst()
            throws Exception {
        if (isEmpty()) {
            throw new EmptyQException();
        } else {
            LinkNode<T> temp = front;
            while (front.next == null) {
                rear = null;
            }
            front = front.next;
            size--;
            return temp.data;
        }
    }

    public int size() {
        return size;
    }


    public T peek()
            throws Exception {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return front.data;
        }
    }

}
