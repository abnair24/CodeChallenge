package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeLowestCommonAncestorTest {

    BinarySearchTreeLowestCommonAncestor bst = new BinarySearchTreeLowestCommonAncestor();

    @Test ()
    public void test()
            throws Exception {
        MyBSTNode<Integer> root = new MyBSTNode<>(40);
        root.left = new MyBSTNode<>(20);
        root.right = new MyBSTNode<>(60);
        root.left.left = new MyBSTNode<>(10);
        root.left.right = new MyBSTNode<>(30);
        root.left.left.left = new MyBSTNode<>(5);
        root.right.left = new MyBSTNode<>(50);
        root.right.right = new MyBSTNode<>(70);
        root.right.left.right = new MyBSTNode<>(55);

        Assert.assertEquals(bst.lowestCommonAncestor(root, root.left.left, root.right.right), root);
        Assert.assertEquals(bst.lowestCommonAncestor(root, root.left.left, root.left.left.left), root.left.left);
    }
}
