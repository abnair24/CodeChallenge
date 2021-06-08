package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.ds.linkedList.MyLinkedList;
import com.abn.dsalgos.utils.LinkNode;

/*
Merge two sorted linked lists and return it as a sorted list.
The list should be made by splicing together the nodes of the first two lists.

ll1  : 1-> 2-> 3
ll2  : 1 -> 3 -> 4
o/p : 1 -> 1 -> 2 -> 3 -> 3 -> 4

 */
public class LinkedListMergeSortedRecursion {

    private LinkNode<Integer> mergeSorted(LinkNode head1, LinkNode head2) {

        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        if((int) head1.data < (int) head2.data) {
            head1.next = mergeSorted(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSorted(head1, head2.next);
            return head2;
        }
    }

    public MyLinkedList<Integer> merge(LinkNode<Integer> l1, LinkNode<Integer>l2) {

        LinkNode<Integer> mergeHead = mergeSorted(l1, l2);
        MyLinkedList<Integer> merge = new MyLinkedList<>();

        while(mergeHead != null) {
            merge.insertLast(mergeHead.data);
            mergeHead = mergeHead.next;
        }

        return merge;
    }
}
