package com.silentkid.practice.leetcode;

import com.silentkid.practice.P;

import java.util.Stack;

/*
    1209. Remove All Adjacent Duplicates in String II
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveKDuplicatesFromString {

    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for(int i =0 ; i < sb.length() ; i++){
            //PUSH to stack when it is not same as prev character
            if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)){
                counts.push(1);
            }else{
                //POP from stack if the character is same as prev
                //increments by one because it is same character as prev
                int incremented = counts.pop() + 1;
                if(incremented == k){
                    //this is the target of duplication count
                    //remove from this i till k chars before
                    // if dee[e]f , deleting from 3+1-3 till 3 + 1
                    sb.delete(i + 1 - k , i + 1);
                    //shift i to k earlier
                    // if dee[e]f , after deleted -> df , i = 3 - 3
                    // so that next can be i = 1
                    i = i - k;
                }else{
                    counts.push(incremented);
                }
            }

        }

        return sb.toString();
    }

    public static void main(String[] argz){
        String s = removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println(s);
    }
}
