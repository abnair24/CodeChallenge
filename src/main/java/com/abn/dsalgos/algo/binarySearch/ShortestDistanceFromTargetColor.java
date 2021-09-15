package com.abn.dsalgos.algo.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

You are given an array colors, in which there are three colors: 1, 2 and 3.

You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i
and the target color c. If there is no solution return -1.

Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
Output: [3,0,3]

Input: colors = [1,2], queries = [[0,3]]
Output: [-1]
 */

public class ShortestDistanceFromTargetColor {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < colors.length; i++) {
            if (!map.containsKey(colors[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(colors[i], list);
            } else {
                map.get(colors[i]).add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][1])) {
                result.add(-1);
            } else if (queries[i][1] == colors[queries[i][0]]) {
                result.add(0);
            } else {
                result.add(getNearestPosition(queries[i][0], map.get(queries[i][1])));
            }
        }
        return result;
    }

    private int getNearestPosition(int index, List<Integer> colorList) {

        int len = colorList.size();
        int min = 0;
        if (index <= colorList.get(0)) {
            return Math.abs(index - colorList.get(0));
        } else if (index >= colorList.get(len - 1)) {
            return Math.abs(index - colorList.get(len - 1));
        } else {

            min = binarySearch(colorList, index);
        }
        return min;
    }

    private int binarySearch(List<Integer> list, int index) {

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            min = Math.min(min, Math.abs(index - list.get(mid)));

            if (index > list.get(mid)) {

                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        int[] colors = new int[] {1,1,2,1,3,2,2,3,3};
        int[][] queries = new int[][] {{1,3},{2,2},{6,1}};

        new ShortestDistanceFromTargetColor().shortestDistanceColor(colors, queries);
    }
}
