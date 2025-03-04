package com.abn.scalar.dsa.day32;

import java.util.Arrays;

public class WaveArray {

    public int[] wave(int[] A) {
        Arrays.sort(A);

        int ptr1 = 0;
        int ptr2 = ptr1 + 1;

        while (ptr2 < A.length) {
            swap(ptr1, ptr2, A);
            ptr2+= 2;
            ptr1+= 2;
        }
        return A;
    }

    private int[] swap(int num1, int num2, int[] array) {

        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
        return array;
    }

    public static void main(String[] args) {

        WaveArray waveArray = new WaveArray();
        System.out.println(Arrays.toString(waveArray.wave(new int[] {1, 2})));
        System.out.println(Arrays.toString(waveArray.wave(new int[] {1, 2, 3, 4})));

    }
}
