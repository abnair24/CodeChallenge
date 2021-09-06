package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.TreeNodeConnect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a perfect binary tree, Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

                        1                                               1 -> null
               2                   3              ==>               2   ->   3 -> null
        4            5       6            7                      3  -> 4 ->5 -> 6 -> null

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
 */
public class BinaryTreeLevelOrderConnect {

    public TreeNodeConnect connectLevels(TreeNodeConnect root) {

        Queue<TreeNodeConnect> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        TreeNodeConnect previous;
        int nodeCount;

        if (root == null) {
            return null;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            previous = null;
            nodeCount = queue.size();

            while (nodeCount > 0) {

                TreeNodeConnect current = queue.remove();

                if (previous != null) {
                    previous.next = current;
                }
                previous = current;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
                nodeCount--;
            }
        }
        return root;
    }
}
