package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxElement<T> {

    public MyTreeNode<T> root;

    public BinaryTreeMaxElement() {
        root = null;
    }

    public int maxNode(MyTreeNode node) {

        if (node == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            MyTreeNode temp = queue.poll();
            if(max < (int) temp.data) {
                max = (int) temp.data;
            }
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        return max;
    }

    public int minNode(MyTreeNode node) {

        if (node == null) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            MyTreeNode temp = queue.poll();
            if(min > (int) temp.data) {
                min = (int) temp.data;
            }
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        return min;
    }
}
