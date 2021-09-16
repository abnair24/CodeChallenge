package com.abn.dsalgos.algo.dp;

import com.abn.dsalgos.utils.Pair;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

/*
You have a keyboard layout as shown above in the X-Y plane, where each English uppercase letter is located at some coordinate.

For example, the letter 'A' is located at coordinate (0, 0), the letter 'B' is located at coordinate (0, 1), the letter 'P' is
located at coordinate (2, 3) and the letter 'Z' is located at coordinate (4, 1).
Given the string word, return the minimum total distance to type such string using only two fingers.

The distance between coordinates (x1, y1) and (x2, y2) is |x1 - x2| + |y1 - y2|.

Note that the initial positions of your two fingers are considered free so do not count towards your total distance,
also your two fingers do not have to start at the first letter or the first two letters.

Input: word = "CAKE"
Output: 3
Explanation:
Using two fingers, one optimal way to type "CAKE" is:
Finger 1 on letter 'C' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
Finger 2 on letter 'K' -> cost = 0
Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
Total distance = 3

 */
public class MinimumDistanceWordKeyboard {

    String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";

    // Each character has an option to opt for F1 or F2 at any point.
    // Also every character has equal possibility for becoming starting point for f1 / f2.

    // When f1 / f2 is not starting point at a character, find the abs distance between previous and current char
    // If char is starting point for f1 / f2, previous distance is zero

    public int minimum(String word) {

        Map<Character, Pair> map = generateAlphabetMap();

        char[] array = word.toLowerCase().toCharArray();

        Map<String, Integer> cache = new HashMap<>();

        return helper(array, map, 0, new Pair(-1, -1), new Pair(-1, -1), cache);
    }

    private int helper(char[] array, Map<Character, Pair> map, int index, Pair f1Pos, Pair f2Pos, Map<String, Integer> cache) {

        int total = 0;
        int f1Distance;
        int f2Distance;

        if (index == array.length) {
            return total;
        }

        String key = index + "-" + f1Pos + "-" + f2Pos;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Pair position = map.get(array[index]);

        if (f1Pos.row == -1 && f1Pos.col == -1) {
            f1Distance = helper(array, map, index + 1, position, f2Pos, cache);
        } else {
            f1Distance = Math.abs(f1Pos.row - position.row) + Math.abs(f1Pos.col - position.col) +
                    helper(array, map, index + 1, position, f2Pos, cache);
        }

        if (f2Pos.row == -1 && f2Pos.col == -1) {
            f2Distance = helper(array, map, index + 1, f1Pos, position, cache);
        } else {
            f2Distance = Math.abs(f2Pos.row - position.row) + Math.abs(f2Pos.col - position.col) +
                    helper(array, map, index + 1, f1Pos, position, cache);
        }

        int min = total + Math.min(f1Distance, f2Distance);
        cache.put(key, min);

        return total + Math.min(f1Distance, f2Distance);
    }

    private Map<Character, Pair> generateAlphabetMap() {

        Map<Character, Pair> map = new HashMap<>();
        int rows = 6;
        int cols = 6;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {

                char ch = ALPHABETS.charAt(i * 6 + j);
                map.put(ch, new Pair(i, j));
                if (ch == 'z') {
                    return map;
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {

        MinimumDistanceWordKeyboard minimumDistanceWordKeyboard = new MinimumDistanceWordKeyboard();
        Assert.assertEquals(minimumDistanceWordKeyboard.minimum("happy"), 6);
        Assert.assertEquals(minimumDistanceWordKeyboard.minimum("new"), 3);
        Assert.assertEquals(minimumDistanceWordKeyboard.minimum("year"), 7);
        Assert.assertEquals(minimumDistanceWordKeyboard.minimum("CAKE"), 3);
        Assert.assertEquals(minimumDistanceWordKeyboard.minimum("khxkw"), 7);
    }
}
