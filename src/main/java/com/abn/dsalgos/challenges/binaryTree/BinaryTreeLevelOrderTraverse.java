package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
populate the values of all nodes of each level from left to right in separate sub-arrays.
(i.e., from left to right, level by level).

          3
         / \
        9   20
            / \
           15  7
    o/p : [[3], [9,20], [15,7]]

 */

public class BinaryTreeLevelOrderTraverse {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            List<Integer> tempList = new ArrayList<>(nodeCount);

            while (nodeCount > 0) {
                TreeNode temp = queue.poll();

                if (temp != null) {
                    tempList.add(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
                nodeCount--;
            }
            result.add(tempList);
        }
        System.out.println("Level order traversal: " + result);
        return result;
    }
}
