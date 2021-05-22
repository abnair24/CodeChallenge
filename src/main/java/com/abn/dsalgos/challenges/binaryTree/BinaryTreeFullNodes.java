package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
       Print all the nodes which have both left and right children.
 */

public class BinaryTreeFullNodes<T> {

    MyTreeNode root;

    public BinaryTreeFullNodes() {
        root = null;
    }

    public void findFullNodes(MyTreeNode node) {
        if(node == null) {
            return;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(queue.size() > 0) {

            MyTreeNode temp = queue.poll();

            if(temp.left!=null && temp.right != null) {
                System.out.println(temp.data);
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
