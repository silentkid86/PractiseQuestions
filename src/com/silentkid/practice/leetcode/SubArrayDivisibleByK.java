package com.silentkid.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers and an integer K,
 * find the number of subarrays whose sums are divisible by K.
 */
public class SubArrayDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int ansCount = 0;
        int sum = 0;

        map.put(0,1);
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            int rem = sum % k;
            int remainder = ( k - rem) % k  ;

            if(map.containsKey(remainder)){
                ansCount += map.get(remainder);
                map.replace(remainder,map.get(remainder)+1);
            }else {
                map.put(remainder,1);
            }
        }

        return ansCount;

    }


    public static void main(String[] argz){
        int res = subarraysDivByK(new int[]{3, 1, 2, 5, 1},3);

        System.out.println(res);
    }
}
