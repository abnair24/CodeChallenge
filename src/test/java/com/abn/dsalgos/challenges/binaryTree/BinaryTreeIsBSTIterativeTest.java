package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;
import com.abn.dsalgos.utils.MyBTBSTNode;
import org.testng.annotations.Test;

public class BinaryTreeIsBSTIterativeTest {

    BinaryTreeIsBSTIterative<Integer> binaryTreeIsBST = new BinaryTreeIsBSTIterative<>();

    @Test
    public void test() throws Exception {
        binaryTreeIsBST.root = new MyBTBSTNode<>(30);
        binaryTreeIsBST.root.left = new MyBTBSTNode<>(5);
        binaryTreeIsBST.root.right = new MyBTBSTNode<>(40);
        binaryTreeIsBST.root.right.left = new MyBTBSTNode<>(10);
        binaryTreeIsBST.root.right.right = new MyBTBSTNode<>(50 );

        System.out.println(binaryTreeIsBST.isBST(binaryTreeIsBST.root));
    }

    @Test
    public void test1() throws Exception {
        binaryTreeIsBST.root = new MyBTBSTNode<>(15);
        binaryTreeIsBST.root.left = new MyBTBSTNode<>(10);
        binaryTreeIsBST.root.right = new MyBTBSTNode<>(20);
        binaryTreeIsBST.root.left.left = new MyBTBSTNode<>(5);
        binaryTreeIsBST.root.left.left.left = new MyBTBSTNode<>(1);
        binaryTreeIsBST.root.left.left.right = new MyBTBSTNode<>(7);
        binaryTreeIsBST.root.left.left.right.right = new MyBTBSTNode<>(8);
        binaryTreeIsBST.root.right.left = new MyBTBSTNode<>(17);
        binaryTreeIsBST.root.right.right = new MyBTBSTNode<>(25 );

        System.out.println(binaryTreeIsBST.isBST(binaryTreeIsBST.root));

    }

}
