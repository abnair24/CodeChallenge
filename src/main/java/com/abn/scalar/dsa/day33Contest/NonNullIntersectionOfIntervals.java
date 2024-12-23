package com.abn.scalar.dsa.day33Contest;

import java.util.Arrays;

public class NonNullIntersectionOfIntervals {

    public int solve(int[][] A) {

        int rows = A.length;
        int cols = A[0].length;
        int count = 0;

        int[][] ranges = new int[rows][2];

        for(int i = 0; i < rows; i ++) {
            ranges[i] = getintervals(A[i]);
        }

        Arrays.sort(ranges, (x, y) -> Integer.compare(x[0], y[0]));

        int[] currentRange = ranges[0];

        for(int i = 1; i < ranges.length; i++) {
            int[] nextRange = ranges[i];

            if(nextRange[0] <= currentRange[1]) {
                currentRange[1] = Math.max(currentRange[1], nextRange[1]);
                count++;
            } else {
                currentRange = nextRange;
            }
        }

        return count;
    }

    private int[] getintervals(int[] interval) {

        int inclusionval = interval[0];
        int start = interval[1];
        int end = interval[2];

        if(inclusionval == 1) {
            return new int[]{start, end };
        } else if(inclusionval == 2) {
            return new int[]{start, end -1};
        } else if(inclusionval == 3) {
            return new int[] {start +1 , end};
        } else {
            return new int[] {start + 1, end - 1};
        }

    }
}
