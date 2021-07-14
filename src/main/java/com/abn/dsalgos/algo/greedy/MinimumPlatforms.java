package com.abn.dsalgos.algo.greedy;

import java.util.Arrays;

/*
Given the arrival and departure times of trains, calculate the number of platforms required for a train station.

eg:
arrival[] = {900, 940, 950, 1100, 1500, 1800};
departure[] = {910, 1200, 1120, 1130, 1900, 2000};

Minimum platforms needed = 3
 */
public class MinimumPlatforms {

    public int minimum(int[] arrival, int[] departure) {

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int arrIndex = 1;
        int depIndex = 0;
        int total = 1;
        int count = 1;

        while (arrIndex < arrival.length && depIndex < departure.length) {

            if (arrival[arrIndex] <= departure[depIndex]) {
                count++;
                arrIndex++;

                total = Math.max(total, count);

            } else {
                count--;
                depIndex++;
            }
        }

        return total;
    }
}
