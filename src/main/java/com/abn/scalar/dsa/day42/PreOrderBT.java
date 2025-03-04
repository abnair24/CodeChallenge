package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderBT {

    public ArrayList<Integer> preorderTraversal(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                return list;
            }

            node = stack.pop();
            node = node.right;
        }
    }
}
