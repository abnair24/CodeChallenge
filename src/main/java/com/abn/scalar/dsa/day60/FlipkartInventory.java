package com.abn.scalar.dsa.day60;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management.
 Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays,
 A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin
 for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.

The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date,
thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and enhance profitability?

Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery
item at a time.

NOTE:

You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current
time <= A[i] - 1.
You can start buying from day = 0.
Return your answer modulo 109 + 7.
 */


public class FlipkartInventory {

    public int solve(int[] A, int[] B){
        final int MOD = 1_000_000_007;

        // Combine expiration times and profits into pairs and sort by expiration time

        Pair[] pairs = new Pair[A.length];
        for(int i = 0; i < A.length; i++) {

            pairs[i] = new Pair(A[i], B[i]);
        }

        /*
            Custom comparator to sort on expiration time, if expiry is same, sort on profit in descending order.
         */
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.expiry == o2.expiry) {
                    return Integer.compare(o2.profit, o1.profit);
                } else {
                    return Integer.compare(o1.expiry, o2.expiry);
                }
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int totalProfit = 0;
        int currentTime = 0;

        for (Pair pair : pairs) {
            int expiry = pair.expiry;
            int profit = pair.profit;

            /*
                If currentTime < expiry, add to heap and increase profit
                Else remove the least profitable item from the heap and add the current item.
             */
            if (currentTime < expiry) {
                minHeap.offer(profit);
                totalProfit += profit;
                currentTime++;
            } else if (!minHeap.isEmpty() && minHeap.peek() < profit) {
                int top = minHeap.poll();
                totalProfit += profit - top;
                minHeap.offer(profit);
            }
            // Ensure totalProfit doesn't exceed MOD
            totalProfit %= MOD;
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        FlipkartInventory flipkartInventory = new FlipkartInventory();
        System.out.println(flipkartInventory.solve(new int[] {3, 2, 1, 4, 5}, new int[]{10, 20, 30, 40, 50}));

    }
}

class Pair {
    int expiry;
    int profit;

    public Pair(int expiry, int profit) {
        this.expiry = expiry;
        this.profit = profit;
    }
}

