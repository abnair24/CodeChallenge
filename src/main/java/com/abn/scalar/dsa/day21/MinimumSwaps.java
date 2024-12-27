package com.abn.scalar.dsa.day21;

/*

Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring
all the numbers less than or equal to B together. (NOTE: Together doesnt mean to be in the beginning of array, numbers can be togeher at any part of array)

Note: It is possible to swap any two elements, not necessarily consecutive.

 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
 o/p:  2


 A = [5, 17, 100, 11]
 B = 20
 o/p: 1

 Approach:
First, count the number of elements <= B. Let the count comes out to be X.

Create a window of first X elements. To find the number of swaps to bring all elements <= B together in the first window,
you just need to find count of elements > B in first window.
So, count of swaps required in 1 window = count of elements greater than B in that window.

For every window, find the count of elements greater than B, using sliding window technique.


 */
public class MinimumSwaps {

    public int solve(int[] array, int target) {

        int len = array.length;
        int leftPtr = 0;
        int rightPtr = 0;
        int count = 0;
        int countLessThanTarget = 0;
        int max;

        for(int n : array) {
            if(n <= target) {
                countLessThanTarget++;
            }
        }

        if(countLessThanTarget <= 1) {
            return 0;
        } else {

            while(rightPtr < countLessThanTarget) {
                if(array[rightPtr] > target) {
                    count ++;
                }
                rightPtr ++;
            }
            max = count;
            while (rightPtr < len) {
                if(array[rightPtr] > target) {
                    count ++;
                }
                if(array[leftPtr] > target) {
                    count --;
                }
                max = Math.min(max, count);
                rightPtr ++;
                leftPtr ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        MinimumSwaps minimumSwaps = new MinimumSwaps();
        System.out.println(minimumSwaps.solve(new int[] {52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70}, 19));
        System.out.println(minimumSwaps.solve(new int[] {1, 12, 10, 3, 14, 10, 5}, 8));
    }
}
