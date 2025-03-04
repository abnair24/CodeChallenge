package com.abn.scalar.dsa.day53;

import com.abn.dsalgos.utils.ListNode;

import java.util.List;

/*
Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in each of the two partitions.

Input 1:

A = [1, 4, 3, 2, 5, 2]
B = 3

Output 1:

[1, 2, 2, 4, 3, 5]

Input 2:

A = [1, 2, 3, 1, 3]
B = 2

Output 2:

[1, 1, 2, 3, 3]

 */

public class PartitionLL {

    public ListNode partition(ListNode root, int B) {

        ListNode head = null;
        ListNode tail = null;
        ListNode headPtr = null;
        ListNode tailPtr = null;

        while(root != null) {

            ListNode current = root;

            if(current.val < B) {
                if(head == null ) {
                    head = current;
                    headPtr = head;
                } else {
                    head.next = current;
                    head = current;
                }
            } else {
                if(tail == null) {
                    tail = current;
                    tailPtr = tail;
                } else {
                    tail.next = current;
                    tail = current;
                }
            }
            root = root.next;
        }

        /*
        If all the values are higher than B
         */
        if(head == null) {
            headPtr = tailPtr;
            tail.next = null;
        }
        /*
         if not higher, current lower end to higher beginning
         */
        else if (tail != null){
            head.next = tailPtr;
            tail.next = null;
        }

        return headPtr;
    }

    public static void main(String[] args) {
        PartitionLL partitionLL = new PartitionLL();

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(8);

        partitionLL.partition(head, 4);

        ListNode head1 = new ListNode(384);
        head1.next = new ListNode(183);
        head1.next.next = new ListNode(463);
        head1.next.next.next = new ListNode(31);

        partitionLL.partition(head1, 77);

        ListNode head2 = new ListNode(31);
        head2.next = new ListNode(30);
        head2.next.next = new ListNode(48);
        head2.next.next.next = new ListNode(49);

        partitionLL.partition(head2, 50);
    }
}
