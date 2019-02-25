package com.abn.dsalgos.challenges.string;

/*
Print Longest substring without repeating characters
GEEKSFORGEEKSABCDH`
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public String longestSubstring(String str) {

        int len = str.length();
        int currStartIndex = 0;
        int maxStartIndex = 0;
        int currLen = 0;
        int maxLen = 0;

        Map<Character,Integer> map = new HashMap<>();

        for(int i =0;i<len;i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),i);
            } else {
                if(map.get(str.charAt(i)) >= currStartIndex ) {
                    currLen = i - currStartIndex;
                    if(maxLen < currLen) {
                        maxLen = currLen;
                        maxStartIndex = currStartIndex;
                    }

                    currStartIndex = map.get(str.charAt(i)) +1;
                }

                map.put(str.charAt(i),i);
            }
        }
        currLen = (len) - currStartIndex;
        if(maxLen < currLen){
            maxLen = currLen;
            maxStartIndex = currStartIndex;
        }

        return str.substring(maxStartIndex,(maxStartIndex + maxLen));
    }
}
