package com.abn.dsalgos.algo.dp;

import java.util.HashMap;
import java.util.Map;

/*
given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before
each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
 */

public class TargetSumExpression {

    public int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> cache = new HashMap<>();
        return dpHelper(nums, 0, target, 0, cache);
    }

    private int dpHelper(int[] array, int index, int target, int currentSum, Map<String, Integer> cache) {

        if (index == array.length && currentSum == target) {
            return 1;
        }

        if (index == array.length) {
            return 0;
        }
        String key = index + "-" + currentSum;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int count1 = dpHelper(array, index + 1, target,
                currentSum + array[index], cache);

        int count2 = dpHelper(array, index + 1,
                target, currentSum - array[index], cache);

        cache.put(key, (count1 + count2));
        return cache.get(key);
    }

    public static void main(String[] args) {
        TargetSumExpression targetSumExpression = new TargetSumExpression();
        System.out.println(targetSumExpression.findTargetSumWays(new int[] {1, 1, 1, 1}, 2));
    }
}
