package com.abn.scalar.dsa.day44Lab;

/*
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
of every node never differ by more than 1.


 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

public class BTHeighBalanced {

    public int isBalanced(TreeNode root) {

        boolean isBalanced = getBalanced(root);

        return isBalanced ? 1: 0;
    }
    public boolean getBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2 && getBalanced(root.left) && getBalanced(root.right);

    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
