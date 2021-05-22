package com.abn.dsalgos.algo.twoPointers;

/*
   A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the
   sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly
   in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

   Return True if n is a happy number, and False if not.

   Input: 19
   Output: true
   Explanation: 1 + 81 = 82
   64 + 4 = 68
   36 + 64 = 100
   1 + 0 + 0 = 1

  Tip: If the number sum doesnt end in 1, then its sum's will follow a cycle

  Ex: 12
  1+ 4 = 5
  5* 5 = 25
  4 + 25 = 29
  4 + 81 = 85
  64 + 25 = 89
  64 + 81 = 145
  1 + 16 + 25 = 42
  16 + 4 = 20
  4 + 0 =4
  4 * 4 = 16
  1+ 36 = 37
  9 + 49 = 58
  25 + 64 = 89


    */
public class HappyNumber {

    public boolean isHappyNumber(int num) {
        int slow = num;
        int fast = num;

        if(num == 0) {
            return false;
        } else if(num == 1) {
            return true;
        } else {
            do {
                slow = findSquareSum(slow);
                fast = findSquareSum(findSquareSum(fast));
            } while (slow != fast);

            return slow == 1;
        }
    }

    private int findSquareSum(int num) {
        int sum = 0;
        int digit;
        while(num > 0) {
            digit = num %10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}
