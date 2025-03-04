package com.abn.scalar.dsa.day55;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node,
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree.

Input 1:
     1
    /  \
   2    3

Output 1:


        1 -> NULL
       /  \
      2 -> 3 -> NULL

Input 2:
        1
       /  \
      2    5
     / \  / \
    3  4  6  7

O/P:
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL

 */
public class NextPointerBT {

    public void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode previous;
        int nodeCount;

        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            previous = null;
            nodeCount = queue.size();

            while (nodeCount > 0) {

                TreeLinkNode current = queue.remove();

                if (previous != null) {
                    previous.next = current;
                }
                previous = current;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
                nodeCount--;
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}