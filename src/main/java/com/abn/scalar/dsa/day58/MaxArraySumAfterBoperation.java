package com.abn.scalar.dsa.day58;

import java.util.PriorityQueue;


/*
Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

 A = [24, -68, -29, -9, 84]
 B = 4

 o/p: 196

Approach:
If the minimum element is x < 0, then just change it to -x.
If the minimum element is x > 0 and the number of operations left is even. You do not need to change anything.
If the minimum element is x > 0 and the number of operations left is odd. We can directly change the number of
 operations left to 0 and set x to -x.
 */

public class MaxArraySumAfterBoperation {

    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxSum = 0;

        for(int i = 0; i < A.length; i++) {
            pq.add(A[i]);
        }

        while(B > 0) {
            int min = pq.poll();

            if(min == 0) {
                B = 0;
            } else if(min < 0) {
                min = min * -1;
                pq.offer(min);
            } else {
                if(B %2 == 0) {
                    pq.offer(min);
                } else {
                    pq.offer(-min);
                }
                B = 0;
                break;
            }
            B--;
        }

        while(!pq.isEmpty()) {
            maxSum += pq.poll();
        }

        return maxSum;
    }

    public static void main(String[] args) {

        MaxArraySumAfterBoperation maxSum = new MaxArraySumAfterBoperation();
      //  System.out.println(maxSum.solve(new int[] {24, -68, -29, -9, 84}, 4));
      //  System.out.println(maxSum.solve(new int[] {57, 3, -14, -87, 42, 38, 31, -7, -28, -61}, 10));
       // System.out.println(maxSum.solve(new int[] {-43, -1, 19, 87, -45}, 5));
//        System.out.println(maxSum.solve(new int[] {-50,59,-80,-93,-51,-43,-35,-93,-2,10,18,46,68,-56,-7,-56,-54,-37,-57,-27,0,91,-40,87,88,45,11}, 7325));
        System.out.println(maxSum.solve(new int[] {93,-8,-6,-88,40,-36,12,24,96,80,21,-53,83,98,-93,-37,50,94,0,-18,55,-88,90,56,-93,14,-33,56,45,-78,84,-40,-57,35,-20,31,-12,-86,39,2,17,-100,-9,-81,3,46,-66,91,29,91,-12,11,28,46,-46,17,-29,-29,-89,9,75,-91,77,29,34,-92,59,-41,61,48,-59,-89,99,-67,-81,25,-88,-24,-58,-17,78,93,-89,93,51,64,-31,16,-58,-84,-43,58,-93}, 12247));
    }
}
