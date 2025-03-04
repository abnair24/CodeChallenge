package com.abn.scalar.dsa.day53;

import com.abn.dsalgos.utils.ListNode;

import java.util.List;

public class IntersectionLL {

    public ListNode findIntersection2(ListNode nodeA, ListNode nodeB) {

        if (nodeA == null || nodeB == null) {
            return null;
        }

        ListNode headA = nodeA;
        ListNode headB = nodeB;

        while (headA != headB) {

            headA = (headA == null) ? nodeB : headA.next;
            headB = (headB == null) ? nodeA : headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {

        IntersectionLL intersectionLL = new IntersectionLL();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next.next = node3;
        ListNode node4 = new ListNode(4);
        node.next.next.next = node4;
        ListNode node5 = new ListNode(5);
        node.next.next.next.next = node5;

        ListNode nodeB = new ListNode(6);
        nodeB.next = node.next.next;
        nodeB.next.next = node4;
        nodeB.next.next.next = node5;
        System.out.println(intersectionLL.findIntersection2(node, nodeB).val);
    }
}
