package com.abn.scalar.dsa.day55;

import com.abn.dsalgos.utils.TreeNode;

/*
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Input 1:

   1       1
  / \     / \
 2   3   2   3

Output 1:
 1

Input 2:

   1       1
  / \     / \
 2   3   3   3

Output 2:

 0

 */
public class IdenticalBT {

    public int isIdentical(TreeNode A, TreeNode B) {

        if(A == B) {
            return 1;
        }

        if(A == null || B == null) {
            return 0;
        }

        if(A.val != B.val) {
            return 0;
        }

        int left = isIdentical(A.left, B.left);

        if(left == 0) {
            return 0;
        }

        int right = isIdentical(A.right, B.right);

        if(right == 0) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {

        IdenticalBT identicalBT = new IdenticalBT();

        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(2);
        B.right = new TreeNode(3);

        System.out.println(identicalBT.isIdentical(A, B));
    }
}
