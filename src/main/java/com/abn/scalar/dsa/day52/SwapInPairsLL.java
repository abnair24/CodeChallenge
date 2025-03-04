package com.abn.scalar.dsa.day52;

import com.abn.dsalgos.utils.ListNode;

/*
Given a linked list A, swap every two adjacent nodes and return its head.
NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.


Input 1:

 A = 1 -> 2 -> 3 -> 4
Input 2:

 A = 7 -> 2 -> 1

 Output 1:

 2 -> 1 -> 4 -> 3
Output 2:

 2 -> 7 -> 1

 */
public class SwapInPairsLL {

    public ListNode solution(ListNode A) {
        return reverseInBlocks(A, 2);
    }

    public ListNode reverseInBlocks(ListNode node, int k) {

        ListNode current = node;
        ListNode prevNode = null;
        ListNode nextNode;
        ListNode tailNode;
        ListNode tempTail = null;
        ListNode first = null;
        ListNode last = null;
        int size = 0;

        int blockSize = k;

        int t = 0;
        int i = 0;


        while (node != null) {
            size++;
            node = node.next;
        }

        if(size == 1) {
            return current;
        }

        while (i++ < size / k) {
            tailNode = current;
            while (blockSize-- > 0) {
                nextNode = current.next;
                current.next = prevNode;
                prevNode = current;
                current = nextNode;
                t++;
            }

            blockSize = k;

            if (t == k) {
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

    public static void main(String[] args) {

        SwapInPairsLL swapInPairsLL = new SwapInPairsLL();
        ListNode first = new ListNode(1);
        swapInPairsLL.solution(first);
    }
}
