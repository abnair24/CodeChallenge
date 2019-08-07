package com.abn.dsalgos.challenges.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
You will be given an array of the lengths of a number of sticks. 
When a turn begins, you must count the number of sticks you have. 
Determine the length of a stick with the shortest length and discard any sticks of that length. 
Remove that length from each of the longer sticks and discard the offcuts. 
Repeat until there are no sticks left.  Return an array where the elements are the numbers of
sticks you had at the beginning of each turn.
 
For example, consider an array representing the lengths of four sticks: [1, 1, 2, 3].  The shortest sticks are 1 unit long. 
Discard them.  Remove 1 unit from the other two sticks and discard the scrap.  Now you have two sticks lengths [1, 2]. 
Do the same and you'll have one stick of length [1].  Discard it and return an array with the number of sticks you had
at the start of each turn: [4, 2, 1].

lengths     cut length      sticks
1 1 2 3          1            4
_ _ 1 2          1            2
_ _ _ 1          1            1
_ _ _ _        DONE        DONE
 
Function Description
Complete the function cutSticks in the editor below. The function must return an array of integers representing the number
of sticks at the start of each turn.
 
cutSticks has the following parameter(s):
    lengths[lengths[0],...lengths[n-1]]:  an array of integers representing the starting stick lengths
 
Constraints
* 1 ≤ n ≤ 103
* 1 ≤ lengths[i] ≤ 103, where 0 ≤ i < n
 
Input Format for Custom Testing
Sample Case 0
Sample Input 0
6
5
4
4
2
2
8
 
Sample Output 0
6
4
2
1

 */
public class StickLengthArray {

    public static void main(String[] args) {
        List<Integer> lengths = new ArrayList<>();

        lengths.add(new Integer(5));
        lengths.add(new Integer(4));
        lengths.add(new Integer(4));
        lengths.add(new Integer(2));
        lengths.add(new Integer(2));
        lengths.add(new Integer(8));

        cutTheSticks(lengths);
    }

    static void cutTheSticks(List<Integer>arr) {
        ArrayList<Integer> arrayCount = new ArrayList<>();
        Collections.sort(arr);

        arrayCount.add(arr.size());

        while(arr.size()>1) {
            int small = arr.get(0);
            for(int i = 0;i<arr.size();i++) {
                arr.set(i, arr.get(i) - small);
            }
            arr.removeAll(Arrays.asList(0));
            if(arr.size() != 0) {
                arrayCount.add(arr.size());
            }
        }

        for(int i: arrayCount) {
            System.out.println(i);
        }
    }
}
