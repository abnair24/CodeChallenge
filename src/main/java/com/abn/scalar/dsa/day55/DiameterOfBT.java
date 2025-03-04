package com.abn.scalar.dsa.day55;

import com.abn.dsalgos.utils.TreeNode;

/*
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

           1
         /   \
        2     3
       / \
      4   5

o/p : 3 [Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.]

            1
          /   \
         2     3
        / \     \
       4   5     6

o/p: 4 [ Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.]


 */
public class DiameterOfBT {

    int maxDiameter = Integer.MIN_VALUE;

    TreeNode root;

    public int diameterOfBinaryTree(TreeNode root) {

        getDiameter(root);
        return maxDiameter;
    }

    private int getDiameter(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftLen = getDiameter(root.left);
        int rightLen = getDiameter(root.right);

        maxDiameter = Math.max(maxDiameter, leftLen + rightLen);

        return 1 + Math.max(leftLen, rightLen);
    }
}
