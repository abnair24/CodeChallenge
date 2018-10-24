package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeMinMaxElementTest {

    BinaryTreeMinMaxElement binaryTreeMinMaxElement = new BinaryTreeMinMaxElement();

    @Test
    public void maxTest() throws Exception {
        binaryTreeMinMaxElement.root = new MyTreeNode(10);
        binaryTreeMinMaxElement.root.left = new MyTreeNode(20);
        binaryTreeMinMaxElement.root.right = new MyTreeNode(6);
        binaryTreeMinMaxElement.root.left.left = new MyTreeNode(21);
        binaryTreeMinMaxElement.root.left.right = new MyTreeNode(8);
        binaryTreeMinMaxElement.root.right.right = new MyTreeNode(30);
        binaryTreeMinMaxElement.root.right.right.right = new MyTreeNode(7);

        Assert.assertEquals(binaryTreeMinMaxElement.maxNode(binaryTreeMinMaxElement.root),30);
    }

    @Test
    public void minTest() throws Exception {
        binaryTreeMinMaxElement.root = new MyTreeNode(10);
        binaryTreeMinMaxElement.root.left = new MyTreeNode(20);
        binaryTreeMinMaxElement.root.right = new MyTreeNode(6);
        binaryTreeMinMaxElement.root.left.left = new MyTreeNode(21);
        binaryTreeMinMaxElement.root.left.right = new MyTreeNode(8);
        binaryTreeMinMaxElement.root.right.right = new MyTreeNode(30);
        binaryTreeMinMaxElement.root.right.right.right = new MyTreeNode(7);

        Assert.assertEquals(binaryTreeMinMaxElement.minNode(binaryTreeMinMaxElement.root), 6);
    }
}
