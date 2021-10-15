package com.silentkid.practice.leetcode;
/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 */

public class RemoveDuplicatesFromString {
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        char prevChar = ' ';
        for(char character : s.toCharArray()) {

            if(sb.length() == 0 || character != sb.charAt(sb.length() - 1)){
                if(prevChar == character)
                    continue;
                sb.append(character);
            }else{
                sb.deleteCharAt(sb.length() - 1);
            }

            prevChar = character;
        }
        return sb.toString();

    }

    public static void main(String[] argz){
        String s = removeDuplicates("deeedbbcccbdaa");
        System.out.println(s);
    }
}
