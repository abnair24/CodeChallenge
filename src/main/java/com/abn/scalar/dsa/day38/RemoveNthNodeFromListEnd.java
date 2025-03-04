package com.abn.scalar.dsa.day38;

/*
Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, given linked list: 1->2->3->4->5, and B = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

if B is greater than the size of the list, remove the first node of the list.

Try doing it using constant additional space.

Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1

Output 1:
1->2->3->5
Output 2:
null
 */
public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode current = A;
        int len = 0;

        while(current != null) {
            len++;
            current = current.next;
        }

        if(len == 0) {
            return A;
        }

        current = A;

        if(B > len || B == len) {
            current = A.next;
            A.next = null;
            return current;
        }

        int index = 0;

        ListNode previous = null;
        while(current != null) {
            if(index == (len - B)) {
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
            index++;
        }
        return A;
    }
}
