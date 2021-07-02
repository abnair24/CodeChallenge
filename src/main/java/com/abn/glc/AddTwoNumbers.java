package com.abn.glc;

import com.abn.dsalgos.utils.ListNode;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input l1: [4,3,9] , l2 = [8,3,9]
output : [2,7,8,1]
Explanation : 934 + 938 = 1872
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {


        ListNode sumNode = null;
        ListNode sumHead = null;

        int sum = 0;
        int carry = 0;
        int count = 0;

        while(head1 != null || head2 != null) {
            count ++;
            sum = carry;
            if(head1 != null) {
                sum = sum + head1.val;
                head1 = head1.next;
            }
            if(head2 != null) {
                sum = sum + head2.val;
                head2 = head2.next;
            }

            carry = sum /10;
            sum = sum %10;

            if(count == 1) {
                sumNode = new ListNode(sum);
                sumHead = sumNode;
            } else {
                ListNode temp = new ListNode(sum);
                sumNode.next = temp;
                sumNode = sumNode.next;
            }
        }
        if(carry != 0) {
            ListNode carryNode = new ListNode(carry);
            sumNode.next = carryNode;
        }
        return sumHead;
    }
}
