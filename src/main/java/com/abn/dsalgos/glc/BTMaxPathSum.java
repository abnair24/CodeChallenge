package com.abn.dsalgos.glc;

import com.abn.dsalgos.utils.TreeNode;

/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any
node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Input: [1,2,3]

       1
      / \
     2   3

Output: 6


Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

 */
public class BTMaxPathSum {

    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findPath(root);
        return sum;
    }

    private int findPath(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftSum = findPath(root.left);
            int rightSum = findPath(root.right);

            int totalSum = root.val + leftSum + rightSum;

            int maxChildNodesSum = maxOfChildNodes(root.val, leftSum, rightSum);

            sum = Math.max(sum, Math.max(totalSum, maxChildNodesSum));

            return maxChildNodesSum;
        }
    }

    private int maxOfChildNodes(int val, int leftSum, int rightSum) {
        int max = Math.max(leftSum, rightSum);

        if(val + max > val) {
            return val + max;
        } else {
            return val;
        }
    }

    public static void main(String[] args) {
        BTMaxPathSum maxPath = new BTMaxPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPath.maxPathSum(root));
    }
}
