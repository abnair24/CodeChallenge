package com.abn.scalar.dsa.day38;

/*
You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.

Note : Follow 0-based indexing for the node numbering.
A = 1 -> 2 -> 3
B = 1

1 -> 3

A = 4 -> 3 -> 2 -> 1
B = 0

3 -> 2 -> 1

 */
public class DeleteBthNodeLinkedList {

    public ListNode solve(ListNode A, int B) {

        if(A == null) {
            return A;
        }

        if(B == 0) {
            A = A.next;
            return A;
        }

        ListNode current = A;
        ListNode previous = A;
        int index = 0;

        while(current.next != null) {
            previous = current;
            if(index == B-1) {
                previous.next = current.next.next;
                return A;
            }
            current = current.next;
            index ++;
        }

        return A;

        //9, 18, 17, 17, 6, 16, 13, 11, 15, 7
    }
}
