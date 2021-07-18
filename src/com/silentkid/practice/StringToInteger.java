package com.silentkid.practice;

import java.util.LinkedList;
import java.util.Queue;

public class StringToInteger {

    public static int myAtoi(String s) {
        boolean isPositivitySet = false;
        boolean isNegative = false;

        int pointer = 0;
        Queue<Character> ss = new LinkedList<>();
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            pointer++;
            if (c == ' ') {
                continue;
            }
            if(c == '+'){
                if(!isPositivitySet){
                    isNegative = false;
                    isPositivitySet = true;
                    continue;
                }else{
                    break;
                }

            }
            if (c == '-') {
                if(!isPositivitySet){
                    isNegative = true;
                    isPositivitySet = true;
                    continue;
                }else{
                    break;
                }

            }
            if (c - '0' < 0 || c - '9' > 0) {
                break;
            }else{
                ss.offer(c);
            }
        }
        long sum = 0L;
        int digit_count = ss.size();
        while(!ss.isEmpty()){
            char c = ss.poll();
            long currentDigit=Character.getNumericValue(c);
            sum += currentDigit * (long) Math.pow(10,digit_count - 1);
            digit_count--;
        }

        if(isNegative) {
            sum = sum * -1L;
        }

        if(sum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if(sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)sum;
    }


    public static void main(String[] argz) {
        //result must be within [-231, 231 - 1]
        //-91283472332  -> -2147483648
        //+123
        //   -42   -> -42
        //4193 with words
        //words and 987   -> 0
        int l = myAtoi("+-23");
        System.out.println(l);
    }
}
