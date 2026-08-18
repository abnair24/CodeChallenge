package com.abn.dsalgos.algo.twoPointers;

/*
String Compression

Given a character array, replace each run of repeated letters with: the letter, followed by its count (only if count > 1).
Do this in-place — modify the same array, don't build a new one. Return the new length.

['a','a','b','b','c','c','c']  →  ['a','2','b','2','c','3']   (length 6)
['a']                          →  ['a']                        (length 1)

Two things:

1. You're reading and writing the same array at the same time — need to be careful not to overwrite data you haven't read yet.
2. Counts can be more than one digit. If a letter repeats 12 times, you write '1' and '2' as two separate characters, not one digit.

 */
public class StringCompression {

    public int stringCompress(char[] chars) {
        int readPtr = 0;
        int writePtr = 0;
        int len = chars.length;

        while(readPtr < len) {
            char current = chars[readPtr];
            int count = 0;

            while (readPtr < len && chars[readPtr] == current) {
                readPtr++;
                count++;
            }

            chars[writePtr++] = current;

            if(count > 1) {
                for( char digit: String.valueOf(count).toCharArray()) {
                    chars[writePtr++] = digit;
                }
            }
        }
        return writePtr;
    }

    public static void main(String[] args) {

//            char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'c','c','c','c','c','c','c','c','c','c','c','c','a', 'b','b'};
        StringCompression problem3 = new StringCompression();
        int newLength = problem3.stringCompress(chars);
        System.out.println(new String(chars, 0, newLength));

    }
}
