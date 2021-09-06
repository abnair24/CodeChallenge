package com.abn.dsalgos.algo.bitwise;

public class FlipAndInvertImage {

    public int[][] flipAndInvert(int[][] array) {

        for (int[] row : array) {
            for (int i = 0; i <= row.length / 2; i++) {
                int temp = row[row.length - 1 - i] ^ 1;
                row[row.length - 1 - i] = row[i] ^ 1;
                row[i] = temp;
            }
        }
        return array;
    }
}
