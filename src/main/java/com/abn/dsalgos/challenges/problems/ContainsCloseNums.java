package  com.abn.dsalgos.challenges.problems;

import java.util.HashMap;
/*
Given an array of integers nums and an integer k, determine whether there are
 two distinct indices i and j in the array where nums[i] = nums[j] and the absolute
  difference between i and j is less than or equal to k.

Example

For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
containsCloseNums(nums, k) = true.

There are two 2s in nums, and the absolute difference between their positions is exactly 3.

For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be
containsCloseNums(nums, k) = false.


 */

public class ContainsCloseNums {

    public static void main(String[] args) {

        int[] num = {1,0,1,1};
        System.out.println(containsCloseNums(num,1));
    }

    public static boolean containsCloseNums(int[] nums,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if(map.get(nums[i])==null) {
                map.put(nums[i],i);
            } else {
                int j = map.get(nums[i]);
                if(Math.abs(j-i)<=k){
                    return true;
                } else {
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
