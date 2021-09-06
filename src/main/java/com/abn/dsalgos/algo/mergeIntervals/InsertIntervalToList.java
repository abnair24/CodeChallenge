package com.abn.dsalgos.algo.mergeIntervals;

import com.abn.dsalgos.utils.Interval;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

/*
Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary intervals to produce
a list that has only mutually exclusive intervals.

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
Output: [[1,3], [4,12]]

Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
Output: [[1,4], [5,7]]
 */

//TODO: tests
public class InsertIntervalToList {

    public List<Interval> insert(List<Interval> a, Interval b) {

        if (a == null || a.isEmpty()) {
            return Arrays.asList(b);
        }

        List<Interval> merged = Lists.newLinkedList();

        int i = 0;

        while (i < a.size() && a.get(i).end < b.start) {
            merged.add(a.get(i));
            i++;
        }

        // if a and b overlaps, then a.start will be less or equal to b.end
        while (i < a.size() && a.get(i).start <= b.end) {
            b.start = Math.min(a.get(i).start, b.start);
            b.end = Math.max(a.get(i).end, b.end);
            i++;
        }

        merged.add(b);

        // add remaining ones to list
        while (i < a.size()) {
            merged.add(a.get(i++));
        }

        return merged;
    }
}
