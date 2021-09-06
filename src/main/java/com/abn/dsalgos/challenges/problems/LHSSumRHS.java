package com.abn.dsalgos.challenges.problems;


import java.util.Arrays;

/*
Given, an array of size n. Find an element which divides the array in two sub-arrays with equal sum.


 */
public class LHSSumRHS {

    public static void main(String[] args) {

        int[] array = {-1, 3, 0, 1, 4, -3};

        LHSSumRHS lhsSumRHS = new LHSSumRHS();
        System.out.println(lhsSumRHS.findElement(array));
    }

    public int findElement(int[] array) {

        int rsum;
        int lsum = 0;

        rsum = Arrays.stream(array, 1, array.length).sum();

        for (int i = 0, j = 1; j < array.length; i++, j++) {
            rsum = rsum - array[j];
            lsum = lsum + array[i];

            if (lsum == rsum) {
                return array[j];
            }
        }
        return -1;
    }
}
