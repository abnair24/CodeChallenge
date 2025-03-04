package com.abn.scalar.dsa.day47;


import java.util.ArrayList;
import java.util.List;

/*
Given a positive integer A.

Return the number of ways it can be written as a sum of consecutive positive integers.


=================Approach===========================

Lets A be the target sum

A = x + (x+1) + (x+2) + (x+3) + ......... + (x+k-1)
  = kx + [1 + 2+ 3+ ......... + k-1]
  = kx + k*(k-1)/2

x = [A - k(k-1)/2]/k

eg: A = 15
k = 1 => x = 15
k = 2 = > x = 1/2 (not possible)
k = 3 => x = 4 (4, 5, 6)
k = 4 => x = 9/4 (not possible)
k = 5 => x = 1 (1, 2, 3, 4 ,5)
k = 6 => x = 0

so condition  to check : [A - k(k-1)/2] % k == 0 (to be valid whole number)

and A - k(k-1)/2 > 0
  => A > k(k-1)/2
  => 2A > k(k-1) ==> (k-1)(k-1)  [k(k-1) valid means (k-1)(k-1) also valid)
  => k-1 < sqrt(2A)
  -> k < 1+sqrt(2A)
  ~  k < sqrt(2A) [ Iteration limit]
 */
public class ConsecutiveNumberSum {

    public int solve(int A) {

        int count = 0;
        for(int i = 1; i < Math.sqrt(2 * A); i++) {
            int T = A - (i* (i-1))/2;
            if(T % i == 0) {
                count ++;
            }
        }
        return count;
    }

    public List<List<Integer>> consecutiveNumbers(int A) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 1; i < Math.sqrt(2 * A); i++) {
            List<Integer> array = new ArrayList<>();
            int T = A - (i* (i-1))/2;
            if(T % i == 0) {

                int k = T /i;
                int sum = k;
                array.add(k);

                while(sum != A) {
                    sum = sum + (k+1);
                    k++;
                    array.add(k);
                }
                result.add(array);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConsecutiveNumberSum consecutiveNumberSum = new ConsecutiveNumberSum();
        System.out.println(consecutiveNumberSum.solve(20));
        System.out.println(consecutiveNumberSum.consecutiveNumbers(15));
    }
}
