package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeNodesWithoutSiblingsTest {

    BinaryTreeNodesWithoutSiblings binaryTreeNodesWithoutSiblings = new BinaryTreeNodesWithoutSiblings();

    @Test
    public void test() throws Exception {
        binaryTreeNodesWithoutSiblings.root = new MyTreeNode(1);
        binaryTreeNodesWithoutSiblings.root.left = new MyTreeNode(2);
        binaryTreeNodesWithoutSiblings.root.right = new MyTreeNode(3);
        binaryTreeNodesWithoutSiblings.root.left.left = new MyTreeNode(4);
        binaryTreeNodesWithoutSiblings.root.left.right = new MyTreeNode(5);
        binaryTreeNodesWithoutSiblings.root.left.right.left = new MyTreeNode(7);
        binaryTreeNodesWithoutSiblings.root.left.left.left = new MyTreeNode(6);
        binaryTreeNodesWithoutSiblings.root.right.right = new MyTreeNode(8);
        binaryTreeNodesWithoutSiblings.root.right.right.left = new MyTreeNode(9);

        binaryTreeNodesWithoutSiblings.nodesWithoutSibling(binaryTreeNodesWithoutSiblings.root);
    }
}
