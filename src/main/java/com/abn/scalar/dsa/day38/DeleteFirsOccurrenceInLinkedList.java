package com.abn.scalar.dsa.day38;

/*
Delete the first occurrence of value X in linkedList

1 -> 2 -> 3 -> 4
3

1 -> 2 -> 4
 */
public class DeleteFirsOccurrenceInLinkedList {

    public ListNode solve(ListNode A, int B) {

        if(A == null) {
            return A;
        }

        if(A.val == B) {
            A = A.next;
            return A;
        }

        ListNode current = A;
        ListNode previous;
        while(current.next != null) {
            previous = current;
            if(current.next.val == B) {
                previous.next = current.next.next;
                return A;
            }
            current = current.next;
        }
        return A;
    }
}
