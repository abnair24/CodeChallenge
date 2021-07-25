package com.abn.dsalgos.algo.kwayMerge;

import com.abn.dsalgos.utils.ListNode;

import java.util.PriorityQueue;

public class MergeKsortedLinkedList {

    public ListNode merge(ListNode[] listNodes) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a1, a2) -> a1.val - a2.val);

        //Add first node of each list into min heap.
        for(ListNode node: listNodes) {
            if(node != null) {
                minHeap.add(node);
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while (!minHeap.isEmpty()) {

            ListNode temp = minHeap.poll();

            if(head == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = tail.next;
            }

            if(temp.next != null) {
                minHeap.add(temp.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(6);

        ListNode root3 = new ListNode(3);
        root3.next = new ListNode(4);

        ListNode[] lists = new ListNode[]{root1, root2, root3};

        MergeKsortedLinkedList mergeKsortedLinkedList = new MergeKsortedLinkedList();
        ListNode result = mergeKsortedLinkedList.merge(lists);

        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
