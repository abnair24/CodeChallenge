package com.abn.scalar.dsa.day68;

/*
Rishik likes candies a lot. So, he went to a candy-shop to buy candies.

The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles,
each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik
can buy as many complete candy-packets as he wants but he can't buy a part of the packet.

Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?

First argument of input is an integer array A
Second argument of input is an integer array B
Third argument of input is an integer array C
Fourth argument of input is an integer D

 A = [1, 2, 3]
 B = [2, 2, 10]
 C = [2, 3, 9]
 D = 8
P0: Zero Packet
P1: 1 packet
P2: 2nd packet
P3: 3rd packet
Maximize Sweetness = each packet * no of candies in that packet * sweetness of each candy. Value in table is max sweetness for each cost

  cost |   0   1   2   3   4   5   6   7   8
=======|===========================================
P0:    |   0   0   0   0   0   0   0   0   0
P1:    |   0   0   2   2   4   4   6   6   8
P2:    |   0   0   2   4   4   6   8   8  10
P3:    |   0   0   2   4   4   6   8   8  10
 */

public class BuyingCandies {

    public int solve(int[] packets, int[] sweetness, int[] cost, int maxCost) {

        int[][] dp = new int[packets.length + 1][maxCost + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= packets.length; i++) {
            for(int w = 1; w <= maxCost; w++) {
                dp[i][w] = dp[i-1][w];

                int totalSweetness = packets[i - 1] * sweetness[i - 1];
                if(cost[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i][w - cost[i - 1]] + totalSweetness);
                }
            }
        }
        return dp[packets.length][maxCost];
    }

    public static void main(String[] args) {
        BuyingCandies buyingCandies = new BuyingCandies();
        System.out.println(buyingCandies.solve(new int[] {1, 2, 3}, new int[] {2, 2, 10}, new int[] {2, 3, 9}, 8));
    }
}
