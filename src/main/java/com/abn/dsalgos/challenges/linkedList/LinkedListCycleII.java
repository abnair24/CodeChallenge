package com.abn.dsalgos.challenges.linkedList;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode cycleMeet = null;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycleMeet = slow;
                break;
            }
        }

        if(cycleMeet == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = cycleMeet;

        while(ptr1 != ptr2) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        node1.next.next.next.next = node1.next;

        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
        linkedListCycleII.detectCycle(node1);
    }
}
