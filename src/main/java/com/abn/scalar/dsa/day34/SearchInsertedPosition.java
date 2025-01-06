package com.abn.scalar.dsa.day34;

/*
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present,
return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).

Input 1:

A = [1, 3, 5, 6]
B = 5
Input 2:

A = [1, 4, 9]
B = 3

Example Output

Output 1:
2
Output 2:
1

 */
public class SearchInsertedPosition {

    public int solve(int[] array, int k) {
        
        int low = 0;
        int high = array.length - 1;
        int mid;
        int ans = -1;

        while(low <= high) {
            mid = (low + (high - low)/ 2);

            if(array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                high = mid - 1;
                if(high < 0) {
                    ans = 0;
                }
            } else {
                low = mid + 1;
                ans = low;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        SearchInsertedPosition searchInsertedPosition = new SearchInsertedPosition();
        System.out.println(searchInsertedPosition.solve(new int[] {1, 4, 7, 9, 12, 15}, 4));
        System.out.println(searchInsertedPosition.solve(new int[] {1, 4, 7, 9, 12, 15}, 6));
        System.out.println(searchInsertedPosition.solve(new int[] {1, 4, 7, 9, 12, 15}, 16));
        System.out.println(searchInsertedPosition.solve(new int[] {2, 4, 7, 9, 12, 15}, 1));
    }
}
