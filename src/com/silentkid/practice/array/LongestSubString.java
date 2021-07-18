package com.silentkid.practice.array;

import java.util.*;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> uniqueMap = new HashMap<Character, Integer>();
        int longestStreak = 0;
        int subStringStartPt= 0;

        for(int i = 0;i < s.length() ; i++){
            Character c = s.charAt(i);

            if(uniqueMap.containsKey(c)){
                subStringStartPt = Math.max(subStringStartPt, uniqueMap.get(c));
            }

            uniqueMap.put(c,i+1);
            longestStreak = Math.max(i  - subStringStartPt + 1,longestStreak);
        }

        return longestStreak;
    }

    public static void main(String[] argz){
        int l = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(l);
        //tmmzuxt
        //pwwkew
        //advadf
        //abcabcbb
        //au
    }
}
