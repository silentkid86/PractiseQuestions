package com.silentkid.practice.leetcode;

import java.util.HashMap;

public class NumberToWords {

    static HashMap<Integer,String> map = new HashMap<>();

    public static void main(String[] argx){
        String result = numberToWords(11205);

        System.out.println(result);
    }


    public static String numberToWords(int num) {
        putStrings(map);
        if(num == 0) return "Zero";

        int lvl = (int)Math.log10(num)/3;

        String result = getWordFor(num , lvl, 0);

        return result;
    }

    private static String getWordFor(int num, int maxlevel, int pw){
        if(pw > maxlevel) return "";

        String deno = "";
        if(pw==1){
            deno = " Thousand ";
        }
        if(pw==2){
            deno = " Million ";
        }
        if(pw==3){
            deno = " Billion ";
        }
        return getWordFor(num / 1000, maxlevel , pw + 1) + getHundred(num % 1000) + deno;

    }

    private static String getHundred(int num) {
        if(num == 0) return "";
        StringBuffer sb = new StringBuffer();

        if(num / 100 > 0){
            int hundredDigit= num / 100;
            sb.append(map.get(hundredDigit));
            sb.append(" ");
            sb.append("Hundred");
            sb.append(" ");
        }
        int twoDigit = num % 100;
        if(twoDigit < 20){
            sb.append(map.get(twoDigit));
        }else{
            sb.append(map.get(twoDigit/10 * 10));
            sb.append(" ");
            sb.append(map.get(twoDigit%10));
        }


        return sb.toString();
    }

    public static void putStrings(HashMap < Integer, String > hm) {
        hm.put(1, "One");
        hm.put(2, "Two");
        hm.put(3, "Three");
        hm.put(4, "Four");
        hm.put(5, "Five");
        hm.put(6, "Six");
        hm.put(7, "Seven");
        hm.put(8, "Eight");
        hm.put(9, "Nine");
        hm.put(10, "Ten");
        hm.put(11, "Eleven");
        hm.put(12, "Twelve");
        hm.put(13, "Thirteen");
        hm.put(14, "Fourteen");
        hm.put(15, "Fifteen");
        hm.put(16, "Sixteen");
        hm.put(17, "Seventeen");
        hm.put(18, "Eighteen");
        hm.put(19, "Nineteen");
        hm.put(20, "Twenty");
        hm.put(30, "Thirty");
        hm.put(40, "Forty");
        hm.put(50, "Fifty");
        hm.put(60, "Sixty");
        hm.put(70, "Seventy");
        hm.put(80, "Eighty");
        hm.put(90, "Ninety");
    }

    //One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One
}
