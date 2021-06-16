package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

public class BinaryTreeIsBalancedRecursive {

    public boolean isBalanced(MyTreeNode<Integer> root) {

        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(MyTreeNode<Integer> root) {
        if(root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
