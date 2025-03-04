package com.abn.scalar.dsa.day44Lab;


/*

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
 the values along the path equals the given sum.



If the tree is empty, return false (no path exists)
If we reach a leaf node (no children), check if the current node's value equals the remaining target sum
For non-leaf nodes, subtract the current node's value from the target sum and recursively check:

If there's a path in the left subtree with the new sum, or
If there's a path in the right subtree with the new sum
 */
public class PathSum {

    public int hasPathSum(TreeNode A, int B) {

        return hasPathSumHelper(A, B) ? 1 : 0;
    }

    private boolean hasPathSumHelper(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSumHelper(root.left, targetSum - root.val) ||
                hasPathSumHelper(root.right, targetSum - root.val);
    }
}
