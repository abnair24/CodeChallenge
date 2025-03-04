package com.abn.scalar.dsa.day38;

import com.abn.dsalgos.utils.ListNode;

public class KReverseLinkedList {

    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode prevNode = null;
        ListNode nextNode;
        ListNode tailNode;
        ListNode tempTail = null;
        ListNode first = null;

        int blockSize = B;

        int size = 0;
        int t = 0;
        int i = 0;


        while (A != null) {
            size++;
            A = A.next;
        }

        while (i++ < size / B) {
            tailNode = current;
            while (blockSize-- > 0) {
                nextNode = current.next;
                current.next = prevNode;
                prevNode = current;
                current = nextNode;
                t++;
            }

            blockSize = B;

            if (t == B) {
                first = prevNode;
                tempTail = tailNode;
            }

            tempTail.next = prevNode;

            if (t == size) {
                tailNode.next = null;
            } else {
                tempTail = tailNode;
                tailNode.next = current;
            }
        }
        return first;
    }
}
