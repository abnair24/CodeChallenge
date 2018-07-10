package com.abn.dsalgos.sortAlgos;

import java.lang.reflect.Array;

/**
 * Created by aswathyn on 22/02/17.
 */
public class MergeSort<T extends Comparable<T>> {
    private T[] array;
    private T[] temp;
    private int length;

    public void sort(Class<T> claz, T[] array){
        this.array = array;
        this.length = array.length;
        this.temp = (T[]) Array.newInstance(claz, this.length);
        mergeSort(0,length-1);
    }

    private void mergeSort(int lower, int higher) {
        if(lower < higher) {
            int middle = lower + (higher -lower)/2;
            mergeSort(lower,middle);
            mergeSort(middle+1 , higher);

            merge(lower,middle,higher);
        }
    }

    private void merge(int low, int mid, int high) {
        for(int i = low; i <=high;i++) {
            temp[i] = array[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while(i <= mid && j<=high) {
            if(temp[i].compareTo(temp[j]) <0) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            array[k] = temp[i];
            k++;
            i++;
        }
    }
}
