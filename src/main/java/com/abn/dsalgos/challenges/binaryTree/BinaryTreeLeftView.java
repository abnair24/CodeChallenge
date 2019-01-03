package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLeftView<T> {

    public MyTreeNode<T> root;
    int nodeCount;

    public BinaryTreeLeftView() {
        root = null;
    }

    public void leftView(MyTreeNode<T> node) {

        Queue<MyTreeNode<T>> queue = new LinkedList<>();

        if(node == null) {
            return;
        }

        queue.add(node);

        while(!queue.isEmpty()) {
            int i =0;
            nodeCount= queue.size();

            while( i < nodeCount) {
                MyTreeNode<T> current = queue.poll();
                if(i==0) {
                    System.out.println(current.data);
                }

                if(current.left!=null) {
                    queue.add(current.left);
                }

                if(current.right!=null) {
                    queue.add(current.right);
                }
                i++;
            }
        }

    }
}
