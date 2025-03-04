package com.abn.scalar.dsa.day35;

/*
Imagine you're working on a mathematical problem or a scientific
simulation that requires the square root of a number. Calculating square
roots manually can be time-consuming, and a reliable and fast method
is needed. Binary Search provides an elegant way to approximate
square roots efficiently.
 */
public class SquareRootOfNumber {

    public int solve(int N) {
        if(N == 0 || N == 1) {
            return N;
        }

        int low = 1;
        int high = N;
        long result = 0;
        long mid;

        while(low <= high) {
            mid = low + (high - low)/ 2;
            long square = mid * mid;

            if(square == N) {
                return (int) mid;
            }else if(square < N) {
                low = (int) mid + 1;
                result = mid;
            } else {
                high =(int) mid - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        SquareRootOfNumber squareRootOfNumber = new SquareRootOfNumber();
        System.out.println(squareRootOfNumber.solve(20));
    }
}
