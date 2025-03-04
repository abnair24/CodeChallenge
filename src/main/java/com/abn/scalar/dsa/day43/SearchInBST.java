package com.abn.scalar.dsa.day43;

public class SearchInBST {

    public boolean search(TreeNode root, int k) {

        if(root == null) {
            return false;
        }

        if(k == root.val) {
            return true;
        } else if(k < root.val) {
            return search(root.left, k);
        } else {
            return search(root.right, k);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        SearchInBST searchInBST = new SearchInBST();
        System.out.println(searchInBST.search(root, 9));
        System.out.println(searchInBST.search(root, 10));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
