package com.abn.learn.dsa.day22;

import java.util.ArrayList;


/*
Given a collection of intervals A in a 2 D array format, where each internal is represented by a pairof
integers [start end]. The intervals are sorted based on their start values
Your task is to merge all overlapping intervals return

the resulting set of non overlapping intervals
Ifp Internal (0,2) (1,4) (5,6) (6,8) (3,10)
 */
public class MergeSortedOverlappingInterval {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> intervals) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int currentStart = intervals.get(0).get(0);
        int currentEnd = intervals.get(0).get(1);

        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).get(0) <= currentEnd) {
                currentEnd = Math.max(currentEnd, intervals.get(i).get(1));
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(currentStart);
                temp.add(currentEnd);

                currentStart = intervals.get(i).get(0);;
                currentEnd = intervals.get(i).get(1);
                ans.add(temp);
            }
        }

        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(currentStart);
        temp1.add(currentEnd);

        ans.add(temp1);

        return ans;
    }

    public static void main(String[] args) {

        MergeSortedOverlappingInterval mergeSortedOverlappingInterval = new MergeSortedOverlappingInterval();

    }
}
