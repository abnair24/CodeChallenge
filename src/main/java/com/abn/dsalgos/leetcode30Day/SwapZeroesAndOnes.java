package com.abn.dsalgos.leetcode30Day;

public class SwapZeroesAndOnes {

    public static void main(String[] args) {
        int[] array = swapones(new int[]{1,0,0 ,1 ,1,1, 1, 1});
        for(int i=0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] swapones(int[] array) {

        int pt1 = array.length - 1;
        int pt2 = array.length - 1;
        int temp = 0;
        while(pt2 >=0){
            if(array[pt2] != 1) {
                temp = array[pt2];
                array[pt2] = array[pt1];
                array[pt1] = temp;
                pt1--;
            }
            pt2 --;
        }

        return array;
    }

}
