package com.abn.dsalgos.dailyCoding;

import com.abn.dsalgos.utils.MyBSTNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Daily Coding Problem: Problem #1224
Given a binary search tree and a range [a, b] (inclusive), return the sum of the elements of the binary search tree within the range.

    5
   / \
  3   8
 / \ / \
2  4 6  10

range [4, 9], return 23 (5 + 4 + 6 + 8).
 */
public class Dcp1224BTSumInRange {

    public int sumInRange(MyBSTNode<Integer> root, int lower, int upper) {

        Queue<MyBSTNode<Integer>> queue = new LinkedList<>();

        int nodeCount;
        int sum = 0;

        if(root == null) {
            return -1 ;
        }

        queue.add(root);

        while(!queue.isEmpty()) {

            nodeCount = queue.size();
            while(nodeCount > 0) {

                MyBSTNode<Integer> node = queue.remove();

                if (node.data >= lower && node.data <= upper) {

                    sum += node.data;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                nodeCount --;
            }
        }
        return sum;
    }
}
