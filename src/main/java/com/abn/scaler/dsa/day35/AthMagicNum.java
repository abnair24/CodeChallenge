package com.abn.scaler.dsa.day35;

/*
ou are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.

 */
public class AthMagicNum {

    public int solve(int A, int B, int C) {

        long low = 1;
        long high = (long) 1e18;
        long mod = (long) 1e9 + 7;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, B, C) < A) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % mod);
    }

    private long count(long num, long B, long C) {
        return num / B + num / C - num / lcm(B, C);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
