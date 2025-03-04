package com.abn.scalar.dsa.day53;

import com.abn.dsalgos.utils.ListNode;

/*
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.

Input 1:

 A = [1, 2, 3, 4, 5]
 Output 1:

 [1, 5, 2, 4, 3]

 Input 2:

 A = [1, 2, 3, 4]
 Output 2:

 [1, 4, 2, 3]

 */
public class ReorderLL {

    public ListNode reorder(ListNode node) {

        if(node == null || node.next == null || node.next.next == null) {
            return node;
        }

        ListNode mid = middle(node);

        ListNode head2 = reverseLL(mid.next);

        mid.next = null;

        ListNode head = join(node, head2);

        return head;
    }

    private ListNode middle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLL(ListNode node) {

        ListNode current = node;
        ListNode next = null;
        ListNode prev = null;

        while(current != null) {

            // 1 -> 2 -> 3

            next = current.next; // next = 2
            current.next = prev; // 1.next = null
            prev = current; // prev = 1
            current = next; // current = 2
        }

        return prev;
    }

    private ListNode join(ListNode A, ListNode B) {

        ListNode p1 = A;
        ListNode p2 = B;

        while(p1 != null) {
            ListNode p3 = p1.next;
            p1.next = p2;

            if(p2 != null) {
                ListNode p4 = p2.next;
                p2.next = p3;
                p2 = p4;
            }

            p1 = p3;

        }
        return A;
    }
}
