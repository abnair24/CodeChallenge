package com.abn.dsalgos.ds;

/**
 * Created by aswathyn on 18/02/17.
 */
public class QuickSort<T extends Comparable<T>> {

    public T[] A;

    public void sort(T[] A) {
        if (A == null || A.length == 0)
            return;
        quicksort(A, 0, A.length - 1);
    }

    private void quicksort(T[] array, int left, int right) {

        T pivot = array[left + (right - left) / 2];

        int i = left;
        int j = right;

        while (i <= j) {

            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {

                T temp = array[i];
                array[i]=array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        if(left < j)
            quicksort(array,left,j);
        if(i < right)
            quicksort(array,i,right);
    }
}
