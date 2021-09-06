package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

/*
Given the root of a binary tree, check whether it is a mirror of itself


                    1
           2                 2
      3         4       4          3
  5      6   6     5  5     6    6    5

 */
public class BinaryTreeMirror {

    public boolean isMirror(MyTreeNode root) {

        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(MyTreeNode leftNode, MyTreeNode rightNode) {

        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode == null || rightNode == null) {
            return false;
        }

        if (leftNode.data != rightNode.data) {
            return false;
        }

        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }
}
