package com.abn.dsalgos.algo.heap;

import java.util.PriorityQueue;

/*
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.

Input: [1, 3, 11, 5]
Output: 33

 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)

 Greedy approach using minheap.

 Eg: (a1, a2, a3, a4)
 1. a1 + a2, a3, a4 => cost = a1 + a2
 2. (a1 + a2 + a3), a4 => (a1 + a2) + (a1+a2+a3)
 3. (a1 + a2 + a3 + a4) => (a1 + a2) + (a1+a2+a3) + (a1 + a2+ a3+a4)
 total  = 3a1 + 3a2 + 2a3 + a4.

 so sticks connected first are included more times in final cost. So its good to choose smaller stick first and bigger ones later.
 */
public class ConnectRopes {

    public int connect(int[] sticks) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++) {
            minHeap.add(sticks[i]);
        }

        int total = 0;
        while (minHeap.size() > 1) {
            int cost1 = minHeap.remove();
            int cost2 = minHeap.remove();

            total = total + cost1 + cost2;

            minHeap.add(cost1 + cost2);

        }
        return total;
    }
}
