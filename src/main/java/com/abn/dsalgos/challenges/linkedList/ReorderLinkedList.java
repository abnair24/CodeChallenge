package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;

/*
Given a singly linked list
    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:
    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

You must do this in-place without altering the nodes’ values.
 */
public class ReorderLinkedList<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;
    private int size;



    public LinkNode<T> reorderLinkedList(LinkNode<T> node) {

        LinkNode<T> current = node;
        LinkNode<T> head1 = node;
        LinkNode<T> head2 = null;
        LinkNode<T> fNode = node;
        LinkNode<T> sNode = node;

        if(node == null) {
            return null;
        }

        while(fNode != null && fNode.next != null) {

            sNode = sNode.next;
            fNode = fNode.next.next;
        }

        LinkNode<T> tail = sNode;

        /*
        Reverse the second half of the original list and return the head of that half.
         */
        head2 = reverseLinkedList(sNode.next);

        tail.next = null;

        /*
        Traverse both the half simultaneously and merge alternatively
         */
        while(head2 != null) {
            LinkNode<T> temp1 = head1.next;
            LinkNode<T> temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;

        }

        return current;
    }


    private LinkNode<T> reverseLinkedList(LinkNode<T> headNode) {
        LinkNode<T> currentNode = headNode;
        LinkNode<T> prevNode = null;
        LinkNode<T> nextNode = null;

        while (currentNode != null) {
            // Getting the next node and storing
            nextNode = currentNode.next;
            // linking current node to null (for first case and late to prev nods)
            currentNode.next = prevNode;
            //iterating
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public ReorderLinkedList() {
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

    public void print(LinkNode<T> firstNode) {
        LinkNode<T> n = firstNode;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
