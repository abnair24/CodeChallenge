package com.abn.scalar.dsa.day43;

public class InsertInBST {

    public TreeNode insert(TreeNode root, int k) {

        if(root == null) {
            return new TreeNode(k);
        }

        if(root.val == k) {
            return root;
        } else if(k < root.val) {
            root.left = insert(root.left, k);
        } else {

            root.right = insert(root.right, k);
        }

        return root;
    }

    public void display(TreeNode node) {
        if (node != null) {
            display(node.left);
            System.out.print(node.val + " ");
            display(node.right);
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

        InsertInBST insertInBST = new InsertInBST();
        insertInBST.display(insertInBST.insert(root, 2));
        System.out.println();
        insertInBST.display(insertInBST.insert(root, 7));

    }
}
