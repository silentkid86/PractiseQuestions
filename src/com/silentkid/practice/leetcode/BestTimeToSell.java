package com.silentkid.practice.leetcode;

import com.silentkid.practice.P;

public class BestTimeToSell {

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0 ; i <prices.length ; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }

        return maxProfit;

    }

    public static void main(String[] argx){
        int result = maxProfit(new int[]{7,1,5,3,6,4});

        System.out.println(result);
    }
}
