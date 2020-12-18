package com.abn.dsalgos.challenges.problems;

import java.util.Arrays;
import java.util.HashMap;

public class RotateArrayKtimes {


    public int[] rotateArray(int[] array,int shift) {

        int length = array.length;
        if(length == 0 || length == 1) {
            return array;
        }
        int[] temp = new int[length];
        int x = shift % length;
        if(x == 0) {
            return array;
        }

        for(int i= 0; i< length - x;i ++) {
            temp[i]= array[i+x];
        }

        for(int i = length-x; i< length ;i++) {
            temp[i]= array[i - (length-x)];
        }
        return temp;
    }
}

