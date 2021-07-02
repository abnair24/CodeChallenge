package com.abn.dsalgos.glc;

import java.util.HashMap;
import java.util.Map;

/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

https://leetcode.com/problems/copy-list-with-random-pointer/
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

public class RandomPointerLinkedListCopy {

    Map<Node, Node> visitedMap = new HashMap<>();

    public Node randomCopy(Node head) {

        if (head == null) {
            return head;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val, null, null);
        visitedMap.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.next = getNode(oldNode.next);
            newNode.random = getNode(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visitedMap.get(head);
    }

    private Node getNode(Node node) {

        if (node != null) {
            if (!visitedMap.containsKey(node)) {
                visitedMap.put(node, new Node(node.val, null, null));
            }
            return visitedMap.get(node);
        }
        return null;
    }
}
