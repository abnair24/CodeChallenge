package com.abn.dsalgos.leetcode30Day;

/*
We're provided a positive integer num.
Can you write a method to repeatedly add all of its digits until the result has only one digit?
// start with 49
4 + 9 = 13

// since the previous addition was 13,
// move onto summing 13's digits
1 + 3 = 4

 */
public class SumOfDigitsToOne {

    public int sumOfDigits(int input) {

        int sum = 0;

        while(input > 0 || sum > 9) {

            if(input == 0) {
                input = sum;
                sum = 0;
            }

            int temp = input % 10;
            sum += temp;
            input /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        SumOfDigitsToOne sumOfDigitsToOne = new SumOfDigitsToOne();
        System.out.println(sumOfDigitsToOne.sumOfDigits(49));
        System.out.println(sumOfDigitsToOne.sumOfDigits(439));
    }
}
