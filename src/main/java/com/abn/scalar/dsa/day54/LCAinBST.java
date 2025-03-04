package com.abn.scalar.dsa.day54;

import com.abn.dsalgos.utils.TreeNode;

/*
Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.


Note 1 :- It is guaranteed that the nodes B and C exist.

Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
 */
public class LCAinBST {

    public int solve(TreeNode A, int B, int C) {

        if(A == null) {
            return -1;
        }

        if(B > A.val && C > A.val) {
            return solve(A.right, B, C);
        } else if(B < A.val && C < A.val) {
            return solve(A.left, B, C);
        } else {
            return A.val;
        }
    }
}
