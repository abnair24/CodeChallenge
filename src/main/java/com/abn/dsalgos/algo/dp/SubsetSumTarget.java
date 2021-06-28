package com.abn.dsalgos.algo.dp;

public class SubsetSumTarget {

    public static final int TARGET = 10;

    public static void main(String[] args) {
        SubsetSumTarget subsetSum = new SubsetSumTarget();
        System.out.println(subsetSum.minimumSubsetSumDiff
                (new int[] {7, 3, 8}));
    }

    public int minimumSubsetSumDiff(int[] array) {

        return minimum(array, 0, 0);
    }

    private int minimum(int[] array, int index, int sum1) {

        int count = 0;
        if (index < array.length && sum1 >= TARGET) {
            return 0;
        }
        if (index == array.length) {
            System.out.println("sum1: " + sum1);
            if (sum1 == TARGET) {
                count++;
            }

            return count;
        }

        int leftSum = minimum(array, index + 1, sum1 + array[index]);

        int rightSum = minimum(array, index + 1, sum1);

        return leftSum + rightSum;
    }
}
