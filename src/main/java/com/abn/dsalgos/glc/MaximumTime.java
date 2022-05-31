package com.abn.dsalgos.glc;

public class MaximumTime {

    public String maximumTime(String time) {

        char[] timeChar = time.toCharArray();

        if (timeChar[0] == '?') {

            timeChar[0] = timeChar[1] <= '3' || timeChar[1] == '?' ? '2' : '1';
        }

        if (timeChar[1] == '?') {
            timeChar[1] = timeChar[0] == '2' ? '2' : '9';
        }

        if (timeChar[3] == '?') {

            timeChar[3] = '5';
        }

        if (timeChar[4] == '?') {
            timeChar[4] = '9';
        }

        return new String(timeChar);
    }

    public static void main(String[] args) {
        MaximumTime maximumTime = new MaximumTime();
        maximumTime.maximumTime("0?:3?");
    }

}
