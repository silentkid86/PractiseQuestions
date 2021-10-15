package com.silentkid.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class KDistinctCharactersWindow {

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int l = 0;
        int r = 0;
        int maxSize = 0 ;

        HashSet<Character> cSet = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);
            //shift L when set has the current Char until R
            while(l < r && cSet.contains(c)){
                char cl = s.charAt(l);
                cSet.remove(cl);
                l++;
            }

            cSet.add(c);

            maxSize = Math.max(maxSize,r - l  + 1 );

            r++;
        }

        return maxSize;
    }

    public static void main(String[] argz){
        String input = "abccabcabcc";
        int res =longestSubstringWithoutRepeatingCharacters(input);

        System.out.println(res);
    }
}
