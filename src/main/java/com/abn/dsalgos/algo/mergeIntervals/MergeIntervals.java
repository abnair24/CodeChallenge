package com.abn.dsalgos.algo.mergeIntervals;

import com.abn.dsalgos.utils.Interval;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]

Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
 */

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> merged = new LinkedList<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= end) {
                end = Math.max(intervals.get(i).end, end);
            } else {
                merged.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        merged.add(new Interval(start, end));
        return merged;
    }
}
