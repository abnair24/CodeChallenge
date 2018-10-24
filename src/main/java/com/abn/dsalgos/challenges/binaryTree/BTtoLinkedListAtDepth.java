package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.challenges.queue.QueueWithTwoStacks;
import com.abn.dsalgos.utils.MyTreeNode;
import sun.awt.image.ImageWatched;

import java.util.*;

public class BTtoLinkedListAtDepth {

    public MyTreeNode root;
    List<LinkedList<MyTreeNode>> arrayList = new ArrayList<>();

    public BTtoLinkedListAtDepth() {
        root = null;
    }


    public void linkedListAtDept(MyTreeNode node) {
        if(node == null) {
            return;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            int nodesCount = queue.size();
            LinkedList<MyTreeNode> linkedList = new LinkedList<>();

            while(nodesCount >0) {
                MyTreeNode temp = queue.poll();

                linkedList.add(temp);

                if(temp.left!=null) {
                    queue.add(temp.left);
                }

                if(temp.right!=null) {
                    queue.add(temp.right);
                }

                nodesCount--;
            }
            arrayList.add(linkedList);
        }
        displayArrayList(arrayList);
    }

    private void displayArrayList(List<LinkedList<MyTreeNode>> array) {
        Iterator iterator = array.iterator();
        while(iterator.hasNext()) {
            LinkedList list = (LinkedList) iterator.next();
            while(!list.isEmpty()) {
                 MyTreeNode node = (MyTreeNode) list.pollFirst();
                System.out.print(" -> "+ node.data);

            }
            System.out.println();
        }
    }

    /*
    Better approach without using queue
    Instead of queue, create a temp linked list to store nodes at each level.
     */

    public void binaryTreeLinkedList(MyTreeNode node) {

        List<LinkedList<MyTreeNode>>lists = new ArrayList<>();

        LinkedList<MyTreeNode> linkedList = new LinkedList<>();

        if(node != null) {
            linkedList.add(node);
        }

        while(linkedList.size() > 0) {
            lists.add(linkedList);

            LinkedList<MyTreeNode> temp = linkedList;

            linkedList = new LinkedList<>();

            for(MyTreeNode t : temp) {
                if(t.left != null) {
                    linkedList.add(t.left);
                }

                if(t.right != null) {
                    linkedList.add(t.right);
                }
            }
        }

        displayArrayList(lists);
    }
}
