package com.abn.dsalgos.sortAlgos;

public class Merge {
    int [] temp = new int[100];

   public void mergeSort(int[] array, int left, int right) {
       if(left < right) {
           System.out.println("Merge sort: "+left+" :"+right);
           int middle = (left + right)/2;
           mergeSort(array, left, middle);
           mergeSort(array,middle+1,right);
           merge(array,left, middle,right);
       }
   }
   public void merge(int[]array,int left,int middle, int right) {
       System.out.println("Merge: "+left+" :"+middle+" :"+right);
       for (int i = left; i <= right; i++) {
           temp[i] = array[i];
       }
       int l = left;
       int m = middle + 1;
       int k = left;
       while (l <= middle && m <= right) {
           if (temp[l] <= temp[m]) {
               array[k] = temp[l];
               l++;
           } else {
               array[k] = temp[m];
               m++;
           }
           k++;
       }
       while (l <= middle) {
           array[k] = temp[l];
           l++;
           k++;
       }
   }
    public static void main(String[] args) {
       int[] arr = new int[]{2,4,3,1,0,7,5,5,6};
        Merge merge = new Merge();
        merge.merge_sort(arr);
        for(int i = 0; i<arr.length;i++) {
            System.out.print(arr[i]+ ", ");
        }
    }
    public void merge_sort(int[] array) {
       mergeSort(array,0,array.length-1);
    }
}
