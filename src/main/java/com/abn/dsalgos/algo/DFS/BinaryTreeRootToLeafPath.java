package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;

public class BinaryTreeRootToLeafPath {

    public boolean hasPath(MyTreeNode<Integer> root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.data == targetSum) {
            return true;
        } else {
            return hasPath(root.left, targetSum - root.data) || hasPath(root.right, targetSum - root.data);
        }
    }
}
