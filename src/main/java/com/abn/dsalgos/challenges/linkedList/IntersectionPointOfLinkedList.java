package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import sun.awt.image.ImageWatched;

import java.util.NoSuchElementException;

public class IntersectionPointOfLinkedList<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;
    private int size;

    public IntersectionPointOfLinkedList() {
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


    public LinkNode<T> findIntersection(LinkNode<T> nodeA, LinkNode<T> nodeB) {

        int lenA =0;
        int lenB =0;

        LinkNode<T> tempA = nodeA;
        LinkNode<T> tempB = nodeB;

        if(tempA == null || tempB == null) {
            return null;
        }

        while(tempA != null) {
            tempA = tempA.next;
            lenA++;
        }

        while(tempB != null) {
            tempB = tempB.next;
            lenB ++;
        }

        tempA = nodeA;
        tempB = nodeB;

        int diff = lenA - lenB;

        if(diff > 0) {
            while( diff!=0) {
                tempA = tempA.next;
                diff --;
            }

        }else {
            diff = Math.abs(diff);
            while(diff !=0) {
                tempB = tempB.next;
                diff --;
            }
        }

        while(tempA != null && tempB != null) {
            /*
            Checking the memory reference is same;
             */
            if(tempA == tempB) {
                return tempA;
            } else {
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return null;
    }


    /*
    Efficient solution: Traverse A and B, if tailA is reached, point to headB, and on reaching tailB point to headA
    Now when both equals, return
     */

    public LinkNode<T> findIntersection2(LinkNode<T> nodeA, LinkNode<T> nodeB) {

        if(nodeA== null || nodeB == null) {
            return null;
        }

        LinkNode<T> headA = nodeA;
        LinkNode<T> headB = nodeB;

        while(headA != headB) {
            headA = headA == null ? headB: headA.next;
            headB = headB == null ? headA: headB.next;
        }

        return headA;
    }
}
