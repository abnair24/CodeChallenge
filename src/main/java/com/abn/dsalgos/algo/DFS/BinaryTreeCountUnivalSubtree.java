package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

/*
Given the root of a binary tree, return the number of uni-value subtrees.

A uni-value subtree means all nodes of the subtree have the same value.

Soln : Given a node in our tree, it is a univalue subtree if it meets one of the following criteria:

            1. The node has no children (base case)
            2. All of the node's children are univalue subtrees, and the node and its children all have the same value
 */

public class BinaryTreeCountUnivalSubtree {

    private int count = 0;

    public int countUnivalSubtrees(MyTreeNode<Integer> root) {
        isUniVal(root);
        return count;
    }

    private boolean isUniVal(MyTreeNode<Integer> root) {

        //Base case 1
        if (root == null) {
            return true;
        }

        //Condition 1 check for unival
        if (root.left == null && root.right == null) {
            count ++;
            return true;
        }

        // Part 2 criteria check for Condition 2: node and its children all have the same value
        boolean leftIsEqual = (root.left == null) || (root.left.data == root.data);
        boolean rightIsEqual = (root.right == null) || (root.right.data == root.data);

        // Part 1 criteria check for Condition 1: node's children are univalue subtrees
        boolean leftChildren = isUniVal(root.left);
        boolean rightChildren = isUniVal(root.right);

        // Condition 2 check for unival
        if ((leftChildren && rightChildren) && (leftIsEqual && rightIsEqual)) {
            count ++;
            return true;
        } else {
            return false;
        }
    }
}
