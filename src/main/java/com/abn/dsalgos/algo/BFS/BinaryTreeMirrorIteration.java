package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;

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

    MyTreeNode root;

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
                continue;
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

    public static void main(String[] args) {

        BinaryTreeMirrorIteration binaryTreeMirrorIteration = new BinaryTreeMirrorIteration();

        MyTreeNode node1 = new MyTreeNode(1);
        MyTreeNode node2 = new MyTreeNode(2);
        MyTreeNode node3 = new MyTreeNode(2);
        MyTreeNode node4 = new MyTreeNode(3);
        MyTreeNode node5 = new MyTreeNode(4);
        MyTreeNode node6 = new MyTreeNode(4);
        MyTreeNode node7 = new MyTreeNode(3);

        binaryTreeMirrorIteration.root = node1;
        binaryTreeMirrorIteration.root.left = node2;
        binaryTreeMirrorIteration.root.right = node3;
        binaryTreeMirrorIteration.root.left.left = node4;
        binaryTreeMirrorIteration.root.left.right = node5;
        binaryTreeMirrorIteration.root.right.left = node6;
        binaryTreeMirrorIteration.root.right.right = node7;

        Assert.assertTrue(binaryTreeMirrorIteration.isMirror(node1));
    }
}
