package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.utils.LinkNode;

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's
nodes (i.e., only nodes themselves may be changed.)

I/P : 1 -> 2 -> 3 -> 4 -> 5
o/p : 2 -> 1 -> 4 -> 3 -> 5
 */

public class LinkedListSwapNodesRecursion {

    public LinkNode<Integer> swapNodesInPairs(LinkNode<Integer> head) {

        if(head == null || head.next == null) {
            return head;
        }

        LinkNode<Integer> current = head;
        LinkNode<Integer> previous = head.next;
        LinkNode<Integer> tail = head.next.next;

        current.next = null;
        previous.next = current;
        current.next = swapNodesInPairs(tail);

        return previous;
    }
}
