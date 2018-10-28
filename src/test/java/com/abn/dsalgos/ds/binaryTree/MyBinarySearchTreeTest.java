package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;
import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyBinarySearchTreeTest {

    MyBinarySearchTree<Integer>myBinarySearchTree = new MyBinarySearchTree<>();

    @Test
    public void test() throws Exception {

        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(5));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(3));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(8));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(10));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(1));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(4));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(7));

        myBinarySearchTree.display(myBinarySearchTree.root);
    }

    @Test
    public void testSearch() throws Exception {
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(5));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(3));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(8));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(10));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(1));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(4));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(7));

        Assert.assertTrue(myBinarySearchTree.search(new MyBSTNode<Integer>(4)));
        Assert.assertFalse(myBinarySearchTree.search(new MyBSTNode<Integer>(9)));
    }
}
