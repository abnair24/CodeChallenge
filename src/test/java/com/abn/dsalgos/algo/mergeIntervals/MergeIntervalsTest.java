package com.abn.dsalgos.algo.mergeIntervals;

import com.abn.dsalgos.utils.Interval;
import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class MergeIntervalsTest {

    MergeIntervals mergeIntervals = new MergeIntervals();

    @Test
    public void test() {

        Interval inter1 = new Interval(1, 5);
        Interval inter2 = new Interval(2, 7);
        Interval inter3 = new Interval(10, 12);
        Interval inter4 = new Interval(6, 9);

        List<Interval> input = Arrays.asList(inter1, inter2, inter3, inter4);
        List<Interval> expected = Arrays.asList(new Interval(1, 9), new Interval(10, 12));

        List<Interval> output = mergeIntervals.merge(input);
        Assert.assertEquals(mergeIntervals.merge(input), expected);
    }
}
