package com.abn.dsalgos.algo.twoPointers;

import com.abn.dsalgos.utils.ListNode;

public class SingleLinkedListPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode sNode = head;
        ListNode fNode = head;

        while (fNode != null && fNode.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
        }

        ListNode headNodeRevSecondHalf = reverse(sNode);
        ListNode tempHead = headNodeRevSecondHalf;

        while (head != null && headNodeRevSecondHalf != null) {
            if (head.val != headNodeRevSecondHalf.val) {
                break;
            }
            head = head.next;
            headNodeRevSecondHalf = headNodeRevSecondHalf.next;
        }

        reverse(tempHead);
        if (head == null || headNodeRevSecondHalf == null) {
            return true;
        }
        return false;
    }

    private ListNode reverse(ListNode head) {

        ListNode current = head;
        ListNode next;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
