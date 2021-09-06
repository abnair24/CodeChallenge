package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.utils.TreeNode;

/*
Given two binary trees, write a function to check if they are the same or not.

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
 */
public class BinaryTreeIdentical {

    public boolean isIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
