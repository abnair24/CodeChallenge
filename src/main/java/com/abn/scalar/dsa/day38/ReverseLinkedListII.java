package com.abn.scalar.dsa.day38;

/*
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.

Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Output 1:

1 -> 4 -> 3 -> 2 -> 5


Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5
 Example Output

Output 2:

 5 -> 4 -> 3 -> 2 -> 1
 */

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || A.next == null || B == C) {
            return A;
        }
        ListNode head = new ListNode(-1);

        head.next = A;
        ListNode previous = head;

        for (int i = 1; i < B; i++) {
            previous = previous.next;
        }
        ListNode current = previous.next;
        for (int i = 1; i <= C - B; i++) {
            ListNode temp = previous.next;
            previous.next.next = temp;
            previous.next = current.next;
            current.next = current.next.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);
        one.next.next.next.next.next = new ListNode(6);
        one.next.next.next.next.next.next = new ListNode(7);

        reverseLinkedListII.reverseBetween(one, 3, 6);
    }
}
