package com.abn.scalar.dsa.day8;

/*
Given an array of size N, return the length of smallest subarray which contains both min and max element of the array.

i/p : [1, 2, 3, 1, 1, 3, 4, 6, 4, 6, 3]

o/p: 4 [1, 3, 4, 6]

i/p: [2 2 6 4 5 1 5 2 6 4 1]
o/p:  3 [6 4 1]
 */
public class SmallestSubarrayWithMaxMin {

    public int solve(int[] array) {

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        int minIndex = -1;
        int maxIndex = -1;

        int len = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++) {

            if(array[i] < minValue) {
                minValue = array[i];
            } if(array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        if(minValue == maxValue) {
            return 1;
        }

        for(int i = 0; i < array.length; i++) {

            if(array[i] == minValue) {
                if(maxIndex != -1) {
                    len = Math.min(len, i-maxIndex+1);
                }
                minIndex = i;
            } else if(array[i] == maxValue) {
                if(minIndex != -1) {
                    len = Math.min(len, i-minIndex + 1);
                }
                maxIndex = i;
            }
        }

        return len;
    }

    public static void main(String[] args) {

        SmallestSubarrayWithMaxMin smallestSubarrayWithMaxMin = new SmallestSubarrayWithMaxMin();

      //  System.out.println(smallestSubarrayWithMaxMin.solve(new int[] {1, 2, 3, 1, 1, 3, 4, 6, 4, 6, 3}));
       // System.out.println(smallestSubarrayWithMaxMin.solve(new int[] {834, 563, 606, 221, 165}));
        System.out.println(smallestSubarrayWithMaxMin.solve(new int[] {4, 4, 4, 4, 4}));
    }
}
