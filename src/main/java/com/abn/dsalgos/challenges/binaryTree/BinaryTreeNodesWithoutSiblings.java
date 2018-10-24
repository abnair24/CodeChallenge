package com.abn.dsalgos.challenges.binaryTree;


import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
 Given a binary tree, Print All the Nodes that don’t have siblings.

Note: sibling node is the node which has the same parent, so you need to print the nodes who is a single child of his parent.
 */
public class BinaryTreeNodesWithoutSiblings<T> {
    public MyTreeNode<T> root;

    public BinaryTreeNodesWithoutSiblings() {
        root = null;
    }

    public void nodesWithoutSibling(MyTreeNode node) {

        if (node == null) {
            return ;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            MyTreeNode temp = queue.poll();

            if(temp.left != null && temp.right == null ){
                System.out.println(temp.left.data);
            }

            if(temp.left == null && temp.right != null ){
                System.out.println(temp.right.data);
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}
