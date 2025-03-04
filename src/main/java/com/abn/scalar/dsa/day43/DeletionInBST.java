package com.abn.scalar.dsa.day43;

public class DeletionInBST {

    public TreeNode delete(TreeNode root, int k) {

        if(root == null) {
            return null;
        }

        if(root.val == k) {

            /*
            case 1: leaf node
             */
            if(root.left == null && root.right == null) {
                return null;
            }

            /*
            case 2: node with 1 chile
             */
            else if(root.left == null || root.right == null) {
                if(root.left == null) {
                    return root.right;
                } else {
                    return root.left;
                }
            }

            /*
            case 3: node with both child present
             */
            else {
                TreeNode current = inOrderPredecessor(root);
                swap(current, root);

                root.left = delete(root.left, k);  // delete swapped value
            }

        } else if(k < root.val) {
            root.left = delete(root.left, k);
        } else {
            root.right = delete(root.right, k);
        }
        return root;
    }

    private TreeNode inOrderPredecessor(TreeNode root) {
        TreeNode temp = root.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private void swap(TreeNode A, TreeNode B){
        int tempVal = A.val;
        A.val = B.val;
        B.val = tempVal;
    }

    public void display(TreeNode node) {
        if (node != null) {
            display(node.left);
            System.out.print(node.val + " ");
            display(node.right);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(17);

        DeletionInBST deletionInBST = new DeletionInBST();
        deletionInBST.display(deletionInBST.delete(root, 12));


    }
}
