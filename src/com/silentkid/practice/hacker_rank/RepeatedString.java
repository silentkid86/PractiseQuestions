package com.silentkid.practice.hacker_rank;

import com.silentkid.practice.P;

public class RepeatedString {

    static long repeatedString(String s, long n) {

        long str_length = s.length();

        long repeated_count = n / str_length;

        long left = n % str_length;

        long a_repeated = 0L;
        long left_recurrence = 0L;

        for(int i = 0 ; i < str_length ; i++){
            if(s.charAt(i) == 'a'){
                if(i < left){
                    left_recurrence = left_recurrence + 1L;
                }
                a_repeated = a_repeated + 1L;
            }
        }

        return (a_repeated * repeated_count)+ left_recurrence ;

    }

    public static void main(String[] argz){
        long result = repeatedString("aba",10);

        System.out.println(result);
    }
}
