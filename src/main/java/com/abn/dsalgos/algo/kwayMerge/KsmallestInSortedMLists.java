package com.abn.dsalgos.algo.kwayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {

    int elementIndex;
    int arrayIndex;

    public Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class KsmallestInSortedMLists {

    public int findKSmallest(List<int[]> lists, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        for(int i = 0; i < lists.size(); i++) {

            if(lists.get(i) != null) {
                minHeap.add(new Node(0, i));
            }
        }

        int count = 0;
        int result = 0;

        while(!minHeap.isEmpty()) {

            Node temp = minHeap.poll();
            if(++count == k) {
                result = lists.get(temp.arrayIndex)[temp.elementIndex];
                break;
            }

            temp.elementIndex ++;
            if(lists.get(temp.arrayIndex).length > temp.elementIndex)  {
                minHeap.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] list1 = new int[] {1, 2, 4, 6};
        int[] list2 = new int[] {0, 3, 4, 5};
        int[] list3 = new int[] {3, 7};

        List<int[]> l = new ArrayList<>();
        l.add(list1);
        l.add(list2);
        l.add(list3);

        System.out.println(new KsmallestInSortedMLists().findKSmallest(l, 5));
    }
}
