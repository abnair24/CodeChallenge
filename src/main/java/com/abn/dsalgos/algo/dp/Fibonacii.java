package com.abn.dsalgos.algo.dp;

public class Fibonacii {

    public static final int MAX = 100;

    int[] arr;

    public Fibonacii() {
        arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = -1;
        }
    }

    public int fibTopDown(int n) {
        if (arr[n] == -1) {
            if (n <= 1) {
                arr[n] = n;
            } else {
                arr[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
            }
        }

        return arr[n];
    }

    public int fibBottomUp(int n) {
        int[] array = new int[n + 1];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }
}
