package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.Stack;

/*
Find the path of a node from root for binary tree.
 */

public class BinaryTreePathFromRootToNode<T> {

    MyTreeNode root;

    public BinaryTreePathFromRootToNode() {
        root = null;
    }

    public Stack<MyTreeNode> getPathAsStack(MyTreeNode node, T value) {

        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(node);

        if (node.data == value) {
            return stack;
        }

        MyTreeNode currentNode = node;

        while (!stack.isEmpty()) {
            while (currentNode.left != null && !currentNode.left.isVisited) {

                currentNode.left.isVisited = true;
                stack.push(currentNode.left);

                if (currentNode.left.data == value) {
                    return stack;
                } else {
                    currentNode = currentNode.left;
                }
            }

            while (currentNode.right != null && !currentNode.right.isVisited) {
                currentNode.right.isVisited = true;
                stack.push(currentNode.right);

                if (currentNode.right.data == value) {
                    return stack;
                } else {
                    currentNode = currentNode.right;
                }
            }
            if ((currentNode.left == null && currentNode.right == null) || (currentNode.left.isVisited && currentNode.right.isVisited)) {
                stack.pop();
            }

            currentNode = stack.peek();
        }
        throw new RuntimeException("unexpected");
    }

    public void getPath(MyTreeNode node, T value) {
        Stack<MyTreeNode> pathAsStack = getPathAsStack(node, value);
        System.out.println(pathAsStack);
    }
}
