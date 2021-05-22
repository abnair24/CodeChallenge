package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeLeftViewTest {

    BinaryTreeLeftView<Integer> binaryTreeLeftView = new BinaryTreeLeftView<>();

    @Test
    public void test() throws Exception {
        binaryTreeLeftView.root = new MyTreeNode<>(1);
        binaryTreeLeftView.root.left = new MyTreeNode<>(2);
        binaryTreeLeftView.root.right = new MyTreeNode<>(3);
        binaryTreeLeftView.root.left.left = new MyTreeNode<>(4);
        binaryTreeLeftView.root.left.right = new MyTreeNode<>(5);
        binaryTreeLeftView.root.left.right.left = new MyTreeNode<>(7);
        binaryTreeLeftView.root.left.left.left = new MyTreeNode<>(6);
        binaryTreeLeftView.root.right.right = new MyTreeNode<>(8);
        binaryTreeLeftView.root.right.right.left = new MyTreeNode<>(9);
        binaryTreeLeftView.root.right.right.left.right = new MyTreeNode<>(10);

        binaryTreeLeftView.leftView(binaryTreeLeftView.root);
    }

    @Test
    public void test1() throws Exception {
        binaryTreeLeftView.root = new MyTreeNode<>(1);
        binaryTreeLeftView.root.left = new MyTreeNode<>(2);
        binaryTreeLeftView.root.right = new MyTreeNode<>(3);
        binaryTreeLeftView.root.left.left = new MyTreeNode<>(4);
        binaryTreeLeftView.root.left.right = new MyTreeNode<>(5);
        binaryTreeLeftView.root.left.right.left = new MyTreeNode<>(7);
        binaryTreeLeftView.root.left.left.left = new MyTreeNode<>(6);
        binaryTreeLeftView.root.right.right = new MyTreeNode<>(8);
        binaryTreeLeftView.root.right.right.left = new MyTreeNode<>(9);
        binaryTreeLeftView.root.right.right.left.right = new MyTreeNode<>(10);

        binaryTreeLeftView.rightView(binaryTreeLeftView.root);
    }
}
