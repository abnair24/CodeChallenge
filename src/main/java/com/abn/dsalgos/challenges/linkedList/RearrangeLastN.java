package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;

import java.util.NoSuchElementException;

public class RearrangeLastN<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;

    public RearrangeLastN() {
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

    public LinkNode<T> getFirstNode() {
        LinkNode<T> temp = first;
        if (temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp;
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
    Given a singly linked list of integers l and a non-negative integer n,
    move the last n list nodes to the beginning of the linked list.

Example

For l = [1, 2, 3, 4, 5] and n = 3, the output should be
rearrangeLastN(l, n) = [3, 4, 5, 1, 2];
For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6].

     */

    public void reverseLastN(LinkNode<T> l, int k) {
        LinkNode<T> p1 = l;
        LinkNode<T> p2 = l;
        LinkNode<T> prev = null;
        LinkNode<T> tail = null;

        if (l == null) {
            return;
        }

//        if (k == 0) {
//            return l;
//        }


        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                break;
            } else {
                p1 = p1.next;
            }
        }

        while (p1 != null) {
            prev = p1;
            p1 = p1.next;
            tail = p2;
            p2 = p2.next;
        }
        /*
        When k == length of linked list, first for loop ends with p1 == null, causing p2 to be always at l;
         */
        if (p2 != l) {
            prev.next = first;
            first = p2;
            tail.next = null;
        }

        print();
    }

    public void print() {
        LinkNode n = first;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
