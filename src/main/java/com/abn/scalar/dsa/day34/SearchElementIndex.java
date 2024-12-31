package com.abn.scalar.dsa.day34;

/*
Given a sorted array with distinct elements, search the index of an element k, if k is not present, return -1.
 */
public class SearchElementIndex {

    public int solve(int[] array, int k) {

        int low = 0;
        int high = array.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + (high - low)/ 2);

            if(array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        SearchElementIndex searchElementIndex = new SearchElementIndex();
        System.out.println(searchElementIndex.solve(new int[] {3, 6, 9, 12, 18, 21, 24, 27, 29, 40}, 27));
        System.out.println(searchElementIndex.solve(new int[] {3, 6, 9, 12, 18, 21, 24, 27, 29, 40}, 20));
        System.out.println(searchElementIndex.solve(new int[] {3, 6, 9, 12, 18, 21, 24, 27, 29, 40}, 3));
        System.out.println(searchElementIndex.solve(new int[] {3, 6, 9, 12, 18, 21, 24, 27, 29, 40}, 40));
        System.out.println(searchElementIndex.solve(new int[] {3, 6, 9, 12, 18, 21, 24, 27, 29, 40}, 41));
    }
}
