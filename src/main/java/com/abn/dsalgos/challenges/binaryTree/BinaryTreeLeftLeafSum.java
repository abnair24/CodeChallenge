package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.Stack;


public class BinaryTreeLeftLeafSum<T> {
    public MyTreeNode root = null;
    private int sum =0;

    public BinaryTreeLeftLeafSum() {
        root = null;
    }


    public int sumOfLeftLeafNode(MyTreeNode node) {
        int sum = 0;

        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            MyTreeNode temp = stack.pop();

            if (temp.left != null && temp.left.left == null & temp.left.right == null) {
                sum += (int) temp.left.data;
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if(temp.right != null) {
                stack.push(temp.right);
            }
        }
        return sum;
    }
}
