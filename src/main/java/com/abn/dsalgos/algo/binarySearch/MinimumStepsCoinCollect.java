package com.abn.dsalgos.algo.binarySearch;

/*
find the minimum number of steps it takes to collect the coins given an array of the heights of vertically stacks of coins.
(minimum number of straight lines that pass through all the coins)
In one step you can collect either one horizontal or one vertical line of coins, and collected coins should be continuous.

[3, 1, 1, 5, 1]

o/p = 3

First horizontally collect min height coins, ie 1 from each height. Then left out is 2 vertical stacks for 2 coin and 4 coin
Total 3 steps.
 */
public class MinimumStepsCoinCollect {

    public int minimumSteps(int[] array, int h) {

        return minimumStepsHelper(0, h, 0, array);
    }

    private int minimumStepsHelper(int start, int end, int height, int[] array) {

        if (start >= end) {
            return 0;
        }

        int min = start;

        for (int i = start; i < end; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }

        int left = minimumStepsHelper(start, min, array[min], array);
        int right = minimumStepsHelper(min + 1, end, array[min], array);
        int horizontal = array[min] - height;

        return Math.min(end - start, left + right + horizontal);
    }

    public static void main(String[] args) {
        MinimumStepsCoinCollect minimumStepsCoinCollect = new MinimumStepsCoinCollect();
        int[] array = {3, 1, 1, 5, 1};
        System.out.println(minimumStepsCoinCollect.minimumSteps(array, array.length));
    }


}
