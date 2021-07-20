package com.abn.dsalgos.algo.greedy;

public class MinimumJumpsToEnd {

    public int minJumps(int[] array) {

        if(array[0] == 0 || array.length == 1) {
            return 0;
        }

        int windowStartIndex = 0;
        int count = 1;
        int indexToStart = 0;

        while(windowStartIndex < array.length - 1 && (windowStartIndex + array[windowStartIndex] < array.length-1)) {

            int size = windowStartIndex + array[windowStartIndex];
            int maxIndex = 0;
            for(int j = 1; j <= size; j++) {
                int temp = j + array[j];

                if(temp > maxIndex) {
                    maxIndex = temp;
                    indexToStart = j;
                }
            }
            windowStartIndex = indexToStart;
            count ++;
        }
        return count;
    }
}
