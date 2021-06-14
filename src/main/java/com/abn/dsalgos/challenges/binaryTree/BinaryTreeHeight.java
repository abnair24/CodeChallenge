package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Find the height of a BT
 */

public class BinaryTreeHeight<T> {

    public MyTreeNode<T> root;

    public BinaryTreeHeight() {
        root = null;
    }

    int depth = 1;

    public int height(MyTreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int height = 0;

        Queue<MyTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            height++;
            int nodeCount = queue.size();
            while (nodeCount > 0) {
                MyTreeNode<T> temp = queue.poll();

                if (temp != null && temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp != null && temp.right != null) {
                    queue.add(temp.right);
                }
                nodeCount--;
            }
        }
        return height;
    }

    // Bottom up approach in recursion.
    // In each recursive call, we will firstly call the function recursively for all the children nodes
    // and then come up with the answer according to the returned values and the value of the current node itself

    public int heightRecursiveBottomUp(MyTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            int left_depth = heightRecursiveBottomUp(node.left);
            int right_depth = heightRecursiveBottomUp(node.right);

            return (Math.max(left_depth, right_depth) + 1);
        }
    }


    // visit the node first to come up with some values,
    // and pass these values to its children when calling the function recursive
    private int heightRecursiveTopDownHelper(MyTreeNode<T> node, int level) {

        if(node == null) {
            return 0;
        }

        if(node.left == null || node.right == null) {
            depth = Math.max(depth, level);
        }
        heightRecursiveTopDownHelper(node.left, level + 1);
        heightRecursiveTopDownHelper(node.right, level + 1);

        return depth;
    }

    public int heightRecursiveTopDown(MyTreeNode<T> node) {

        return heightRecursiveTopDownHelper(node, 1);
    }
}
