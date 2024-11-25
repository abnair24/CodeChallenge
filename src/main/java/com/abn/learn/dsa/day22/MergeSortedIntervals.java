package com.abn.learn.dsa.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedIntervals {

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 4},  {3, 7}, {10, 12}, {13, 17}, {15, 20}
        };



        List<Integer> result = new ArrayList<>();
        result.add(input[0][0]);
        result.add(input[0][1]);
        for (int i=1; i<input.length; i++)
        {
            merge(result.get(result.size()-2), result.get(result.size()-1),input[i][0],input[i][1],result);

        }

        int[][] resultArr = new int[result.size()/2][2];
        int arrCounter=0;
        for (int i=0; i<result.size()-1;i=i+2)
        {
            resultArr[arrCounter][0]=result.get(i);
            resultArr[arrCounter][1]=result.get(i+1);
            arrCounter++;
        }

        System.out.println(result);

        System.out.println(Arrays.deepToString(resultArr));



    }

    public static void merge (int first, int second, int third, int forth, List<Integer> result)
    {
        //1-5, 2-7
        if( second>=third)
        {
            result.remove(result.size()-1);
            result.remove(result.size()-1);
            result.add(first);
            result.add( forth);

        }
        else
        {
            result.add(third);
            result.add(forth);
        }
    }
}
