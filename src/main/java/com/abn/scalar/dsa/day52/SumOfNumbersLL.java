package com.abn.scalar.dsa.day52;

import com.abn.dsalgos.utils.ListNode;

/*
You are given two linked lists, A and B, representing two non-negative numbers.

The digits are stored in reverse order, and each of their nodes contains a single digit.

Add the two numbers and return it as a linked list.

Return a pointer to the head of the required linked list.

A = [2, 4, 3]
 B = [5, 6, 4]

 o/p: [7, 0, 8]

 A = [9, 9]
 B = [1]
 o/p: [0, 0, 1]
 */
public class SumOfNumbersLL {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//        ListNode head1 = reverseLinkedList(l1);
//        ListNode head2 = reverseLinkedList(l2);


        ListNode head1 = l1;
        ListNode head2 = l2;

        int carry = 0;
        int sum;

        ListNode sumHead = null;
        ListNode sumNode = null;

        int count = 0;

        while (head1 != null || head2 != null) {
            count++;

            sum = carry;
            if (head1 != null) {
                sum = sum + head1.val;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum = sum + head2.val;
                head2 = head2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            if (count == 1) {
                sumNode = new ListNode(sum);
                sumHead = sumNode;
            } else {
                ListNode tempNode = new ListNode(sum);
                sumNode.next = tempNode;
                sumNode = sumNode.next;
            }
        }

        if (carry != 0) {
            sumNode.next = new ListNode(carry);
        }

        return (sumHead);
    }

    public static void main(String[] args) {

        SumOfNumbersLL sumOfNumbersLL = new SumOfNumbersLL();

        ListNode first = new ListNode(9);
        first.next = new ListNode(9);
        first.next.next = new ListNode(1);

        ListNode second = new ListNode(1);

       sumOfNumbersLL.addTwoNumbers(first, second);
    }
}
