package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;

import java.util.NoSuchElementException;

public class KthFromLastLinkedList<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;

    public KthFromLastLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(T value) {
        LinkNode<T> newLink = new LinkNode<>(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
        }
        first = newLink;
    }

    public void insertLast(T value) {
        LinkNode<T> newLink = new LinkNode<>(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T deleteFirst()
            throws Exception {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            LinkNode<T> temp = first;
            first = first.next;
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
        if (isEmpty()) {
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
        if (temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    public T getLast() {
        LinkNode<T> temp = last;
        if (temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    /*
    O(n) time and O(1) space.
     */
    public T findKthFromLast(int k) {
        LinkNode<T> p1 = first;
        LinkNode<T> p2 = first;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            } else {
                p1 = p1.next;
            }
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }
}
