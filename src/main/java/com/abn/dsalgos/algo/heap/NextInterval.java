package com.abn.dsalgos.algo.heap;

import com.abn.dsalgos.utils.Interval;
import org.testng.collections.Maps;

import java.util.Arrays;
import java.util.Map;

/*

You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.

Return an array of right interval indices for each interval i. If no right interval exists for interval i,

then put -1 at index i.

intervals = [[1,2]]
Output: [-1]

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]

 */
public class NextInterval {

    public static void main(String[] args) {

        NextInterval nextInterval = new NextInterval();
        nextInterval.next(new Interval[] {new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)});
    }

    public int[] next(Interval[] intervals) {

        Map<Interval, Integer> hm = Maps.newHashMap();
        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {

            if (!hm.containsKey(intervals[i])) {
                hm.put(intervals[i], i);
            }
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i].start >= intervals[i - 1].end) {
                result[hm.get(intervals[i - 1])] = hm.get(intervals[i]);
            } else {
                int index = hm.get(intervals[i - 1]);
                result[index] = -1;
            }
        }

        result[hm.get(intervals[intervals.length - 1])] = -1;

        return result;
    }
}
