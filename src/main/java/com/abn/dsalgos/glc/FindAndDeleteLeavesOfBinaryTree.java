package com.abn.dsalgos.glc;

import com.abn.dsalgos.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.

                    1
                 2     3
              4     5


 Output: [[4,5,3],[2],[1]]
 */

public class FindAndDeleteLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private int traverse(TreeNode root, List<List<Integer>> res){
        if(root == null)
            return 0;

        int left = traverse(root.left, res);
        int right = traverse(root.right, res);

        int curr = Math.max(left, right);

        if(res.size()>curr){
            List<Integer> l = res.get(curr);
            l.add(root.val);
        } else {
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            res.add(l);
        }

        return curr+1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindAndDeleteLeavesOfBinaryTree findAndDeleteLeavesOfBinaryTree = new FindAndDeleteLeavesOfBinaryTree();
        findAndDeleteLeavesOfBinaryTree.findLeaves(root);
    }
}
