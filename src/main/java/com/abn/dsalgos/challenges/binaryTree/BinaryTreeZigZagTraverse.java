package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagTraverse {

    public void zigZag(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        int height = 0;
        int nodeCount;

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            height++;
            nodeCount = queue.size();
            List<Integer> tempList = new LinkedList<>();

            while (nodeCount > 0) {

                TreeNode temp = queue.remove();

                if (height % 2 == 0) {
                    tempList.add(0, temp.val);
                } else {
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

            list.add(tempList);
        }
        System.out.println(list);
    }
}
