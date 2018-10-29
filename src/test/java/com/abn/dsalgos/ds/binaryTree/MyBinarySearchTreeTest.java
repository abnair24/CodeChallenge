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
        //.assertFalse(myBinarySearchTree.search(new MyBSTNode<Integer>(9)));
    }

    @Test
    public void deleteTest() throws Exception {
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(44));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(17));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(32));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(28));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(88));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(29));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(97));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(65));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(54));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(82));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(76));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(75));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(80));
        myBinarySearchTree.insertNode(new MyBSTNode<Integer>(78));

        myBinarySearchTree.display(myBinarySearchTree.root);
        System.out.println();
        Assert.assertTrue(myBinarySearchTree.delete(new MyBSTNode<Integer>(65))));
        myBinarySearchTree.display(myBinarySearchTree.root);










    }
}
