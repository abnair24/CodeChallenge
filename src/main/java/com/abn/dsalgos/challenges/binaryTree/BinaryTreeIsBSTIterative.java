package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyBTBSTNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeIsBSTIterative<T extends Comparable<T>> {

    MyBTBSTNode<T> root;

    public BinaryTreeIsBSTIterative() {
        root = null;
    }

    public boolean isBST(MyBTBSTNode<T> root){
        Queue<MyBTBSTNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            MyBTBSTNode<T> temp = queue.poll();

            if (temp.data.compareTo((T) temp.max) > 0 || temp.data.compareTo((T) temp.min) < 0) {
                return false;
            }

            if(temp.left != null) {
                temp.left.max = (Integer) temp.data;
                temp.left.min = (Integer) temp.min;
                queue.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.max =(Integer) temp.max;
                temp.right.min = (Integer) temp.data;
                queue.add(temp.right);
            }

        }
        return true;
    }
}
