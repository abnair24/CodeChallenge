package com.abn.scalar.dsa.day60;

import com.abn.dsalgos.utils.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.

Input 1:

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9

Output 1:

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

Input 2:

 10 -> 12
 13
 5 -> 6

Output 2:
5 -> 6 -> 10 -> 12 ->13

 */
public class MergeKSortedLL {

    public ListNode mergeKLists(ArrayList<ListNode> nodes) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node: nodes) {
            minHeap.offer(node);
        }

        ListNode head = null;
        ListNode tail = null;

        while(!minHeap.isEmpty()) {

            ListNode temp = minHeap.poll();

            if(head == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = tail.next;
            }

            if(temp.next != null) {
                minHeap.offer(temp.next);
            }
        }

        return head;
    }
}
