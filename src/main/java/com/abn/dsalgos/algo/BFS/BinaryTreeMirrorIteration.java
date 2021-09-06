package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, check whether it is a mirror of itself


                    1
           2                 2
      3         4       4          3
  5      6   6     5  5     6    6    5

 */

public class BinaryTreeMirrorIteration {

    public boolean isMirror(MyTreeNode<Integer> root) {

        if (root == null) {
            return true;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {

            MyTreeNode<Integer> leftNode = queue.remove();
            MyTreeNode<Integer> rightNode = queue.remove();

            if (leftNode == null && rightNode == null) {
                return true;
            }

            if (leftNode == null || rightNode == null) {
                return false;
            }

            if (!leftNode.data.equals(rightNode.data)) {
                return false;
            }

            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }

        return true;
    }
}
