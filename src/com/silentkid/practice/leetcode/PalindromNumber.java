package com.silentkid.practice.leetcode;

public class PalindromNumber {

    public static boolean isPalindrome(int x) {

        if(x < 0)
            return false;

        int digits = (int)Math.log10(x);
        digits += 1;
        int middle = digits / 2 - 1;
        for(int i = 0 ; i <= middle ; i ++){
            //front
            int front_num = ( x / (int)Math.pow(10,digits - i - 1) ) % 10;
            //back
            int back_num = ( x / (int)Math.pow(10,i) ) % 10;

            if(front_num != back_num){
                return false;
            }

        }

        return true;

    }

    public static void main(String[] argz){
        boolean x = isPalindrome(1231);
        System.out.println(x);
    }
}
