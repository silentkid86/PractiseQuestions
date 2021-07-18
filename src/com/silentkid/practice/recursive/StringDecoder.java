package com.silentkid.practice.recursive;

import java.util.Stack;
import java.util.stream.IntStream;

public class StringDecoder {
//    Given an encoded string, return its decoded string.
//
//    The encoding rule is: k[encoded_string], where the encoded_string inside the
//    square brackets is being repeated exactly k times. Note that k is guaranteed
//    to be a positive integer.
//
//    You may assume that the input string is always valid; No extra white spaces,
//    square brackets are well-formed, etc. Furthermore, you may assume that the original
//    data does not contain any digits and that digits are only for those repeat numbers,
//    k. For example, there won't be input like 3a or 2[4].

    //2[ab3[c]] => abcccabccc
    public static String decodeString(StringBuilder input, int repeat){
        StringBuilder repeatStrCnt = new StringBuilder();
        StringBuilder decodedResult = new StringBuilder();
        StringBuilder subLevelSb = new StringBuilder();
        int level = 0;
        for(int i = 0 ; i < input.length() ; i++){
            char c = input.charAt(i);

            if(c >= '0' && c <= '9' ){
                if(level == 0){
                    repeatStrCnt.append(c);
                }else{
                    subLevelSb.append(c);
                }
                continue;
            }

            if(c == '['){
                if(level > 0) {
                    subLevelSb.append(c);
                }
                level++;

                continue;
            }
            if(c == ']'){
                level--;
                if(level == 0){
                    int rpt = Integer.parseInt(repeatStrCnt.toString());
                    decodedResult.append(decodeString(subLevelSb,rpt));
                    repeatStrCnt = new StringBuilder();
                    subLevelSb = new StringBuilder();
                }else{
                    subLevelSb.append(c);
                }

                continue;
            }

            if(level > 0) {
                subLevelSb.append(c);
                continue;
            }
            decodedResult.append(c);

        }

        //repeating as many as needed
        StringBuilder result = new StringBuilder();
        for(int i = repeat ; i > 0 ; i--){
            result.append(decodedResult.toString());
        }
        return result.toString();

    }



    public static void main(String args[]) {
        String input= "2[ab3[c]]a2[d]";

        String output = decodeString(new StringBuilder(input),1);

        System.out.println(output);
    }

}
