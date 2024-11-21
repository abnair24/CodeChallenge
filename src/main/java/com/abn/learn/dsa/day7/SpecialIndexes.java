package com.abn.learn.dsa.day7;

/*
Given an array of size N count no of special indices in the array
Special indices where sum of all even index elements equal to sum of all even indexed on removing current index

A = [2, 1, 6, 4]

o/p: 1
A = [1, 1, 1]

o/P: 3

 */
public class SpecialIndexes {

    public int specialIndex(int[] array) {

        int[] prefixEven = new int[array.length];
        int[] prefixOdd = new int[array.length];

        prefixOdd[0] = 0;
        prefixEven[0] = array[0];

        for(int i = 1; i < array.length; i++) {

            if(i % 2 == 0) {
                prefixEven[i] = prefixEven[i - 1] + array[i];
                prefixOdd[i] = prefixOdd[i -1];
            } else {
                prefixOdd[i] = prefixOdd[i - 1] + array[i];
                prefixEven[i] = prefixEven[i - 1];
            }
        }

        int count = 0;

        for(int i = 0; i < array.length; i ++) {
            int sumEven = 0;
            int sumOdd = 0;
            if(i == 0) {
                // for start index remaing odd index sum for evensum
                sumEven = prefixOdd[array.length - 1] - prefixOdd[i];

                // for start index remaing even index sum for oddsum
                sumOdd = prefixEven[array.length - 1] - prefixEven[i];
            } else {
                          // sum of even indices before i // sum of odd indices after i [i+1, n-1]
                sumEven = prefixEven[i - 1] + prefixOdd[array.length - 1] - prefixOdd[i];
                          // sum of odd indices before i // sum of even indices after i [i+1, n-1]
                sumOdd = prefixOdd[i - 1] + prefixEven[array.length - 1] - prefixEven[i];
            }

            if(sumEven == sumOdd) {
                count ++;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        SpecialIndexes specialIndexes = new SpecialIndexes();
        System.out.println(specialIndexes.specialIndex(new int[] {2,1,6,4}));
        System.out.println(specialIndexes.specialIndex(new int[] {1,1,1}));
    }
}
