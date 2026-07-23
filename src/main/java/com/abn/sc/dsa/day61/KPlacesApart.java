package com.abn.sc.dsa.day61;

import java.util.PriorityQueue;

/*
N people having different priorities are standing in a queue.
The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).

Input Format

The first argument is an integer array A representing the priorities and initial order of N persons.
The second argument is an integer B.

Output Format

Return an integer array representing the sorted queue.

Example Input

Input 1:

 A = [1, 40, 2, 3]
 B = 2
Input 2:

 A = [2, 1, 17, 10, 21, 95]
 B = 1

 Example Output

Output 1:
[1, 2, 3, 40]
Output 2:
[1, 2, 10, 17, 21, 95]

Explanation
 */
public class KPlacesApart {

    public int[] solve(int[] queue, int B) {

        if (queue == null || queue.length <= 1) {
            return queue;
        }

        int n = queue.length;
        int[] result = new int[n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;

        for (int j = 0; j < Math.min(B + 1, n); j++) {
            minHeap.offer(queue[j]);
        }

        for (int pos = 0; pos < n; pos++) {
            result[pos] = minHeap.poll();

            if (B + 1 + pos < n) {
                minHeap.offer(queue[B + 1 + pos]);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        KPlacesApart kPlacesApart = new KPlacesApart();
        int[] result = kPlacesApart.solve(new int[] {1, 40, 2, 3}, 2);
        for(int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        result = kPlacesApart.solve(new int[] {2, 1, 17, 10, 21, 95}, 1);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
