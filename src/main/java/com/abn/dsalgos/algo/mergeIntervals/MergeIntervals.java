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

//TODO: tests
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> merged = new LinkedList<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> iterator = intervals.iterator();
        Interval inter = iterator.next();

        int start = inter.start;
        int end = inter.end;

        while (iterator.hasNext()) {
            inter = iterator.next();

            if (inter.start <= end) {
                end = Math.max(inter.end, end);
            } else {
                merged.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        merged.add(new Interval(start, end));
        return merged;
    }
}
