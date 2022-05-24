package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
 Given a binary tree, determine if it is height-balanced.
 Hint : A binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BinaryTreeIsBalanced {

    //ToDO : fix the code for failing test
    public boolean isBalanced(MyTreeNode<Integer> node) {
        if (node == null) {
            return true;
        }

        Queue<MyTreeNode<Integer>> queue = new LinkedList<>();

        int height = 1;
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        queue.add(node);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();

            while (nodeCount > 0) {
                MyTreeNode<Integer> temp = queue.poll();

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

                /*
                Height diff of left and right subtree at every node needs to be checked and diff <=1
                Below condition checks when either left node is null or right node becomes null.
                Test case: 4,5,6
                 */
                if (temp.left == null || temp.right == null) {
                    if (minHeight > height) {
                        minHeight = height;
                    }
                    if (maxHeight < height) {
                        maxHeight = height;
                    }
                }

                nodeCount--;
            }
            if (Math.abs(maxHeight - minHeight) < 2) {
                return false;
            }
            height++;
        }
        return true;
    }
}
