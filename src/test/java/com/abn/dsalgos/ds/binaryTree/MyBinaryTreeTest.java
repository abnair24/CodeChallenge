package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class MyBinaryTreeTest {

    private MyBinaryTree<Integer>myBinaryTree = new MyBinaryTree<>();

    @Test
    public void inOrdertest() throws Exception {
        myBinaryTree.root = new MyTreeNode(1);
        myBinaryTree.root.left = new MyTreeNode(3);
        myBinaryTree.root.left.left = new MyTreeNode(4);
        myBinaryTree.root.left.right = new MyTreeNode(2);
        myBinaryTree.root.right = new MyTreeNode(7);
        myBinaryTree.root.right.left = new MyTreeNode(0);

        myBinaryTree.inOrder(myBinaryTree.root);
    }

    @Test
    public void preOrderTest() throws Exception {
        myBinaryTree.root = new MyTreeNode(1);
        myBinaryTree.root.left = new MyTreeNode(3);
        myBinaryTree.root.left.left = new MyTreeNode(4);
        myBinaryTree.root.left.right = new MyTreeNode(2);
        myBinaryTree.root.right = new MyTreeNode(7);
        myBinaryTree.root.right.left = new MyTreeNode(0);

        myBinaryTree.preOrder(myBinaryTree.root);
    }

    @Test
    public void postOrderTest() throws Exception {
        myBinaryTree.root = new MyTreeNode(1);
        myBinaryTree.root.left = new MyTreeNode(3);
        myBinaryTree.root.left.left = new MyTreeNode(4);
        myBinaryTree.root.left.right = new MyTreeNode(2);
        myBinaryTree.root.right = new MyTreeNode(7);
        myBinaryTree.root.right.left = new MyTreeNode(0);

        myBinaryTree.postOrder(myBinaryTree.root);
    }

    @Test
    public void inorderTest() throws Exception {
        myBinaryTree.root = new MyTreeNode(10);
        myBinaryTree.root.left = new MyTreeNode(5);
        myBinaryTree.root.right = new MyTreeNode(15);
        myBinaryTree.root.left.left = new MyTreeNode(10);
        myBinaryTree.root.left.right = new MyTreeNode(12);
        myBinaryTree.root.left.right.left = new MyTreeNode(6);
        myBinaryTree.root.right.right = new MyTreeNode(8);
        myBinaryTree.root.right.right.left = new MyTreeNode(5);

        myBinaryTree.inOrder(myBinaryTree.root);
    }
}
