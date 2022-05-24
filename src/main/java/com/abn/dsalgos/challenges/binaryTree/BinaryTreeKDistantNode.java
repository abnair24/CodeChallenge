package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.

                     3
                5         1
             6     2   0     8
          7     4

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]

https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

 */

public class BinaryTreeKDistantNode {

    Map<MyTreeNode, MyTreeNode> parentMap = new HashMap<>();

    public static void main(String[] args) {
        BinaryTreeKDistantNode binaryTreeKDistantNode = new BinaryTreeKDistantNode();

        MyTreeNode<Integer> root = new MyTreeNode<>(3);
        root.left = new MyTreeNode<>(5);
        root.right = new MyTreeNode<>(1);
        root.left.left = new MyTreeNode<>(6);
        root.left.right = new MyTreeNode<>(2);
        root.right.left = new MyTreeNode<>(0);
        root.right.right = new MyTreeNode<>(8);
        root.left.right.left = new MyTreeNode<>(7);
        root.left.right.right = new MyTreeNode<>(4);
        binaryTreeKDistantNode.distanceK(root, root.left, 3);
    }

    public List<Integer> distanceK(MyTreeNode<Integer> root, MyTreeNode<Integer> target, int k) {

        dfs(root, null);

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<MyTreeNode> visited = new HashSet<>();
        visited.add(target);

        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == k) {
                List<Integer> result = new ArrayList<>();
                for (MyTreeNode<Integer> node : queue) {
                    result.add(node.data);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                MyTreeNode<Integer> temp = queue.poll();
                visited.add(temp);

                if (temp.left != null && !visited.contains(temp.left)) {
                    visited.add(temp.left);
                    queue.add(temp.left);
                }

                if (temp.right != null && !visited.contains(temp.right)) {
                    visited.add(temp.right);
                    queue.add(temp.right);
                }

                MyTreeNode<Integer> parentNode = parentMap.get(temp);
                if (parentNode != null && !visited.contains(parentNode)) {
                    visited.add(parentNode);
                    queue.add(parentNode);
                }
            }
            dist++;
        }
        return new ArrayList<>();
    }

    private void dfs(MyTreeNode<Integer> root, MyTreeNode<Integer> parent) {
        if (root != null) {
            parentMap.put(root, parent);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
