package com.silentkid.practice.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomSortString {

    public static String customSortString(String S, String T) {
        StringBuilder result = new StringBuilder();
        StringBuilder nonS = new StringBuilder();
        //can be a int[26] to represents this map use constant space
        HashMap<Character,Integer> map =  new HashMap<>();

        for( char c : T.toCharArray()){
            if(map.containsKey(c)){
                int freq=map.get(c);
                map.put(c,freq+1);
            }else{
                map.put(c,1);
            }
        }

        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                for (int i = 0;i< map.get(c); i++){
                    result.append(c);
                }
                map.remove(c);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            for (int i = 0;i< next.getValue(); i++){
                nonS.append(next.getKey());
            }

        }

        return result.append(nonS).toString();
    }


    public static void main(String[] argz) {
        String l = customSortString("ef" , "abcd");
        System.out.println(l);
    }
}
