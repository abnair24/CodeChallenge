package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.TreeNodeConnect;
import org.testng.annotations.Test;

public class BinaryTreeLevelOrderConnectTest {

    BinaryTreeLevelOrderConnect binaryTreeLevelOrderConnect = new BinaryTreeLevelOrderConnect();

    @Test
    public void test() throws Exception {

        TreeNodeConnect root = new TreeNodeConnect(1);
        root.left = new TreeNodeConnect(2);
        root.right = new TreeNodeConnect(3);
        root.left.left = new TreeNodeConnect(4);
        root.left.right = new TreeNodeConnect(5);
        root.right.left = new TreeNodeConnect(6);
        root.right.right = new TreeNodeConnect(7);

        binaryTreeLevelOrderConnect.connectLevels(root);
    }
}
