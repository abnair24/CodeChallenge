package com.abn.dsalgos.challenges.problems;

import java.io.*;
import java.util.*;

/*
    Given an array, you must increment any duplicate elements until all its elements are unique.
    In addition, the sum of its elements must be the minimum possible within the rules.
    For example, if arr = [3, 2, 1, 2, 7], then arrunique = [3, 2, 1, 4, 7] and its elements
    sum to a minimal value of 3 + 2 + 1 + 4 + 7 = 17.

    Complete the getMinimumUniqueSum function in the editor below to create an array of unique elements with a minimal sum.
    Return the integer sum of the resulting array.

    getMinimumUniqueSum has the following parameter(s):

    arr:  an array of integers to process
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        int result = Result.getMinimumUniqueSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'getMinimumUniqueSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int getMinimumUniqueSum(List<Integer> arr) {

        Set<Integer> unique = new HashSet();

        for (int i : arr) {
            if (!unique.contains(i)) {
                unique.add(i);
            } else {
                while (unique.contains(i)) {
                    i++;
                }
                unique.add(i);
            }
        }

        Iterator iterator = unique.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += (int) iterator.next();
        }

        return sum;
    }

}
