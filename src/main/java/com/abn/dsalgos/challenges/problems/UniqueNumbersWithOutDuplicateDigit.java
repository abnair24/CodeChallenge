package com.abn.dsalgos.challenges.problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
   Ashley loves numbers made up of unique digits. She is less enchanted with numbers that have repeating digits.
   Given a range of integers, determine how many numbers she will love.
   For example, the lower bound n=80 and the upper bound m=120. Both are inclusive,
   so there are 120-79=41 values in the range. Numbers she loves are green. Others are red.
   The two columns to the right are the love/hate counts per row.

   Complete the function countNumbers in the editor below. For each bounds pair arr[i],
   it must print the number of integers in the inclusive range that Ashley loves.
   countNumbers has the following parameter(s):

    arr[arr[n0,m0],arr[n1,m1],...arr[nq-1,mq-1]]:  an array of integer pairs representing lower and upper range limits

    arr = [ [1, 20], [9, 19] ] : O/P :  19 10
 */

public class UniqueNumbersWithOutDuplicateDigit {

    static void countNumbers(List<List<Integer>> arr) {
        List<Integer> countArray = new ArrayList<>();

        for (List<Integer> array : arr) {
            int count = 0;
            for (int i = array.get(0); i <= array.get(1); i++) {
                int number = i;
                boolean[] numVisited = new boolean[10];

                while (number != 0) {
                    if (numVisited[number % 10]) {
                        break;
                    }

                    numVisited[number % 10] = true;
                    number = number / 10;
                }
                if (number == 0) {
                    count++;
                }
            }
            countArray.add(count);
        }

        for (int i : countArray) {
            System.out.println(i);
        }
    }

    public static void main(String[] args)
            throws IOException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> list3 = new ArrayList<>();
        list1.add(new Integer(1));
        list1.add(new Integer(20));
        list2.add(new Integer(9));
        list2.add(new Integer(19));
        list3.add(list1);
        list3.add(list2);

        countNumbers(list3);
    }
}
