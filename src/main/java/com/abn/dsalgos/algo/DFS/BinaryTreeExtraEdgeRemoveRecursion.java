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

    public MyTreeNode<Integer> removeExtraNode(MyTreeNode<Integer> root) {

        // DFS and Store the visited nodes in hashset.
        // Duplicate addition returns false and store that node as null

        Set<MyTreeNode<Integer>> hs = new HashSet<>();
        if (root == null) {
            return null;
        }

        return removeNode(root, hs);
    }

    private MyTreeNode<Integer> removeNode(MyTreeNode<Integer> root, Set<MyTreeNode<Integer>> hs) {

        if (root == null || !hs.add(root)) {
            return null;
        }

        removeNode(root.left, hs);
        removeNode(root.right, hs);

        return root;
    }
}
