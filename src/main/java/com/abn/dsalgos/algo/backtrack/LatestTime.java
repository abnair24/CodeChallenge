package com.abn.dsalgos.algo.backtrack;

import org.testng.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59.

The earliest 24-hour time is 00:00, and the latest is 23:59.

Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.

Input: arr = [1,2,3,4]
Output: "23:41"

Input: arr = [5,5,5,5]
Output: ""

Input: arr = [0,0,0,0]
Output: "00:00"

 */
public class LatestTime {

    int max = Integer.MIN_VALUE;

    public String permute(int[] array) {

        LinkedList<Integer> track = new LinkedList<>();

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            countMap.put(array[i], countMap.getOrDefault(array[i], 0) + 1);
        }
        backtrack(array, track, countMap);

        return max == Integer.MIN_VALUE ? "" : String.format("%02d:%02d", max / 60, max % 60);

    }

    private void backtrack(int[] array, LinkedList<Integer> track, Map<Integer, Integer> countMap) {

        if (track.size() == array.length) {
            buildTime(track);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

            int num = entry.getKey();
            int value = entry.getValue();

            // pruning conditions
            if (value == 0) {
                continue;
            }

            if (track.isEmpty() && num > 2) {
                continue;
            }

            if (track.size() == 2 && num > 5) {
                continue;
            }

            if (track.size() == 1 && track.get(0) > 1 && num > 3) {
                continue;
            }

            track.add(num);
            countMap.put(num, value - 1);
            backtrack(array, track, countMap);
            track.removeLast();
            countMap.put(num, value);
        }
    }

    private void buildTime(LinkedList<Integer> track) {

        int hour = track.get(0) * 10 + track.get(1);
        int minute = track.get(2) * 10 + track.get(3);

        if (hour < 24 && minute < 60) {
            max = Math.max(max, (hour * 60 + minute));
        }
    }

    public static void main(String[] args) {
        LatestTime latestTime = new LatestTime();
        Assert.assertEquals(latestTime.permute(new int[] {5, 5, 5, 5}), "");
        Assert.assertEquals(latestTime.permute(new int[] {1, 2, 3, 4}), "23:41");
        Assert.assertEquals(latestTime.permute(new int[] {9, 2, 3, 4}), "23:49");
    }
}
