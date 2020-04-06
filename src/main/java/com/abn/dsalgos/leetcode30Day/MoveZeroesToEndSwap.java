package com.abn.dsalgos.leetcode30Day;

public class MoveZeroesToEndSwap {

     /*
    Given an array nums, write a function to move all 0's to the end of it.

    Input: [0,1,0,3,12]
    Output: [3,12,1,0,0]
     */

     public int[] pushZeroesToEnd(int[] arr) {

         int start = 0;
         int end = arr.length-1;

         while(start < end)
         {
             if(arr[start] != 0) {
                 ++start;
             } else if(arr[end]==0) {
                 --end;
             } else if(arr[start] == 0 && arr[end]!=0) {
                 int temp = arr[end];
                 arr[end]=arr[start];
                 arr[start]=temp;
                 ++start;
                 --end;
             }
         }
        return arr;
     }
}
