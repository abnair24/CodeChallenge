package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;

/*
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 Your score is the sum of the points of the cards you have taken.

 https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12  (1 + 6 + 5 = 12)

Input: cardPoints = [2,2,2], k = 2
Output: 4

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55

Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
Output: 202
 */
public class MaximumScore {

    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int startPtr = len - k;
        int endPtr;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = startPtr; i < len; i++) {
            currentSum += cardPoints[i];
        }

        maxSum = currentSum;
        endPtr = 0;
        while (startPtr < len) {

            currentSum = currentSum - cardPoints[startPtr] + cardPoints[endPtr];
            maxSum = Math.max(currentSum, maxSum);

            startPtr++;
            endPtr++;
        }

        return maxSum;
    }

}
