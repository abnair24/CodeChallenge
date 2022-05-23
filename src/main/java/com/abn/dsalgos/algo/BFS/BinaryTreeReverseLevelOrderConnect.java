package com.abn.dsalgos.algo.BFS;

/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
(i.e., from left to right, level by level from leaf to root).

            3

         9     20

             15    7
 */

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeReverseLevelOrderConnect {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        int nodeCount;

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(queue.size() > 0) {
            List<Integer> list = new ArrayList<>();

            nodeCount = queue.size();

            while(nodeCount > 0) {

                TreeNode current = queue.remove();

                if(current != null) {
                    list.add(current.val);
                }

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }

                nodeCount --;
            }
            result.add(0, list);
        }
        return result;
    }
}
