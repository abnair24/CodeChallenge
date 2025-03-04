package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBT {

    public ArrayList<ArrayList<Integer>> solve(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>(nodeCount);

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
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
