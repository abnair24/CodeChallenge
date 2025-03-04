package com.abn.scalar.dsa.day43;

/*
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.


Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.


Return 0 if false and 1 if true.



Example Input

Input 1:


   1
  /  \
 2    3
Input 2:


  2
 / \
1   3


Example Output

Output 1:

 0
Output 2:

 1


 */
public class ValidBST {

    public boolean isBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    public int isValidBST(TreeNode node) {

        // Integer.MIN_VALUE and Integer.MAX_VALUE is not used for max and min values
        // as if single node with MAX_VALUE is present,
        // returns false instead of true. Modified code and added test.

        return isBST(node, null,null) ? 1 : 0;
    }
}
