package com.abn.scalar.dsa.day17;

public class LongestPalidromicSubstring {

    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around the current character to find the longest odd-length palindrome.
            int[] oddLength = expandAroundCenter(s, i, i);

            // Expand around the current and next character to find the longest even-length palindrome.
            int[] evenLength = expandAroundCenter(s, i, i + 1);

            // Determine the current longest palindrome based on odd and even lengths.
            int[] currentPalindrome = (oddLength[0] > evenLength[0]) ? oddLength : evenLength;

            // Update the maximum palindrome information if the current palindrome is longer.
            if (currentPalindrome[0] > maxLength) {
                maxLength = currentPalindrome[0];
                start = currentPalindrome[1];
                end = currentPalindrome[2];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(s.charAt(i));  // Build the result string with the longest palindrome.
        }

        return result.toString();  // Return the longest palindrome substring.
    }

    public int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return new int[] { right - left - 1, left + 1, right - 1 };  // Return palindrome length and indices.
    }

    public static void main(String[] args) {


        LongestPalidromicSubstring longestPalidromicSubstring = new LongestPalidromicSubstring();
        System.out.println(longestPalidromicSubstring.longestPalindrome("aaaabaaa"));
    }
}
