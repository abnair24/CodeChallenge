package com.abn.scalar.dsa.day38;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode A) {

        ListNode current = A;
        ListNode previous = null;
        ListNode nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}



