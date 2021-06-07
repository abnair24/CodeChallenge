package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Find the height of a BT
 */

public class BinaryTreeHeight<T> {

    public MyTreeNode root;

    public BinaryTreeHeight() {
        root = null;
    }

    public int height(MyTreeNode node) {
        if (node == null) {
            return 0;
        }

        int height = 0;

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            height++;
            int nodeCount = queue.size();
            while (nodeCount > 0) {
                MyTreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                nodeCount--;
            }
        }
        return height;
    }

    public int heightRecursive(MyTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return (Math.max(heightRecursive(node.left), heightRecursive(node.right)) + 1);
        }
    }
}
