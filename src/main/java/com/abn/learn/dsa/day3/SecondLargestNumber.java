package com.abn.learn.dsa.day3;

public class SecondLargestNumber {

    public int secondLargest(int[] array) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {

            if(array[i] > largest) {
                secondLargest = largest;
                largest = array[i];
            } else if(array[i] < largest && array[i] > secondLargest) {
                secondLargest = array[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        SecondLargestNumber secondLargestNumber = new SecondLargestNumber();
        System.out.println(secondLargestNumber.secondLargest(new int[] {12, 35, 1, 10, 34, 1, 100}));
    }
}
