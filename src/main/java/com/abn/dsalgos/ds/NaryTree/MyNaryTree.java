package com.abn.dsalgos.ds.NaryTree;

import com.abn.dsalgos.utils.NaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyNaryTree {

    List<Integer> result = new ArrayList<>();
    List<List<Integer>> recResult = new ArrayList<>();

    public List<Integer> preOrderIterative(NaryNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<NaryNode> stack = new Stack<>();
        LinkedList<NaryNode> st = new LinkedList<>();

        if(root == null) {
            return list;
        }

        stack.push(root);

        while(!stack.isEmpty()) {
            NaryNode current = stack.pop();
            list.add(current.data);

            for(int i = current.children.size() - 1; i>=0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return list;
    }

    public List<Integer> preOrderRecursion(NaryNode root) {

        if (root == null) {
            return result;
        }

        result.add(root.data);
        for(NaryNode child : root.children) {
            preOrderRecursion(child);
        }

        return result;
    }

    public List<Integer> postOrderRecursion(NaryNode root) {

        if(root == null) {
            return result;
        }

        for(NaryNode child: root.children) {
            postOrderRecursion(child);
        }

        result.add(root.data);

        return result;
    }

    public List<Integer> postOrderIteration(NaryNode root) {

        LinkedList<Integer> output = new LinkedList<>();
        Stack<NaryNode> stack = new Stack<>();
        if (root == null) {
            return output;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            NaryNode node = stack.pop();
            output.addFirst(node.data);
            for (NaryNode item : node.children) {
                if (item != null) {
                    stack.push(item);
                }
            }
        }
        return output;
    }

    public List<List<Integer>> levelOrderIteration(NaryNode root) {

        List<List<Integer>> output = new ArrayList<>();
        Queue<NaryNode> queue = new LinkedList<>();

        if(root == null) {
            return output;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int nodeCount = queue.size();
            while(nodeCount > 0) {

                NaryNode current = queue.remove();
                temp.add(current.data);
                for(NaryNode child : current.children) {
                    queue.add(child);
                }
                nodeCount --;
            }

            output.add(temp);
        }
        return output;
    }
 }
