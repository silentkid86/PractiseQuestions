package com.silentkid.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        HashMap<Character, Integer> tmap = new HashMap<>();
        int tLen = 0;
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
            tLen++;
        }

        int sl = 0;
        int sr = 0;
        HashMap<Character, Integer> wmap = new HashMap<>();
        int wLen = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (sr < s.length()) {
            char c = s.charAt(sr);
            wmap.put(c, wmap.getOrDefault(c, 0) + 1);
            if (tmap.containsKey(c) && wmap.get(c).intValue() <= tmap.get(c).intValue()) {
                wLen++;
                if (wLen == tLen ) {
                    //record result
                    String l = s.substring(sl, sr + 1);
                    if (l.length() < minLen) {
                        res = l;
                        minLen = l.length();
                    }
                }

            }

            while (sl <= sr && wLen == tLen) {
                char cl = s.charAt(sl);
                if (wLen == tLen ) {
                    //record result
                    String l = s.substring(sl, sr + 1);
                    if (l.length() < minLen) {
                        res = l;
                        minLen = l.length();
                    }
                }

                wmap.put(cl, wmap.get(cl) - 1);
                if (tmap.containsKey(cl) && wmap.get(cl).intValue() < tmap.get(cl).intValue()) {
                    wLen--;
                }

                sl++;
            }
            sr++;
        }


        return res;
    }

    public static void main(String[] args) {
        String res = minWindow("abba", "abb");
        System.out.println(res);

        LinkedList<Integer> l = new LinkedList<>();
        l.stream().toArray(Integer[]::new);
    }
}
