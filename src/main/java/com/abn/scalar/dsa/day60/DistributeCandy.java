package com.abn.scalar.dsa.day60;

import java.util.Arrays;

public class DistributeCandy {

    public int solve(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for(int i = 1; i < n; i++) {
            if(a[i] > a[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }

        for(int i = n-2 ; i >=0; i --) {
            if(a[i] > a[i+ 1] && result[i] <= result[i+1]) {
                result[i] = result[i+1]+1;
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += result[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        DistributeCandy distributeCandy = new DistributeCandy();
        System.out.println(distributeCandy.solve(new int[] {1, 5, 2, 1}));
    }
}
