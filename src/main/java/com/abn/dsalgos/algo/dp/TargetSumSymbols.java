package com.abn.dsalgos.algo.dp;

/*
Given a set of positive numbers (non zero) and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’ sign.
We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.

Input: {1, 1, 2, 3}, S=1
Output: 3
Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
 */
public class TargetSumSymbols {

    public static void main(String[] args) {
        TargetSumSymbols targetSumSymbols = new TargetSumSymbols();
        System.out.println(targetSumSymbols.targetSum(new int[] {1, 2, 7, 1}, 9));
    }

    public int targetSum(int[] array, int target) {

        return sumHelper(array, 0, 0, target);
    }

    /*
    Approach 2:
    {+1-1-2+3} => {1, 3} - {1, 2}
    S1 - S2 = S
    S1 + S2 = SUM

    2S1 = S + SUM
    S1 = (S+SUM)/2

    Input: {1, 1, 2, 3}, S=1
    => (1 + 7)/2 = 4

    So question => "find the count of subsets whose sum is equal 4"

    Refer to  : src/main/java/com/abn/dsalgos/algo/dp/CountOfSubsetSum.java

     */

    private int sumHelper(int[] array, int sum, int index, int target) {

        if (index == array.length && (sum == target)) {
            return 1;
        } else if (index == array.length) {
            return 0;
        }

        int count = 0;

        count = sumHelper(array, sum + array[index], index + 1, target) +
                sumHelper(array, sum - array[index], index + 1, target);

        return count;
    }
}
