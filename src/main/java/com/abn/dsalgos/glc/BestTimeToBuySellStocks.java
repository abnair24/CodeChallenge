package com.abn.dsalgos.glc;

import org.testng.Assert;

/*
   Design an algorithm to find the maximum profit. You may complete
   as many transactions as you like (i.e., buy one and sell one share
   of the stock multiple times).

   Note: You may not engage in multiple transactions at the same time
   (i.e., you must sell the stock before you buy again).

   Input: [7,1,5,3,6,4]
   Output: 7
   Explanation:

   Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
   Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

   Input: [1,2,3,4,5]
   Output: 4
   Explanation:

   Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
   Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
   engaging multiple transactions at the same time. You must sell before buying again.

   Input: [7,6,4,3,1]
   Output: 0
   Explanation: In this case, no transaction is done, i.e. max profit = 0.


   Kadane's algo

    */
public class BestTimeToBuySellStocks {

    public int maxProfit(int[] array) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++) {

            if(array[i] < minPrice) {
                minPrice = array[i];
            } else if(array[i] - minPrice > maxProfit) {
                maxProfit = array[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        BestTimeToBuySellStocks bestTimeToBuySellStocks = new BestTimeToBuySellStocks();
        Assert.assertEquals(bestTimeToBuySellStocks.maxProfit(new int[] { 7, 1, 5, 3, 6, 4}), 5);
        Assert.assertEquals(bestTimeToBuySellStocks.maxProfit(new int[] {7, 6, 4, 3, 1}), 0);
    }


}
