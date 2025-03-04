package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewBT {

    public ArrayList<Integer> solve(TreeNode node) {
        int nodeCount;
        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> rightViewResult = new ArrayList<>();
        if (node == null) {
            return rightViewResult;
        }

        queue.add(node);
        while (!queue.isEmpty()) {
            int i = 1;
            nodeCount = queue.size();
            while (i <= nodeCount) {
                TreeNode current = queue.poll();
                if (i == nodeCount) {
                    rightViewResult.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                i++;
            }
        }
        return rightViewResult;
    }
}
