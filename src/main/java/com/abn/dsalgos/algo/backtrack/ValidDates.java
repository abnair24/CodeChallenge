package com.abn.dsalgos.algo.backtrack;


/*
Given any 3 numbers, and list the permutations of valid dates.

For example, giving (2, 7, 29),
valid dates : [(2, 7, 29), (29, 2, 7), (29, 7, 2)], if in (yyyy,mm,dd) format.

If there is no valid permutation, return an empty list. Please implement this function, get_valid_dates(num1, num2, num3).

Hint: Please notice solar/lunar months and leap year issues.
Other examples:
(4, 13, 100) --> [(100, 4, 13)]

February (2) --> In a leap year, Feb has 29 days; if a normal year,, Feb has 28 days only;
The rule for leap years:
% 4 == 0, True; 4, 8, 12, 2004, 804, 2012,
% 100 == 0, False; 1800, 1900, 2100
% 400 == 0, True; 1200, 1600, 2000
% 3200 == 0, False; 3200, 6400, 9600
**/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidDates {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> getValidDates(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        boolean [] used = new boolean[nums.length];
        permuteHelper(nums, track, used);
        return result;
    }

    private void permuteHelper(int[] nums, LinkedList<Integer> track, boolean[] used) {

        if(track.size() == 3) {

            if(!result.contains(track)) {
                result.add(new LinkedList<>(track));
            }
            return;
        }

        for(int i = 0; i < nums.length; ++i) {

            if(used[i]) {
                continue;
            }

            if(track.isEmpty() && !isValidYear(nums[i])) {
                continue;
            }

            if(track.size() == 1 && !isValidMonth(nums[i])) {
               continue;
            }

            if(track.size() == 2 && !isValidDate(track, nums[i])) {
               continue;
            }

            track.add(nums[i]);
            used[i] = true;
            permuteHelper(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    private boolean isValidYear(int year) {

        return year >=1 && year <= 2022 ? true : false;
    }

    private boolean isValidMonth(int month) {

        return month >= 1 && month <= 12 ? true : false;
    }

    private boolean isValidDate(LinkedList<Integer> track, int date) {

        List<Integer> month31Days = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> month30Days = Arrays.asList(4, 6, 9, 11);

        if(track.get(1) == 2) {
            if((isLeapYear(track.get(0)) &&  date <= 29 && date >= 1) || (date <= 28 && date >= 1)) {
                return true;
            }
        } else if(month30Days.contains(track.get(1)) && date >= 1 && date <= 30) {
            return true;
        } else if(month31Days.contains(track.get(1)) && date >= 1 && date <= 31) {
            return true;
        }

        return false;
    }

    private boolean isLeapYear(int year) {

        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)) ? true : false;
    }
    public static void main(String[] args) {

        ValidDates validDates = new ValidDates();

        validDates.getValidDates(new int[] {2, 2, 7});
        validDates.getValidDates(new int[] {100, 4 ,3});
        validDates.getValidDates(new int[] {2, 29, 7});
    }
}
