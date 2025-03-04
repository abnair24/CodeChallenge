package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderBT {

    public ArrayList<Integer> inorderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                return list;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
    }
}
