package com.abn.scalar.dsa.day54;

import com.abn.dsalgos.utils.TreeNode;

/*
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.


Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed
acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 */
public class LCAinBT {

    public int lca(TreeNode root, int p, int q) {

        if (!exists(root, p) || !exists(root, q)) {
            return -1;
        }

        if (p == q) {
            return p;
        }
        TreeNode lca = lowestCommonAncestor(root, p, q);

        return lca != null ? lca.val : -1;
    }

    private boolean exists(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        return exists(root.left, val) || exists(root.right, val);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

        if (root == null) {
            return null;
        }

        //Descendants of itself
        if (root.val == p || root.val == q) {
            return root;
        }

        //recursively find for left and right
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

        // both child non null, then common is root
        if (leftChild != null && rightChild != null) {
            return root;
        }

        // one of the child non null, return non null child which is the ancestor
        if (leftChild != null) {
            return leftChild;
        }
        if(rightChild != null) {
            return rightChild;
        }

        return null;
    }
}
