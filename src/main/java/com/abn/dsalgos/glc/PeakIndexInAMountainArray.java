package com.abn.dsalgos.glc;

/*
Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain,
return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

Input: arr = [0,1,0]
Output: 1

Input: arr = [0,2,1,0]
Output: 1

Input: arr = [0,10,5,2]
Output: 1

Input: arr = [3,4,5,1]
Output: 2

Input: arr = [24,69,100,99,79,78,67,36,26,19]
Output: 2


 */
public class PeakIndexInAMountainArray {

    public int peak(int[] arr) {
        int len = arr.length;
        int start = 0;
        int mid;
        int end = len - 1;
        int index = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mid == 0) {
                index = mid + 1;
                break;
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                index = mid;
                break;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            }
        }

        return index;
    }
}
