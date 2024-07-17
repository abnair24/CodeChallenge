package com.abn.dsalgos.glc;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithEquals1and0 {

    /*
    given an array of integers consisting of only 0s and 1s. Your task is to find the length
    of the largest subarray that contains an equal number of 0s and 1s. If multiple such subarrays exist,
    return the length of the first one encountered.

    Example:
    Input: [0, 1, 0, 1, 1, 0, 0]
    Output: 6
    Explanation: The subarray [1, 0, 1, 1, 0, 0] has an equal number of 0s and 1s, and
    it is the largest subarray with this property.

    Constraints:
    The length of the array is between 1 and 10^5.
    Each element in the array is either 0 or 1.
     */

    public int maxLen(int[] numbers) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i< numbers.length; i++) {

            sum = (sum + numbers[i]) == 0 ? -1 : 1;

            if(map.containsKey(sum)) {

                maxLen = Math.max(maxLen, i -  map.get(sum));

            } else {
                map.put(sum, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        LargestSubArrayWithEquals1and0 largestSubArrayWithEquals1and0 = new LargestSubArrayWithEquals1and0();

        System.out.println(largestSubArrayWithEquals1and0.maxLen(new int[] {0, 1, 0, 1, 1, 0, 0}));
    }
}
