package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;

import java.util.Stack;

/*
Find the kth smallest or largest number in a BST
 */

public class BinarySearchTreeKthSmallestLargest<T extends Comparable<T>> {

    MyBSTNode<T> root;

    public BinarySearchTreeKthSmallestLargest() {
        root = null;
    }

    public void insertNode(MyBSTNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }

        MyBSTNode<T> current = root;
        MyBSTNode<T> parent = null;

        while(current != null) {
            parent = current;

            if(node.data.compareTo(current.data) < 0) {

                current = current.left;
                if(current == null) {
                    parent.left = node;
                    return;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    /*
    Traverse tree in-order. While popping out from stack, decrement the k value.
    Return node value when k becomes zero
     */

    public T kthSmallest(MyBSTNode<T> root,int k) {
        Stack<MyBSTNode<T>> stack = new Stack<>();

        MyBSTNode<T> temp = root;
        int num = k;

        while(true) {
            while(temp != null) {
                stack.add(temp);
                temp = temp.left;
            }

            if(stack.isEmpty()){
                return null;
            }

            temp = stack.pop();
            num --;

            if(num == 0) {
                return temp.data;
            }
            temp = temp.right;
        }
    }

    public void display(MyBSTNode<T> node) {
        if(node != null) {
            display(node.left);
            System.out.print(node.data + " ");
            display(node.right);
        }
    }

    public T kthLargest(MyBSTNode<T> root, int k) {
        Stack<MyBSTNode<T>>stack = new Stack<>();

        MyBSTNode<T> temp = root;
        int num = k;

        while(true) {
            while(temp != null) {
                stack.add(temp);
                temp = temp.right;
            }

            if(stack.isEmpty()) {
                return null;
            }

            temp = stack.pop();
            num --;

            if(num == 0) {
                return temp.data;
            }

            temp = temp.left;
        }
    }

}
