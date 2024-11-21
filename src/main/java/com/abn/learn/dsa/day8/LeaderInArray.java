package com.abn.learn.dsa.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderInArray {

    public int[] solve(int[] array) {

        int len = array.length;
        List<Integer> result = new ArrayList<>();

        int max = array[len - 1];
        result.add(max);

        for(int i = len - 2; i >= 0; i--) {
            if(array[i] > max) {
                result.add(array[i]);
                max = array[i];
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        LeaderInArray leaderInArray = new LeaderInArray();
        int[] result = leaderInArray.solve(new int[] {16, 17, 4, 3, 5, 2});
        Arrays.stream(result).forEach(System.out::println);
    }
}
