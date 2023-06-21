package com.abn.dsalgos.challenges.problems;

/*
https://leetcode.com/problems/next-greater-element-iii/editorial/

Given a number, find the next highest number possible with same set of digits.

Eg: 12
o/p: 21

Eg: 25876
o/p: 26578

Eg: 21
o/p: -1

 */
public class NextLargerNumber {

    public int nextLarger(int number) {

        char[] digits = ("" + number).toCharArray();

        int index = digits.length - 2;
        while (index >= 0 && (int) digits[index] >= (int) digits[index + 1]) {
            index --;
        }

        if (index < 0) {
            return -1;
        }

        int dipIndex = index;

        index = digits.length - 1;
        while ((int) digits[index] <= (int) digits[dipIndex]) {
            index --;
        }

        int swapIndex = index;
        char[] swappedArray = swap(digits, swapIndex, dipIndex);
        StringBuilder reversedStringBuilder = reverse(swappedArray, dipIndex);

        for (index = dipIndex; index >= 0; index --) {
            reversedStringBuilder.insert(0, swappedArray[index]);
        }

        // Try-catch to handle case of : 2147483648 in LC

        try {
           return Integer.parseInt(reversedStringBuilder.toString());
        } catch (Exception ex) {
            return -1;
        }
    }

    private char[] swap(char[] digits, int swapIndex, int dipIndex) {

        char tempChar = digits[swapIndex];

        digits[swapIndex] = digits[dipIndex];
        digits[dipIndex] = tempChar;
        return digits;
    }

    private StringBuilder reverse(char[] swapped, int dipIndex) {

        StringBuilder sb = new StringBuilder();
        for (int index = swapped.length - 1; index > dipIndex; index--) {
            sb.append(swapped[index]);
        }
        return sb;
    }

    public static void main(String[] args) {
        NextLargerNumber nextLargerNumber = new NextLargerNumber();
        System.out.println(nextLargerNumber.nextLarger(21));
        System.out.println(nextLargerNumber.nextLarger(218765));
        System.out.println(nextLargerNumber.nextLarger(269542));
    }
}
