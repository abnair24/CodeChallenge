package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeMaxSumLevel {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int level = 1;
        queue.add(root);
        Map<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        int maxLevel = -1;

        int levelSum = 0;
        while (!queue.isEmpty()) {

            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current != null && current.left != null) {
                    queue.add(current.left);
                }

                if (current != null && current.right != null) {
                    queue.add(current.right);
                }
            }
            map.put(level, levelSum);
            levelSum = 0;
            level++;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxLevel = entry.getKey();
            }
        }

        return maxLevel;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        BinaryTreeMaxSumLevel binaryTreeMaxSumLevel = new BinaryTreeMaxSumLevel();
        System.out.println(binaryTreeMaxSumLevel.maxLevelSum(root));
    }
}
