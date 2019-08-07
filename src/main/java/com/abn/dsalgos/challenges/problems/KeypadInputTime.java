package com.abn.dsalgos.challenges.problems;

import java.util.*;

/*
Program to find the time taken to enter a secret password of 4 digits from key pad containing 9 digits. Keypad layout keeps on
changing at any given time.

Time taken to press same number : 0 sec
Time taken to press adjacent number : 1 sec
Time taken to press all other number  : 2sec

Keypad : 9 4 5
         1 3 7
         2 6 8

Secret : 5388
 time :  0 + 1 + 1 + 0 = 2 sec

Secret : 9852
time  :  0 + 2 + 2+ 2 = 6 sec.
 */

public class KeypadInputTime {

    public int keyEntryTime(String secret, String keypad) {
        if(secret == null || secret.length() ==0){
            return 0;
        }

        char[] chars = keypad.toCharArray();
        Map<Character, Set<Character>> map = new HashMap<>();
        List<Character[]> list = new ArrayList<>();
        list.add(new Character[]{chars[1],chars[3],chars[4]});
        list.add(new Character[]{chars[0],chars[2],chars[3],chars[4],chars[5]});
        list.add(new Character[]{chars[1], chars[4], chars[5]});
        list.add(new Character[]{chars[0], chars[1], chars[4], chars[6], chars[7]});
        list.add(new Character[]{chars[0], chars[1], chars[2], chars[3], chars[5], chars[6], chars[7], chars[8]});
        list.add(new Character[]{chars[1], chars[2], chars[4], chars[7], chars[8]});
        list.add(new Character[]{chars[3], chars[4], chars[7]});
        list.add(new Character[]{chars[3], chars[4], chars[5], chars[6], chars[8]});
        list.add(new Character[]{chars[4], chars[5], chars[7]});

        for(int i = 0;i<keypad.length();i++){
            char c = keypad.charAt(i);
            map.put(c,new HashSet<>(Arrays.asList(list.get(i))));
        }
        int steps = 0;
        char ch = secret.charAt(0);
        for(int i = 1; i<secret.length();i++){
            char num = secret.charAt(i);
            if(ch == num ){
                continue;
            }
            if(map.get(ch).contains(num)){
                steps += 1;
            } else {
                steps += 2;
            }

            ch = num;
        }
        return steps;
    }
}
