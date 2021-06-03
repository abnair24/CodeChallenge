package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */

public class BinaryTreePathWithSequence {

    MyTreeNode<Integer> root;

    public BinaryTreePathWithSequence() {
        root = null;
    }

    public boolean isPathExist(int[] numArray) {
        if (root == null) {
            return numArray.length == 0;
        }

        return findPath(root, numArray, 0);
    }

    private boolean findPath(MyTreeNode<Integer> node, int[] numArray, int index) {

        if (node == null) {
            return false;
        }

        if (index >= numArray.length || node.data != numArray[index]) {
            return false;
        }

        if (node.left == null && node.right == null && index == numArray.length - 1) {
            return true;
        }

        return findPath(node.left, numArray, index + 1) || findPath(node.right, numArray, index + 1);
    }
}
