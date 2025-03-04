package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderBT {

    public ArrayList<Integer> postorderTraversal(TreeNode node) {
        TreeNode temp = null;;
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

            while (!stack.isEmpty() && (stack.peek().right == null || stack.peek().right == temp)) {
                temp = stack.pop();
                list.add(temp.val);
            }
            if (!stack.isEmpty()) {
                node = stack.peek().right;
            }
        }
    }
}
