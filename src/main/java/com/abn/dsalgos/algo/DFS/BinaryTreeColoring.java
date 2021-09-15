package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.TreeNode;

/*
https://leetcode.com/problems/binary-tree-coloring-game/
 */
public class BinaryTreeColoring {

    public boolean coloring(TreeNode root, int n, int x) {

        TreeNode xNode = getNode(root, x);
        if(xNode == null) {
            return false;
        }

        if(xNode.left == null && xNode.right == null) {
            return true;
        }

        int leftCount = getCount(xNode.left);
        int rightCount = getCount(xNode.right);
        int parentCount = n - leftCount - rightCount - 1;

        return Math.max(parentCount, Math.max(leftCount, rightCount)) > n /2;
    }

    private TreeNode getNode(TreeNode root, int x) {

        if(root == null) {
            return null;
        }

        if(root.val == x) {
            return root;
        }

        TreeNode leftNode = getNode(root.left, x);
        if(leftNode != null) {
            return leftNode;
        }

        TreeNode rightNode = getNode(root.right, x);
        if(rightNode != null) {
            return rightNode;
        }

        return null;
    }

    private int getCount(TreeNode node) {

        if(node == null) {
            return 0;
        }

        return getCount(node.left) + getCount(node.right) + 1;
     }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new BinaryTreeColoring().coloring(root, 3, 2));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(8);
        root1.left.right.right = new TreeNode(9);
        System.out.println(new BinaryTreeColoring().coloring(root1, 9, 3));
    }
}
