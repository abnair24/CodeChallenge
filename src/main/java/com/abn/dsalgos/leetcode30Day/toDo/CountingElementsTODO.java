package com.abn.dsalgos.leetcode30Day.toDo;


    /*
    Given an integer array arr, count element x such that x + 1 is also in arr.

    If there're duplicates in arr, count them seperately.

    Input: arr = [1,2,3]
    Output: 2
    Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

    Input: arr = [1,1,3,3,5,5,7,7]
    Output: 0
    Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

    Input: arr = [1,1,2,2]
    Output: 2
    Explanation: Two 1s are counted cause 2 is in arr.

    Input: arr = [1,3,2,3,5,0]
    Output: 3
    Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
    */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingElementsTODO {

//    public static void main(String[] args) {
//        CountingElementsTODO countingElements = new CountingElementsTODO();
//        countingElements.countElements(new int[] {1,3,2,3,5,0});
//    }
//
//    public int countElements(int[] arr) {
//        Map<Integer, List<Integer>> count = new HashMap<>();
//        int elementCount = 0;
//
//        for(int i=0; i<arr.length; i++) {
//            if(!count.containsKey(arr[i])) {
//                List<Integer> ll = new ArrayList<>();
//                ll.add(arr[i] + 1);
//                count.put(arr[i], ll);
//            } else {
//                count.get(arr[i]).add(arr[i] + 1);
//            }
//        }
//
//        for(int i = 0; i < arr.length; i++) {
//            if(count.(arr[i])) {
//                elementCount ++;
//            }
//        }
//        System.out.println(elementCount);
//        return elementCount;
//    }
}
