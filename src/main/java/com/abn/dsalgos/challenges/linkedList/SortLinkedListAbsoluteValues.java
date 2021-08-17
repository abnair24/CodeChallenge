package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;

/*
Given a linked list that is sorted based on absolute values. Sort the list based on actual values.

Input :  1 -> -10
output: -10 -> 1

Input : 1 -> -2 -> -3 -> 4 -> -5
output: -5 -> -3 -> -2 -> 1 -> 4

Input : -5 -> -10
Output: -10 -> -5

Input : 5 -> 10
output: 5 -> 10
 */
public class SortLinkedListAbsoluteValues {

    public LinkNode<Integer> sorted(LinkNode<Integer> head) {

        LinkNode<Integer> prev = head;
        LinkNode<Integer> current = head.next;

        while(current != null) {

            if(current.data < prev.data) {

                prev.next = current.next;
                current.next = head;
                head = current;
                current = prev;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        LinkNode<Integer> head = new LinkNode<>(1);
        head.next = new LinkNode<Integer>(-2);
        head.next.next = new LinkNode<>(-3);
        head.next.next.next = new LinkNode<>(-4);
        head.next.next.next.next = new LinkNode<Integer>(5);
        head.next.next.next.next.next = new LinkNode<Integer>(-6);

        SortLinkedListAbsoluteValues sort = new SortLinkedListAbsoluteValues();
        sort.sorted(head);
    }
}
