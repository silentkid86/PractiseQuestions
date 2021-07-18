package com.silentkid.practice.string;

import java.util.*;

public class LetterComboFromNum {

    static HashMap<Character,List<String>> numToCharMap= new HashMap<>();

    static{
        numToCharMap.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        numToCharMap.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        numToCharMap.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        numToCharMap.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        numToCharMap.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        numToCharMap.put('7', new ArrayList<>(Arrays.asList("p", "q", "r","s")));
        numToCharMap.put('8', new ArrayList<>(Arrays.asList("t", "u","v")));
        numToCharMap.put('9', new ArrayList<>(Arrays.asList("w", "x", "y","z")));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits.length() < 1)
            return new ArrayList<>();

        for(String start : numToCharMap.get(digits.charAt(0))){
            int level = 1;
            StringBuilder sb = new StringBuilder();

            dfsLetter(digits, level,start.charAt(0) , sb , result);
        }


        return result;
    }

    //recursively get result
    private static void dfsLetter(String digits, int level,Character currChar,
                                  StringBuilder sb, List<String> result) {
        // current node action
        sb.append(currChar);

        //terminating leaf
        if(level == digits.length()){
            result.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        //prepare the stack
        for(String start : numToCharMap.get(digits.charAt(level))){
            dfsLetter(digits,level + 1,start.charAt(0),sb,result);
        }

        //clean up before returning back to prev level
        sb.deleteCharAt(sb.length() - 1);

    }

    public static void main(String[] argz){
        List<String> strings = letterCombinations("");
        strings.stream().forEach(s -> System.out.println(s));

    }

}
