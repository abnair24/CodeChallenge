package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.challenges.queue.QueueWithTwoStacks;
import com.abn.dsalgos.utils.MyTreeNode;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BTtoLinkedListAtDepth {

    public MyTreeNode root;
    ArrayList<LinkedList<MyTreeNode>> arrayList = new ArrayList<>();

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

    private void displayArrayList(ArrayList<LinkedList<MyTreeNode>> array) {
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
}
