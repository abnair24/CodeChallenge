package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.Stack;

public class BinaryTreeNonRecursive<T> {

    MyTreeNode root;
    MyTreeNode temp;

    public BinaryTreeNonRecursive() {
        root = null;
    }

    public void inOrder(MyTreeNode node) {
        Stack<MyTreeNode> stack = new Stack<>();

        while(true) {
            while(root !=null){
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()) {
                return;
            }
            root = stack.pop();
            System.out.println(root.data);
            root = root.right;
        }
    }

    public void preOrder(MyTreeNode node) {
        Stack<MyTreeNode> stack = new Stack<>();

        while(true) {
            while(root!=null) {
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()){
                return;
            }

            root = stack.pop();
            root = root.right;
        }
    }

    public void postOrder(MyTreeNode node) {
        Stack<MyTreeNode> stack = new Stack<>();

        while(true) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()){
                return;
            }

//            MyTreeNode temp = stack.peek().right;
//            if(temp == null) {
//               temp = stack.pop();
//               System.out.println(temp.data);
//               while(!stack.isEmpty() && temp == stack.peek().right) {
//                   temp = stack.pop();
//                   System.out.println(temp.data);
//               }
//            } else {
//                root = temp;
//            }

            /*
            Insert to stack till root.left becomes null
            Check whether stack top element has right node, if not pop out
            If node is present, make it as root and push to stack.
            While popping out check whether poped out element is the right elemnt of stack.peek
             */

            while (!stack.isEmpty() && (stack.peek().right == null || stack.peek().right == temp)) {
                temp = stack.pop();
                System.out.println(temp.data);
            }
            if(!stack.isEmpty()) {
                root = stack.peek().right;
            }
        }
    }
}
