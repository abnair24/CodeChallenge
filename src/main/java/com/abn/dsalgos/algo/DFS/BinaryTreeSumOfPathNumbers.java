package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.Stack;


/*

Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
Find the total sum of all the numbers represented by all paths.

          1
       7      9
     8   5   2   9

    o/p = 744   (178 + 175 + 192 + 199)
 */

public class BinaryTreeSumOfPathNumbers {

    MyTreeNode<Integer> root;

    public BinaryTreeSumOfPathNumbers() {
        root = null;
    }

    public int getPathSum() {

        Stack<MyTreeNode<Integer>> stack = new Stack<>();
        Map<MyTreeNode<Integer>, Integer> parent = Maps.newHashMap();

        stack.add(root);
        parent.put(root, 0);
        MyTreeNode<Integer> current;
        int total = 0;
        int pathSum;

        while (!stack.isEmpty()) {
            current = stack.pop();
            pathSum = 10 * parent.get(current) + current.data;

            if (current.right != null) {
                stack.add(current.right);
                parent.put(current.right, pathSum);
            }
            if (current.left != null) {
                stack.add(current.left);
                parent.put(current.left, pathSum);
            }

            if (current.left == null && current.right == null) {
                total += pathSum;
            }
        }
        return total;
    }
}
