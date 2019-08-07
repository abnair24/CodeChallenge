package com.abn.dsalgos.challenges.problems;

import java.util.Arrays;

public class RotateArrayKtimes {


    public static void main(String[] args) {

        int[] array = new int[] {1,2,3,4,5,6,7};

        System.out.println(Arrays.toString(rotateArray(array,199)));
    }

    public static int[] rotateArray(int[] array,int shift) {

        int length = array.length;

        // to support when shift > length value

        shift = shift%length;

        System.out.println(shift);

        int[] temp = new int[length];

        int[] temp2 = new int[shift];

        for(int i = 0; i< shift; i++) {
            temp2[i] = array[i];
        }

        for(int i= 0; i< length - shift;i ++) {
            temp[i]= array[i+shift];
        }

        for(int i = length-shift; i< length ;i++) {
            temp[i]= temp2[i - (length-shift)];
        }

        return temp;
    }
}

