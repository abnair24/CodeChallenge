package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeMinMaxElementTest {

    BinaryTreeMaxElement binaryTreeMaxElement = new BinaryTreeMaxElement();

    @Test
    public void maxTest() throws Exception {
        binaryTreeMaxElement.root = new MyTreeNode(10);
        binaryTreeMaxElement.root.left = new MyTreeNode(20);
        binaryTreeMaxElement.root.right = new MyTreeNode(6);
        binaryTreeMaxElement.root.left.left = new MyTreeNode(21);
        binaryTreeMaxElement.root.left.right = new MyTreeNode(8);
        binaryTreeMaxElement.root.right.right = new MyTreeNode(30);
        binaryTreeMaxElement.root.right.right.right = new MyTreeNode(7);

        Assert.assertEquals(binaryTreeMaxElement.maxNode(binaryTreeMaxElement.root),30);
    }

    @Test
    public void minTest() throws Exception {
        binaryTreeMaxElement.root = new MyTreeNode(10);
        binaryTreeMaxElement.root.left = new MyTreeNode(20);
        binaryTreeMaxElement.root.right = new MyTreeNode(6);
        binaryTreeMaxElement.root.left.left = new MyTreeNode(21);
        binaryTreeMaxElement.root.left.right = new MyTreeNode(8);
        binaryTreeMaxElement.root.right.right = new MyTreeNode(30);
        binaryTreeMaxElement.root.right.right.right = new MyTreeNode(7);

        Assert.assertEquals(binaryTreeMaxElement.minNode(binaryTreeMaxElement.root), 6);
    }
}
