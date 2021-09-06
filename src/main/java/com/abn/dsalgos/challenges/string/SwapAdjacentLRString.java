package com.abn.dsalgos.challenges.string;

/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either
replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR".
Given the starting string start and the ending string end,
return True if and only if there exists a sequence of moves to transform one string to the other.

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX

Input: start = "X", end = "L"
Output: false

Input: start = "LLR", end = "RRL"
Output: false
 */

public class SwapAdjacentLRString {

    public boolean canTransform(String start, String end) {
        int startLen = start.length();
        int endLen = end.length();

        if (startLen != endLen) {
            return false;
        }

        if (startLen == 1) {
            if (start.charAt(0) == end.charAt(0)) {
                return true;
            } else {
                return false;
            }
        }

        int startPtr = getPos(start, 0);
        int endPtr = getPos(end, 0);

        while (startPtr < startLen && endPtr < startLen) {
            char sChar = start.charAt(startPtr);
            char eChar = end.charAt(endPtr);

            if (sChar != eChar) {
                return false;
            }

            if (sChar == 'R' && endPtr < startPtr) {
                return false;
            }

            if (sChar == 'L' && endPtr > startPtr) {
                return false;
            }

            startPtr = getPos(start, ++startPtr);
            endPtr = getPos(end, ++endPtr);
        }
        return startPtr == endPtr;
    }

    private int getPos(String str, int i) {
        while (i < str.length()) {
            if (str.charAt(i) != 'X') {
                return i;
            }
            i++;
        }
        return i;
    }
}
