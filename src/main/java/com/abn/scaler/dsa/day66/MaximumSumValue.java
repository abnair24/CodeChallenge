package com.abn.scaler.dsa.day66;

/*
You are given an array A of N integers and three integers B, C, and D.

You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
First argument is an array A
Second argument is an integer B
Third argument is an integer C
Fourth argument is an integer D



Output Format

Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.



Example Input

Input 1:

 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1
Input 2:

 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3


Example Output

Output 1:

 18
Output 2:

 -4

 */
public class MaximumSumValue {

    public int solve(int[] A,int B, int C, int D) {

        int[] dpB = new int[A.length];
        int[] dpC= new int[A.length];
        int[] dpD = new int[A.length];

        dpB[0] = A[0] * B;
        dpC[0] = dpB[0] + A[0] * C;
        dpD[0] = dpC[0] + A[0] * D;

        for(int i = 1; i < A.length; i++) {
            dpB[i] = Math.max(dpB[i-1], A[i] * B);
            dpC[i] = Math.max(dpC[i-1], dpB[i] + A[i] * C);
            dpD[i] = Math.max(dpD[i-1], dpC[i] + A[i] * D);
        }

        return dpD[A.length - 1];
    }

    public static void main(String[] args) {
        MaximumSumValue maximumSumValue = new MaximumSumValue();
        System.out.println(maximumSumValue.solve(new int[] {-21, 34, 3, 46, 8,-47, -47}, -13, 10, 9));
    }
}
