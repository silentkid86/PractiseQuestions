package com.silentkid.practice.hacker_rank;

import java.util.ArrayList;

public class CloudJumpSolution {

    public static int jumpingOnClouds(int[] c) {
        int i = 0;
        int move_count = 0;
        while(i < c.length - 1){
            int nextBestMove = i + 2;
            if(nextBestMove < c.length && c[nextBestMove] != 1){
                i += 2;
            }else{
                i++;
            }
            move_count++;

        }
        return move_count;

    }

    public static void main(String[] argz){
        int[] arr = { 0,0,1,0,0,1,0 };

        int result= jumpingOnClouds(arr);

        System.out.println(result);
    }
}
