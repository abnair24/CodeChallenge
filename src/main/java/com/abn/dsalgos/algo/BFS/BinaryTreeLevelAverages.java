package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, populate an array to represent the averages of all of its levels.

                        1
                    2       3
                4     5   6     7
 */
public class BinaryTreeLevelAverages {

    public List<Double> findLevelAverages(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<Double> result = new ArrayList<>();

        int nodeCount;
        int levelSum;
        int levelCount;

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(queue.size() > 0) {
            levelSum = 0;
            nodeCount = queue.size();
            levelCount = nodeCount;

            while(nodeCount > 0) {

                TreeNode current = queue.remove();

                if(current != null) {
                    levelSum += current.val;
                }

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }

                nodeCount --;
            }

            result.add((double) (levelSum / levelCount));
        }
        return result;
    }
}
