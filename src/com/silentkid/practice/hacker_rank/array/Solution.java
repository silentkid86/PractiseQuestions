package com.silentkid.practice.hacker_rank.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int normalize_len = 0;
        for(int i = 0 ; i < q.length ; i ++){
            int expectedQueueNum = i + 1 - normalize_len;
            if( expectedQueueNum == q[i]){
                continue;
            }else{
                if(q[i] > expectedQueueNum){
                    if((q[i] - expectedQueueNum + normalize_len) > 2 ){
                        System.out.println("Too chaotic.");
                        break;
                    }else{
                        normalize_len++;
                    }
                }


            }


        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

