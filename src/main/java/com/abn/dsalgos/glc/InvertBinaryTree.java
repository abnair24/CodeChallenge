package com.abn.dsalgos.glc;

import com.abn.dsalgos.utils.TreeNode;

/*
Given the root of a binary tree, invert the tree, and return its root.

                   1                               1
                2     3           ==>            3    2
             4    5 6    7                     7   6 5   4

https://leetcode.com/problems/invert-binary-tree/

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
 */
public class InvertBinaryTree {

    public TreeNode invert(TreeNode root) {

        if(root == null) {

            return null;
        }

        TreeNode leftNode = invert(root.left);
        TreeNode rightNode = invert(root.right);

        root.right = leftNode;
        root.left = rightNode;

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invert(root);
    }
}
