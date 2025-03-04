package com.abn.scalar.dsa.day48Lab;

/*
Given an array of integers A, find and return the count of divisors of each element of the array.







NOTE: The order of the resultant array should be the same as the input array.










Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format

The only argument given is the integer array A.



Output Format

Return the count of divisors of each element of the array in the form of an array.



Example Input

Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output

Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]
 */
import java.util.Arrays;

public class CountOfDivisors {

    public int[] solve(int[] A) {

        int max = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }

        int[] result = new int[max + 1];

        for(int i = 1; i <= max; i++) {
            for(int j = i; j <= max; j+=i) {
                result[j] ++;
            }
        }

        for(int i = 0; i<A.length; i++) {
            A[i] = result[A[i]];
        }

        return A;
    }

    public static void main(String[] args) {

        CountOfDivisors countOfDivisors = new CountOfDivisors();
        System.out.println(Arrays.toString(countOfDivisors.solve(new int[] { 3, 2, 8, 1, 10, 14, 9, 6})));
    }
}
