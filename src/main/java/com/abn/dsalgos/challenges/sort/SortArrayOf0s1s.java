package com.abn.dsalgos.challenges.sort;

public class SortArrayOf0s1s {

    public void sort(int[] array, int length) {
        int i,count0=0, count1=0, count2=0;

        for(i=0;i<length;i++) {
            switch (array[i]) {
                case 0:
                    count0++;
                    break;

                case 1:
                    count1++;
                    break;

                case 2:
                    count2++;
                    break;
            }
        }

        i=0;
        while(count0 > 0) {
            array[i++] = 0;
            count0--;
        }

        while(count1 >0) {
            array[i++] =1;
            count1--;
        }

        while(count2 > 0) {
            array[i++] =2;
            count2--;
        }

        for(i = 0; i <length;i++) {
            System.out.print(array[i] + " ");
        }
    }
}
