package com.abn.dsalgos.algo.twoPointers;

import com.abn.dsalgos.utils.ListNode;

public class RotateSingleLinkedListKTimes {

    public ListNode rotate(ListNode head, int k) {

        int len = 0;
        ListNode fPtr = head;
        ListNode sPtr = head;

        len = getLength(head);

        if(k == 0 || len == 0) {
            return head;
        }

        k = k%len;

        if(k == 0) {
            return head;
        }

        for(int i=0; i < k; i++) {
            fPtr = fPtr.next;
        }

        while(fPtr.next != null) {
            sPtr = sPtr.next;
            fPtr = fPtr.next;
        }

        ListNode newHead = sPtr.next;
        fPtr.next = head;
        sPtr.next = null;

        print(newHead);

        return newHead;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode current = head;

        while(current != null) {
            len ++;
            current = current.next;
        }
        return len;
    }

    private void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
