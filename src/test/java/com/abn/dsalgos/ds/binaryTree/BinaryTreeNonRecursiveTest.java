package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeNonRecursiveTest {

    private BinaryTreeNonRecursive<Integer> binaryTreeNonRecursive = new BinaryTreeNonRecursive<>();

    @Test
    public void inOrderTest() throws Exception {
        binaryTreeNonRecursive.root = new MyTreeNode(1);
        binaryTreeNonRecursive.root.left = new MyTreeNode(2);
        binaryTreeNonRecursive.root.right = new MyTreeNode(3);
        binaryTreeNonRecursive.root.left.left = new MyTreeNode(4);
        binaryTreeNonRecursive.root.left.right = new MyTreeNode(5);

        binaryTreeNonRecursive.inOrder(binaryTreeNonRecursive.root);
    }

    @Test
    public void preOrderTest() throws Exception {
        binaryTreeNonRecursive.root = new MyTreeNode(1);
        binaryTreeNonRecursive.root.left = new MyTreeNode(2);
        binaryTreeNonRecursive.root.right = new MyTreeNode(3);
        binaryTreeNonRecursive.root.left.left = new MyTreeNode(4);
        binaryTreeNonRecursive.root.left.right = new MyTreeNode(5);
        binaryTreeNonRecursive.root.right.left = new MyTreeNode(6);
        binaryTreeNonRecursive.root.right.right = new MyTreeNode(7);

        binaryTreeNonRecursive.preOrder(binaryTreeNonRecursive.root);
    }

    @Test
    public void postOrderTest() throws Exception {
        binaryTreeNonRecursive.root = new MyTreeNode(1);
        binaryTreeNonRecursive.root.left = new MyTreeNode(2);
        binaryTreeNonRecursive.root.right = new MyTreeNode(3);
        binaryTreeNonRecursive.root.left.left = new MyTreeNode(4);
        binaryTreeNonRecursive.root.left.right = new MyTreeNode(5);
        binaryTreeNonRecursive.root.left.right.left = new MyTreeNode(6);
        binaryTreeNonRecursive.root.right.right = new MyTreeNode(7);
        binaryTreeNonRecursive.root.right.right.right = new MyTreeNode(8);

        binaryTreeNonRecursive.postOrder(binaryTreeNonRecursive.root);
    }

    @Test
    public void postOrderTest1() throws Exception {

        binaryTreeNonRecursive.root = new MyTreeNode(10);
        binaryTreeNonRecursive.root.left = new MyTreeNode(-6);
        binaryTreeNonRecursive.root.left.right = new MyTreeNode(8);
        binaryTreeNonRecursive.root.right= new MyTreeNode(15);

        binaryTreeNonRecursive.postOrder(binaryTreeNonRecursive.root);
    }
}
