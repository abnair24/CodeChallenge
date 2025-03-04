package com.abn.scalar.dsa.day52;

import com.abn.dsalgos.utils.ListNode;

/*
Merge two sorted linked lists, A and B, and return it as a new list.




The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.


Output Format

Return a pointer to the head of the merged linked list.

Example Input

Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
Input 2:

 A = 1 -> 2 -> 3
 B = Null


Example Output

Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:

 1 -> 2 -> 3
 */
public class MergeSortedLL {

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);

        ListNode tail = dummy;

        while (true) {
            if (node1 == null) {
                tail.next = node2;
                break;
            }

            if (node2 == null) {
                tail.next = node1;
                break;
            }

            if (node1.val <= node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }

            tail = tail.next;
        }

        ListNode first = dummy.next;
        return first;

    }
}
