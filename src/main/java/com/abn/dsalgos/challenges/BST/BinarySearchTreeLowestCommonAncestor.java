package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;

public class BinarySearchTreeLowestCommonAncestor {

    public MyBSTNode<Integer> lowestCommonAncestor(MyBSTNode<Integer> root, MyBSTNode<Integer> p, MyBSTNode<Integer> q) {

        if (root == null) {
            return null;
        }

        if (p.data > root.data && q.data > root.data) {

            return lowestCommonAncestor(root.right, p, q);
        } else if (p.data < root.data && q.data < root.data) {

            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
