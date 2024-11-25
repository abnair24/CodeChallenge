package com.abn.dsalgos.algo.mergeIntervals;

import com.abn.dsalgos.utils.Interval;
import org.testng.Assert;
import org.testng.collections.Lists;

import java.util.ArrayList;
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

public class InsertIntervalToList {

    public int[][] insert(int[][] A, int[] B) {

        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = A.length;

        while (i < n && A[i][1] < B[0]) {
            res.add(A[i]);
            i++;
        }

        while (i < n && A[i][0] <= B[1]) {
            B[0] = Math.min(B[0], A[i][0]);
            B[1] = Math.max(B[1], A[i][1]);
            i++;
        }
        res.add(B);

        // Add all the remaining intervals
        while (i < n) {
            res.add(A[i]);
            i++;
        }

        int[][] result = new int[res.size()][];

        for(int j = 0; j < res.size(); j++) {

            result[j] = res.get(j);
        }

        return result;
    }

    public static void main(String[] args) {

        InsertIntervalToList insertIntervalToList = new InsertIntervalToList();
        System.out.println(Arrays.deepToString(insertIntervalToList.insert(new int[][] {
                {6037774,6198243},
                {6726550,7004541},
                {8842554,10866536},
                {11027721,11341296},
                {11972532,14746848},
                {16374805,16706396},
                {17557262,20518214},
                {22139780,22379559},
                {27212352,28404611},
                {28921768,29621583},
                {29823256,32060921},
                {33950165,36418956},
                {37225039,37785557},
                {40087908,41184444},
                {41922814,45297414},
                {48142402,48244133},
                {48622983,50443163},
                {50898369,55612831},
                {57030757,58120901},
                {59772759,59943999},
                {61141939,64859907},
                {65277782,65296274},
                {67497842,68386607},
                {70414085,73339545},
                {73896106,75605861},
                {79672668,84539434},
                {84821550,86558001},
                {91116470,92198054},
                {96147808,98979097}
        }, new int[]{36210193,61984219})));

    }
}
