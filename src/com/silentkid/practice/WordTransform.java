package com.silentkid.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordTransform {

    public static List<String> solve(String start, String end){
        // tried word with its result
        HashMap<String,Boolean> dict = new HashMap<>();
        List<String> results = new ArrayList<>();

        //start needs to be part of the result
        results.add(start);

       //TEAL -> TELL -> TALL


        for(int i = 0 ; i < start.length() ; i ++){
            // if START and HEAD has a diff on this character
            // proceed try this position
            // else
            // skip

            //try with all alphabets with the diff position
            for(int j = 0; j < 26 ; j++){
                char c  = (char) ('A' + j);
                //same character
                if(start.charAt(i) == c){
                    continue;
                }
                String transformed = start.replace(start.charAt(i), c);
                if(end.equals(transformed)){
                    results.add(transformed);
                    break;
                }
                if(!dict.containsKey(transformed)){
                    dict.put(transformed,isWord(transformed));
                }else{
                    continue;
                }



            }

        }
        return results;

    }

    public static boolean isWord(String s){
        //mock
        return true;

    }

}
