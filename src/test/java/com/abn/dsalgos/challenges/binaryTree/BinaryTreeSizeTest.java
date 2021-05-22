package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeSizeTest {

    private BinaryTreeSize<Integer>binaryTreeSize = new BinaryTreeSize<>();

    @Test
    public void test() throws Exception {
        binaryTreeSize.root = new MyTreeNode<>(1);
        binaryTreeSize.root.left = new MyTreeNode<>(2);
        binaryTreeSize.root.right = new MyTreeNode<>(3);
        binaryTreeSize.root.left.left = new MyTreeNode<>(4);
        binaryTreeSize.root.left.left.left = new MyTreeNode<>(5);
        binaryTreeSize.root.right.right = new MyTreeNode<>(6);

        System.out.println(binaryTreeSize.nonRecSize());
        System.out.println(binaryTreeSize.size());
    }
}
