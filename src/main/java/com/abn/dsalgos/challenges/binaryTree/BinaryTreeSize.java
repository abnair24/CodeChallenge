package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSize<T> {

    MyTreeNode root;

    public BinaryTreeSize() {
        root = null;
    }

    public int size() {
        return recursiveSize(root);
    }

    public int nonRecSize() {
        return nonRecursiveSize(root);
    }

    private int recursiveSize(MyTreeNode node) {
        if(node == null) {
            return 0;
        } else {
            return (recursiveSize(node.left) + 1 + recursiveSize(node.right));
        }
    }

    private  int nonRecursiveSize(MyTreeNode node) {
        if(node!=null) {
            int size = 0;
            Queue<MyTreeNode> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()) {
                MyTreeNode temp = queue.poll();
                size++ ;
                if(temp.left !=null) {
                    queue.add(temp.left);
                }

                if(temp.right!=null) {
                    queue.add(temp.right);
                }
            }
            return size;
        }
        return 0;
    }
}
