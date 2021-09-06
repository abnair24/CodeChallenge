package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.utils.LinkNode;

public class LinkedListLengthRecursion {

    public int lengthOfLinkedList(LinkNode<Integer> head) {

        //base case
        if (head == null) {
            return 0;
        }

        //recursive case
        else {
            return 1 + lengthOfLinkedList(head.next);
        }
    }
}
