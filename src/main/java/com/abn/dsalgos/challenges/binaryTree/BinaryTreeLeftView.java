package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLeftView<T> {

    public MyTreeNode<T> root;
    int nodeCount;

    public BinaryTreeLeftView() {
        root = null;
    }

    public List<Integer> leftView(MyTreeNode<T> node) {

        Queue<MyTreeNode<T>> queue = new LinkedList<>();
        List<Integer> leftViewResult = new ArrayList<>();

        if (node == null) {
            return leftViewResult;
        }

        queue.add(node);

        while (!queue.isEmpty()) {
            int i = 1;
            nodeCount = queue.size();

            while (i <= nodeCount) {
                MyTreeNode<T> current = queue.poll();
                if (i == 1) {
                    leftViewResult.add((Integer) current.data);
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
        return leftViewResult;

    }

    public List<Integer> rightView(MyTreeNode<T> node) {
        Queue<MyTreeNode<T>> queue = new LinkedList<>();

        List<Integer> rightViewResult = new ArrayList<>();
        if (node == null) {
            return rightViewResult;
        }

        queue.add(node);
        while (!queue.isEmpty()) {
            int i = 1;
            nodeCount = queue.size();
            while (i <= nodeCount) {
                MyTreeNode<T> current = queue.poll();
                if (i == nodeCount) {
                    rightViewResult.add((Integer) current.data);
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
