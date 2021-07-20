package com.abn.dsalgos.algo.dp;

/*
Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step.
Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step). At every step,
you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
 */
public class MinimumStepsFee {

    public int minimumSteps(int[] array) {

        int[] cache = new int[array.length];
        return minimumStepsHelper(array, 0, 0, cache);
    }

    private int minimumStepsHelper(int[] array, int index, int cost, int[] cache) {


        if(index >= array.length-1) {
            return 0;
        }

        if(cache[index] != 0) {
            return cache[index];
        }

        int countOneCost = minimumStepsHelper(array, index + 1, array[index], cache);

        int countTwoCost = minimumStepsHelper(array, index + 2, array[index], cache);

        int countThreeCost = minimumStepsHelper(array, index + 3, array[index], cache);

        int min = Math.min(Math.min(countOneCost, countTwoCost), countThreeCost);

        cache[index] = min + array[index];
        return cache[index];
    }

    public static void main(String[] args) {

        MinimumStepsFee minimumStepsFee = new MinimumStepsFee();
        System.out.println(minimumStepsFee.minimumSteps(new int[] {1, 2, 5, 2, 1, 2}));
    }
}
