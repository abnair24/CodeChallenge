package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.*;

/*
To print all path from roof to leaf which has sum equal to given sum
 */

public class BinaryTreeRootToLeafSumPath<Integer> {

    MyTreeNode<java.lang.Integer> root;

    public BinaryTreeRootToLeafSumPath() {
        root = null;
    }

    /*
    Queue 1: For storing nodes
    Queue 2: For storing sumvalues at each node
    HashMap: For storing parent of each node
    ArrayList : For storing the entire path
     */

    public void getPath(MyTreeNode<java.lang.Integer> node, int sum) {

        Queue<MyTreeNode<java.lang.Integer>> nodeQueue = new LinkedList<>();
        Queue<java.lang.Integer> valueQueue = new LinkedList<>();
        HashMap<MyTreeNode<java.lang.Integer>, MyTreeNode<java.lang.Integer>> parent = new HashMap<>();
        List<MyTreeNode<java.lang.Integer>> parentArray;

        MyTreeNode<java.lang.Integer> current;

        nodeQueue.add(root);
        valueQueue.add(root.data);
        parent.put(root, null);

        while (!nodeQueue.isEmpty()) {
            current = nodeQueue.poll();
            int sumValue = new java.lang.Integer(valueQueue.poll()).intValue();

            if (current.left != null) {
                nodeQueue.add(current.left);
                valueQueue.add(sumValue + (int) current.left.data);
                parent.put(current.left, current);
            }
            if (current.right != null) {
                nodeQueue.add(current.right);
                valueQueue.add(sumValue + (int) current.right.data);
                parent.put(current.right, current);
            }

            if (current.left == null && current.right == null && sumValue == sum) {
                parentArray = new ArrayList<>();
                while (current != null) {
                    parentArray.add(current);
                    current = parent.get(current);
                }

                Collections.reverse(parentArray);

                for (MyTreeNode<java.lang.Integer> n : parentArray) {
                    System.out.print(" ->" + n.data);
                }
                System.out.println();
            }

        }
    }
}
