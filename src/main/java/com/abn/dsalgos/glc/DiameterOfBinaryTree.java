package com.abn.dsalgos.glc;

import com.abn.dsalgos.utils.TreeNode;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Input: root = [1,2,3,4,5]
Output: 3
 */
public class DiameterOfBinaryTree {

    int maxDiameter = Integer.MIN_VALUE;

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
