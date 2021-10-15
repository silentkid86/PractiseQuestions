package com.silentkid.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){

            String unique = computeUniqueString(str);
            List<String> l = map.getOrDefault(unique,new ArrayList<>());
            l.add(str);
            map.put(unique,l);
        }

        return new ArrayList(map.values());
    }

    //constant way of calculating the key for anagrams
    public static String computeUniqueString(String str){
        int[] chars = new int[26];
        for(char c : str.toCharArray()){
            chars[c - 'a'] ++;
        }

        int i = 0 ;
        StringBuilder sb = new StringBuilder();
        while(i < 26){
            sb.append("#");
            sb.append(chars[i]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] argz){

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ss=groupAnagrams(strs);
    }
}
