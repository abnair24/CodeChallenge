package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

public class BinaryTreeLCARecursion {

    MyTreeNode<Integer> root;

    public BinaryTreeLCARecursion() {
        root = null;
    }

    public MyTreeNode<Integer> lowestCommonAncestor(MyTreeNode<Integer> root, MyTreeNode<Integer> p, MyTreeNode<Integer> q) {

        if (root == null) {
            return null;
        }

        //Descendants of itself
        if (root == p || root == q) {
            return root;
        }

        //recursively find for left and right
        MyTreeNode<Integer> leftChild = lowestCommonAncestor(root.left, p, q);
        MyTreeNode<Integer> rightChild = lowestCommonAncestor(root.right, p, q);

        // left and right child null, then no common ancestor
        if (leftChild == null && rightChild == null) {
            return null;
        }

        // both child non null, then common is root
        if (leftChild != null && rightChild != null) {
            return root;
        }

        // one of the child non null, return non null child which is the ancestor
        if (leftChild != null) {
            return leftChild;
        } else {
            return rightChild;
        }
    }
}
