package com.abn.scalar.dsa.day42;

/*
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.

Example Input

Input 1:

       26
     /    \
    10     3
   /  \     \
  4   6      3
Input 2:

       26
     /    \
    10     3
   /  \     \
  4   6      4


Example Output

Output 1:

 1
Output 2:

 0
 */
public class SumTree {

    boolean isSumTree = true;

    public int solve(TreeNode root) {

        if(root == null) {
            return 0;
        }

        sumTree(root);
        return isSumTree ? 1: 0;
     }

     private int sumTree(TreeNode node) {

        if(node.left == null && node.right == null) {
            return node.val;
        }

        int leftSum = node.left != null ? sumTree(node.left) : 0;
        int rightSum = node.right != null ? sumTree(node.right) : 0;
        int childrenSum = leftSum + rightSum;
        isSumTree = isSumTree && (node.val == childrenSum);
        return leftSum + rightSum + node.val;
     }
}
