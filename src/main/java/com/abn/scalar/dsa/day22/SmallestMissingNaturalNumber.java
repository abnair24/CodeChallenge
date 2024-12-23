package com.abn.scalar.dsa.day22;

/*
Given unsorted away of integers find first missing
Natural no
 */
public class SmallestMissingNaturalNumber {

    public int solve(int[] array) {

        int i = 0;
        while(i < array.length) {

            if(array[i] > 0 && array[i] <= array.length && array[i] !=  array[array[i] - 1]) {
                int j = array[i] - 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else {
                i++;
            }
        }

        for(int k = 0; k < array.length; k++) {
            if(array[k] != k+1) {
                return k + 1;
            }
        }
        return array.length + 1;
    }

    public static void main(String[] args) {

        SmallestMissingNaturalNumber smmallestMissingNaturalNumber = new SmallestMissingNaturalNumber();
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {-3, 2, 4, 5}));
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {10, 9, 7, 11, 5, 1}));
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {-3, 1, 5, 4, 2}));
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {-1, -3, 1}));
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {1, 2, 3}));
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {1, 3, 6, 4, 8, 2}));
        System.out.println(smmallestMissingNaturalNumber.solve(new int[] {-1, -3, -6, -4, -8, -2}));
    }
}
