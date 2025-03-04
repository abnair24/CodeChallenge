package com.abn.scalar.dsa.day52;

import com.abn.dsalgos.utils.ListNode;

/*
Sort a linked list, A in O(n log n) time
 */
public class SortLL {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;

        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        return merge(left, right);

    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;


        while(l1!= null && l2 != null) {
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if(l1 != null) {
            current.next = l1;
        }

        if(l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        SortLL sortLL = new SortLL();

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(9);
        ListNode result = sortLL.sortList(head);

        while(result !=null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
