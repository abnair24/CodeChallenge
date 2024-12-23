package com.abn.scalar.dsa.day18;

import java.util.HashMap;
import java.util.Map;

/*
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the
array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Note: Read-only array means that the input array should not be modified in the process of solving the problem

[1 2 3 1 1]
o/p: 1

[1 2 3]
o/p: -1

 */

public class RepeatNumber {

    public int repeatedNumber(int[] A) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        int threshold = A.length / 3;

        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            int freq = freqMap.getOrDefault(number, 0);
            if (freq > maxFreq) {
                maxNum = number;
                maxFreq = freq + 1;
                if (maxFreq >= threshold) {
                    return maxNum;
                }
            }
            freqMap.put(number, freq + 1);
        }
        return -1;
    }
}