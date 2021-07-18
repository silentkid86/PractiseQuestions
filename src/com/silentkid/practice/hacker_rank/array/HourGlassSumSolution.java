package com.silentkid.practice.hacker_rank.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlassSumSolution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        MaxResult maxResult = new MaxResult();

        int len = arr.length;

        for(int i = 0 ; i < len - 2 ; i ++){
            for (int j = 0 ; j < len - 2 ; j ++){
                int sum = 0;

                sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2];
                sum = sum + arr[i+1][j+1];
                sum = sum + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                maxResult.setMax_sum(sum);
            }

        }


        return maxResult.getMax_sum();
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] strs =  new String[6];

        strs[0]="1 1 1 0 0 0";
        strs[1]="0 1 0 0 0 0";
        strs[2]="1 1 1 0 0 0";
        strs[3]="0 0 2 4 4 0";
        strs[4]="0 0 0 2 0 0";
        strs[5]="0 0 1 2 4 0";

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = strs[i].split(" ");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);
    }

    static class MaxResult {
        int max_sum = Integer.MIN_VALUE;

        public void setMax_sum(int candidate) {
            if(candidate > max_sum)
                this.max_sum = candidate;
        }

        public int getMax_sum() {
            return max_sum;
        }
    }
}

