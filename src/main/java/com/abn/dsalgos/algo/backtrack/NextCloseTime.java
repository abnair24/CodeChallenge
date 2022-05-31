package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Input: time = "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Input: time = "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 */

public class NextCloseTime {

    int min = Integer.MAX_VALUE;
    int minTime = 0;

    public String nextClosestTime(String time) {

        int originalMinutes = Integer.parseInt(time.substring(0, 2)) * 60;

        originalMinutes += Integer.parseInt(time.substring(3));

        // if time = 11:11 or 22:22 or 00:00
        if(originalMinutes == 671 || originalMinutes == 1342 || originalMinutes == 0000) {
            return String.format("%02d:%02d", originalMinutes / 60, originalMinutes % 60);
        }

        LinkedList<Integer> track = new LinkedList<>();

        LinkedList<Integer> digits = new LinkedList<>();

        for (char ch : time.toCharArray()) {
            if (ch != ':') {
                digits.add(ch - '0');
            }
        }

        backtrack(digits, track, originalMinutes);

        return String.format("%02d:%02d", minTime / 60, minTime % 60);
    }

    private void backtrack(LinkedList<Integer> digits, LinkedList<Integer> track, int originalMinutes) {

        if (track.size() == digits.size()) {

            int newTime = getTime(track);

            int diff = 0;
            int nextNewTime = newTime;

            //If newTime is less than currenttime, consider it as next day, so add 24 hrs ie; 24*60 into newTime and find diff.
            if(newTime < originalMinutes) {
                newTime +=  24 * 60;
            }

            diff = newTime - originalMinutes;

            if (diff > 0 && diff <= min) {

                min = diff;
                minTime = nextNewTime;
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {

            if (track.isEmpty() && digits.get(i) > 2) {
                continue;
            }

            if (track.size() == 1 && track.get(0) > 1 && digits.get(i) > 3) {
                continue;
            }

            if (track.size() == 2 && digits.get(i) > 5) {
                continue;
            }

            track.add(digits.get(i));
            backtrack(digits, track, originalMinutes);
            track.removeLast();
        }
    }

    private int getTime(LinkedList<Integer> track) {

        int minutes = 0;
        int res = 0;
        for (int i = 0; i < track.size() - 2; i++) {
            minutes = minutes * 10 + track.get(i);
        }

        for (int i = 2; i < track.size(); i++) {
            res = res * 10 + track.get(i);
        }

        minutes = (minutes * 60) + res;

        return minutes;
    }

    public static void main(String[] args) {

        System.out.println(new NextCloseTime().nextClosestTime("23:59"));
        System.out.println(new NextCloseTime().nextClosestTime("15:55"));
        System.out.println(new NextCloseTime().nextClosestTime("16:55"));
        System.out.println(new NextCloseTime().nextClosestTime("16:56"));
        System.out.println(new NextCloseTime().nextClosestTime("19:35"));
        System.out.println(new NextCloseTime().nextClosestTime("10:25"));
        System.out.println(new NextCloseTime().nextClosestTime("11:11"));
    }
}
