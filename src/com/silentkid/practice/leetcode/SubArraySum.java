package com.silentkid.practice.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/*
Given an array of integers and an integer target, find a subarray that sums to target and returns
the start and end indices of the subarray. It’s guaranteed to have a unique solution.
 */
public class SubArraySum {
    //SubArray : [i , j)
    public static int[] subarraySum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //sum_till_now : index

        int sum = 0;
        map.put(0,0);
        for(int i=0;i < arr.length ; i++){
            sum += arr[i];
            if(map.containsKey(sum - target)){
                return new int[]{map.get(sum - target) , i + 1};
            }
            map.put(sum,i + 1);
        }


        return null;
    }

    public static void main(String[] argz){
        int[] result = subarraySum(new int[]{1,3,-3,8,5,7},5);
        for(int res : result)
            System.out.println(res);
    }
}
