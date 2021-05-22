package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyBinarySearchTreeTest {

    MyBinarySearchTree<Integer>myBinarySearchTree = new MyBinarySearchTree<>();

    @Test
    public void test() throws Exception {

        myBinarySearchTree.insertNode(new MyBSTNode<>(5));
        myBinarySearchTree.insertNode(new MyBSTNode<>(3));
        myBinarySearchTree.insertNode(new MyBSTNode<>(8));
        myBinarySearchTree.insertNode(new MyBSTNode<>(10));
        myBinarySearchTree.insertNode(new MyBSTNode<>(1));
        myBinarySearchTree.insertNode(new MyBSTNode<>(4));
        myBinarySearchTree.insertNode(new MyBSTNode<>(7));

        myBinarySearchTree.display(myBinarySearchTree.root);
    }

    @Test
    public void testSearch() {
        myBinarySearchTree.insertNode(new MyBSTNode<>(5));
        myBinarySearchTree.insertNode(new MyBSTNode<>(3));
        myBinarySearchTree.insertNode(new MyBSTNode<>(8));
        myBinarySearchTree.insertNode(new MyBSTNode<>(10));
        myBinarySearchTree.insertNode(new MyBSTNode<>(1));
        myBinarySearchTree.insertNode(new MyBSTNode<>(4));
        myBinarySearchTree.insertNode(new MyBSTNode<>(7));

        Assert.assertTrue(myBinarySearchTree.search(new MyBSTNode<>(4)));
//        Assert.assertFalse(myBinarySearchTree.search(new MyBSTNode<>(9)));
    }

    @Test
    public void deleteTest() {
        myBinarySearchTree.insertNode(new MyBSTNode<>(44));
        myBinarySearchTree.insertNode(new MyBSTNode<>(17));
        myBinarySearchTree.insertNode(new MyBSTNode<>(32));
        myBinarySearchTree.insertNode(new MyBSTNode<>(28));
        myBinarySearchTree.insertNode(new MyBSTNode<>(88));
        myBinarySearchTree.insertNode(new MyBSTNode<>(29));
        myBinarySearchTree.insertNode(new MyBSTNode<>(97));
        myBinarySearchTree.insertNode(new MyBSTNode<>(65));
        myBinarySearchTree.insertNode(new MyBSTNode<>(54));
        myBinarySearchTree.insertNode(new MyBSTNode<>(82));
        myBinarySearchTree.insertNode(new MyBSTNode<>(83));

        myBinarySearchTree.insertNode(new MyBSTNode<>(76));
        myBinarySearchTree.insertNode(new MyBSTNode<>(75));
        myBinarySearchTree.insertNode(new MyBSTNode<>(80));
        myBinarySearchTree.insertNode(new MyBSTNode<>(78));

        myBinarySearchTree.display(myBinarySearchTree.root);
        Assert.assertTrue(myBinarySearchTree.delete(new MyBSTNode<>(65)));
        myBinarySearchTree.display(myBinarySearchTree.root);
    }

    @Test
    public void deleteTest1() {
    /*
     finding successor When right child left is null
    */
        myBinarySearchTree.insertNode(new MyBSTNode<>(44));
        myBinarySearchTree.insertNode(new MyBSTNode<>(17));
        myBinarySearchTree.insertNode(new MyBSTNode<>(32));
        myBinarySearchTree.insertNode(new MyBSTNode<>(28));
        myBinarySearchTree.insertNode(new MyBSTNode<>(88));
        myBinarySearchTree.insertNode(new MyBSTNode<>(29));
        myBinarySearchTree.insertNode(new MyBSTNode<>(97));
        myBinarySearchTree.insertNode(new MyBSTNode<>(65));
        myBinarySearchTree.insertNode(new MyBSTNode<>(54));
        myBinarySearchTree.insertNode(new MyBSTNode<>(82));
        myBinarySearchTree.insertNode(new MyBSTNode<>(83));

        myBinarySearchTree.display(myBinarySearchTree.root);
        Assert.assertTrue(myBinarySearchTree.delete(new MyBSTNode<>(65)));
        myBinarySearchTree.display(myBinarySearchTree.root);
    }

    @Test
    public void deleteTest2() {
/*
 finding successor When right child left is not null and right is null
 */
        myBinarySearchTree.insertNode(new MyBSTNode<>(44));
        myBinarySearchTree.insertNode(new MyBSTNode<>(17));
        myBinarySearchTree.insertNode(new MyBSTNode<>(32));
        myBinarySearchTree.insertNode(new MyBSTNode<>(28));
        myBinarySearchTree.insertNode(new MyBSTNode<>(88));
        myBinarySearchTree.insertNode(new MyBSTNode<>(29));
        myBinarySearchTree.insertNode(new MyBSTNode<>(97));
        myBinarySearchTree.insertNode(new MyBSTNode<>(65));
        myBinarySearchTree.insertNode(new MyBSTNode<>(54));
        myBinarySearchTree.insertNode(new MyBSTNode<>(82));
        myBinarySearchTree.insertNode(new MyBSTNode<>(83));

        myBinarySearchTree.insertNode(new MyBSTNode<>(76));
        myBinarySearchTree.insertNode(new MyBSTNode<>(75));
        myBinarySearchTree.insertNode(new MyBSTNode<>(80));
        myBinarySearchTree.insertNode(new MyBSTNode<>(78));

        myBinarySearchTree.display(myBinarySearchTree.root);
        Assert.assertTrue(myBinarySearchTree.delete(new MyBSTNode<>(65)));
        myBinarySearchTree.display(myBinarySearchTree.root);
    }

    @Test
    public void deleteTest3() {
/*
 when in order successor right child is not null
 */
        myBinarySearchTree.insertNode(new MyBSTNode<>(44));
        myBinarySearchTree.insertNode(new MyBSTNode<>(17));
        myBinarySearchTree.insertNode(new MyBSTNode<>(32));
        myBinarySearchTree.insertNode(new MyBSTNode<>(28));
        myBinarySearchTree.insertNode(new MyBSTNode<>(88));
        myBinarySearchTree.insertNode(new MyBSTNode<>(29));
        myBinarySearchTree.insertNode(new MyBSTNode<>(97));
        myBinarySearchTree.insertNode(new MyBSTNode<>(65));
        myBinarySearchTree.insertNode(new MyBSTNode<>(54));
        myBinarySearchTree.insertNode(new MyBSTNode<>(82));
        myBinarySearchTree.insertNode(new MyBSTNode<>(83));

        myBinarySearchTree.insertNode(new MyBSTNode<>(76));
        myBinarySearchTree.insertNode(new MyBSTNode<>(75));
        myBinarySearchTree.insertNode(new MyBSTNode<>(80));
        myBinarySearchTree.insertNode(new MyBSTNode<>(78));

        myBinarySearchTree.display(myBinarySearchTree.root);
        Assert.assertTrue(myBinarySearchTree.delete(new MyBSTNode<>(65)));
        myBinarySearchTree.display(myBinarySearchTree.root);
    }
}
