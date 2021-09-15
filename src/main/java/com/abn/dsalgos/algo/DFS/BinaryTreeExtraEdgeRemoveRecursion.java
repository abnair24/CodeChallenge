package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.HashSet;
import java.util.Set;

/*
Given a binary tree, where an arbitary node has 2 parents
i.e two nodes in the tree have the same child. Identify the defective node and remove an extra edge to fix the tree.

       1
	  / \
	 2   3   =>
	/ \ /
   4   5


     1			       1
    / \			      / \
   2   3    or	     2   3
  / \ 			    /   /
 4   5		       4   5

 */
public class BinaryTreeExtraEdgeRemoveRecursion {

    MyTreeNode<Integer> result = null;

    public MyTreeNode<Integer> removeExtraNode(MyTreeNode<Integer> root) {

        // DFS and Store the visited nodes in hashset.
        // Duplicate addition returns false and store that node as null

        Set<MyTreeNode<Integer>> hs = new HashSet<>();
        if (root == null) {
            return null;
        }

        removeNode(root);
        return result;
    }

    private void removeNode(MyTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        if(root.left != null && root.left.isVisited) {
            result = root.left;
            root.left = null;
        }

        if(root.right != null && root.right.isVisited) {
            result = root.right;
            root.right = null;
        }

        removeNode(root.left);
        root.isVisited = true;
        removeNode(root.right);

    }

    public static void main(String[] args) {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.right.left = root.left.right;

        new BinaryTreeExtraEdgeRemoveRecursion().removeExtraNode(root);
    }
}
