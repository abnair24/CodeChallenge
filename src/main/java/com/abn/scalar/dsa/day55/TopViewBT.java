package com.abn.scalar.dsa.day55;

import com.abn.dsalgos.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Output 1:

 [1, 2, 4, 8, 3, 7]

            1
           /  \
          2    3
           \
            4
             \
              5

Output 2:
 [1, 2, 3]

 */


class Pair{
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }

}

public class TopViewBT {

    public int[] solve(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {

            Pair current = queue.poll();

            if (!map.containsKey(current.level)) {
                map.put(current.level, current.node.val);
            }

            if (current.node.left != null) {
                queue.add(new Pair(current.node.left, current.level - 1));
            }

            if (current.node.right != null) {
                queue.add(new Pair(current.node.right, current.level + 1));
            }
        }

        int[] ans = new int[map.size()];
        int idx = 0;
        for(int key : map.keySet()){
            ans[idx++] = map.get(key);
        }

        return ans;
    }

    public static void main(String[] args) {

        TopViewBT topViewBT = new TopViewBT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(Arrays.toString(topViewBT.solve(root)));
    }
}


