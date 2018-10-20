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
            while(node !=null){
                stack.push(node);
                node = node.left;
            }

            if(stack.isEmpty()) {
                return;
            }
            node = stack.pop();
            System.out.println(node.data);
            node = node.right;
        }
    }

    public void preOrder(MyTreeNode node) {
        Stack<MyTreeNode> stack = new Stack<>();

        while(true) {
            while(node!=null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.left;
            }

            if(stack.isEmpty()){
                return;
            }

            node = stack.pop();
            node = node.right;
        }
    }

    public void postOrder(MyTreeNode node) {
        Stack<MyTreeNode> stack = new Stack<>();

        while(true) {
            while(node!=null) {
                stack.push(node);
                node = node.left;
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
                node = stack.peek().right;
            }
        }
    }
}
