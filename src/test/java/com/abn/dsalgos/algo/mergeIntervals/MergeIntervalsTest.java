package com.abn.dsalgos.algo.mergeIntervals;

import com.abn.dsalgos.utils.Interval;
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

        Assert.assertTrue(mergeIntervals.merge(input).containsAll(expected));
    }

    @Test
    public void test1() {

        Interval inter1 = new Interval(7, 9);
        Interval inter2 = new Interval(1, 4);
        Interval inter3 = new Interval(11, 12);
        Interval inter4 = new Interval(2, 6);
        Interval inter5 = new Interval(8, 10);

        List<Interval> input = Arrays.asList(inter1, inter2, inter3, inter4, inter5);
        List<Interval> expected =  Arrays.asList(new Interval(1, 6), new Interval(7, 10), new Interval(11, 12));
        Assert.assertTrue(mergeIntervals.merge(input).containsAll(expected));
    }
}


