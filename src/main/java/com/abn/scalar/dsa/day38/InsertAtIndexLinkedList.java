package com.abn.scalar.dsa.day38;

/*
You are given A which is the head of a linked list. Also given is the value B and position C.
Complete the function that should insert a new node with the said value at the given position.

Notes:

In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.

0 <= size of linked list <= 105

1 <= value of nodes <= 109

1 <= B <= 109

0 <= C <= 105
 */
public class InsertAtIndexLinkedList {

    public ListNode solve(ListNode A, int B, int C) {

        ListNode newNode = new ListNode(B);
        ListNode current = A;
        int len = 0;
        ListNode previous = null;

        if(A == null) {
            return newNode;
        }

        if(C == 0) {
            newNode.next = current;
            return newNode;
        }

        while(current != null) {
            len ++;
            previous = current;
            current = current.next;
        }

        if(C >= len) {
            previous.next = newNode;
            newNode.next = null;
            return A;
        }

        int index = 0;
        current = A;
        while(index != C -1) {
            current = current.next;
            index++;
        }

        newNode.next = current.next;
        current.next = newNode;

        return A;
    }
}

