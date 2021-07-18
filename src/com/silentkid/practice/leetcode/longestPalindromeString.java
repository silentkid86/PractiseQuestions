package com.silentkid.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class longestPalindromeString {
    public static String longestPalindrome(String str) {
        String result = "";

        //BFS
        Queue<String> q = new LinkedList<>();
        q.add(str);

        while(!q.isEmpty()){
            String s = q.poll();

            if(checkPalindrome(s) && result.length() < s.length()){
                result = s;
            }

            if(s.length() > 1){
                q.add(s.substring(0,s.length() - 1));
                q.add(s.substring(1));
            }

        }


        return result;
    }

    private static boolean checkPalindrome(String s1) {
        StringBuffer sb = new StringBuffer(s1);

        String s2 = sb.reverse().toString();

        return s1.equals(s2);

    }

    public static void main(String[] argx){
        String result = longestPalindrome("abbcccbbbcaaccbababcbcabca");

        System.out.println(result);
    }

}
