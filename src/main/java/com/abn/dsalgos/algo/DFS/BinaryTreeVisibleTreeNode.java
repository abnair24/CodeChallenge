package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

/*
In a binary tree, a node is considered “visible” if no node on the root-to-itself path has a greater value.
The root is always “visible” since there
are no other nodes between the root and itself. Given a binary tree, count the number of “visible” nodes.

 */
public class BinaryTreeVisibleTreeNode {

    public static void main(String[] args) {
        BinaryTreeVisibleTreeNode binaryTreeVisibleTreeNode = new BinaryTreeVisibleTreeNode();
        MyTreeNode<Integer> root = new MyTreeNode<>(9);
        root.left = new MyTreeNode(8);
        root.right = new MyTreeNode(11);
        root.right.left = new MyTreeNode(20);
        root.right.left.right = new MyTreeNode(6);

        System.out.println(binaryTreeVisibleTreeNode.visibleNodeCount(root));
    }

    public int visibleNodeCount(MyTreeNode<Integer> root) {

        return visibleNodeCountHelper(root, Integer.MIN_VALUE);
    }

    private int visibleNodeCountHelper(MyTreeNode<Integer> root, int maxValue) {

        if (root == null) {
            return 0;
        }

        int total = 0;
        if (root.data >= maxValue) {
            total++;
        }

        total += visibleNodeCountHelper(root.left, Math.max(root.data, maxValue));
        total += visibleNodeCountHelper(root.right, Math.max(root.data, maxValue));

        return total;
    }
}
