package com.silentkid.practice.leetcode;

public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0L ;
        boolean isNegative = false;
        if(x < 0){
            x = Math.abs(x);
            isNegative = true;
        }

        int depth = (int)Math.log10(x);

        long temp = x;
        for(int i = 0 ; i <= depth ; i ++){

            long num = temp / (long)Math.pow(10,depth - i);

            result += num * (long)Math.pow(10,i);

            temp  =  temp % (long)Math.pow(10,depth - i);
        }
        if(isNegative)
            result *= -1;

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return (int)result;
    }

    public static void main(String[] argz){
        int x = reverse(1534236469);
        System.out.println(x);
    }
}
