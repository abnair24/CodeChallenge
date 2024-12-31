package com.abn.scalar.dsa.day34;

/*
Given a sorted array of N elements, find the first occurrence of the target element.

array = {-5, -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 8, 10, 10, 10, 15, 15}
target = 5

output = 8

 */
public class FirstOccurance {

    public int solve(int[] array, int target) {
        int high = array.length - 1;
        int low = 0;
        int mid;
        int ans = -1;

        while(low <= high) {
            mid = (low + (high - low)/ 2);

            if(array[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if(array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        FirstOccurance firstOccurance = new FirstOccurance();
        System.out.println(firstOccurance.solve(new int[] {-5, -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 8, 10, 10, 10, 15, 15}, -5));
        System.out.println(firstOccurance.solve(new int[] {-5, -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 8, 10, 10, 10, 15, 15}, 5));
        System.out.println(firstOccurance.solve(new int[] {-5, -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 8, 10, 10, 10, 15, 15}, 15));
        System.out.println(firstOccurance.solve(new int[] {-5, -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 8, 10, 10, 10, 15, 15}, 8));
        System.out.println(firstOccurance.solve(new int[] {-5, -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 8, 10, 10, 10, 15, 15}, 11));
    }
}
