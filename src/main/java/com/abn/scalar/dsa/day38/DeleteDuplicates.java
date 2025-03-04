package com.abn.scalar.dsa.day38;

public class DeleteDuplicates {

    public ListNode solve(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }

            if(current.next == null) {
                return head;
            }

            if(current.val != current.next.val) {
                current = current.next;
            }
        }
        return head;

        // 1 -> 1-> 1-> 1-> 2-> 3-> 3-> 3-> 4


    }
}
