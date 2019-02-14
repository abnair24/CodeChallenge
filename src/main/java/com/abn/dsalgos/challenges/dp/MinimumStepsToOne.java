package com.abn.dsalgos.challenges.dp;

import org.testng.annotations.Test;

public class MinimumStepsToOne {

    int[] arr;

    int number;

    public MinimumStepsToOne(int num) {
        this.number = num;

        arr = new int[number +1];
        for(int i =0; i< number +1 ; i++) {
            arr[i] = -1;
        }

    }

    public int minSteps(int n) {


        if(n == 1) {
            return 0;
        }

        if(arr[n] != -1) {
            return arr[n];
        }

        int r = 1 + minSteps(n-1);

        if(n%2 == 0) {
            r = Math.min(r, 1+ minSteps(n/2));
        }

        if(n%3 == 0) {
            r = Math.min(r,1 + minSteps(n/3));
        }

        arr[n] = r;

        return r;
    }
}
