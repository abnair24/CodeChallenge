package com.abn.scalar.dsa.day52;

import com.abn.dsalgos.utils.ListNode;

/*
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
 */
public class MiddleOfLL {

    public int solve(ListNode A) {

        if (A == null) {
            return -1;
        }

        ListNode sptr = A;
        ListNode fptr = A;

        while (fptr.next != null && fptr.next.next != null) {
            sptr = sptr.next;
            fptr = fptr.next.next;
        }

        return fptr.next != null ? sptr.next.val : sptr.val;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);

        MiddleOfLL middleOfLL = new MiddleOfLL();
        System.out.println(middleOfLL.solve(head));

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println(middleOfLL.solve(head1));

    }
}
