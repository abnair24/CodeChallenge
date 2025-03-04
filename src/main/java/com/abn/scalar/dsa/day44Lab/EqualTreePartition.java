package com.abn.scalar.dsa.day44Lab;

import com.abn.dsalgos.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
You have a binary tree with integer values, and you need to check if it is possible to divide the tree into two separate trees,
by cutting one edge, such that both trees have the same total sum of nodes.

Approach: Find the total sum, find 2 two subtrees which has half sum


      5
    /   \
   3     7             sum =28, check two trees can be formed with sum = 14 each, if one tree can be formed with 14, then
  / \   / \            other will be present
 4   2  6  1

 o/p = true

      5
    /   \               sum = 27, sum cant be divided into half. so o/p is false
   8     9
        / \
        2  3

o/p = false

 */
public class EqualTreePartition {

    private boolean found = false;
    private long totalSum = 0;

    public int solve(TreeNode A) {

        totalSum = calculateSum(A);

        if (totalSum % 2 != 0) {
            return 0;
        }

        findEqualPartition(A);

        return found ? 1 : 0;
    }

    private long calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }

    private long findEqualPartition(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long leftSum = findEqualPartition(node.left);
        long rightSum = findEqualPartition(node.right);

        if (node.left != null && leftSum * 2 == totalSum) {
            found = true;
        }

        if (node.right != null && rightSum * 2 == totalSum) {
            found = true;
        }

        return node.val + leftSum + rightSum;
    }
}
