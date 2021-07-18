package com.silentkid.practice.leetcode;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int ptr = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(ptr < nums.length){
            int current = nums[ptr];
            map.put(current,ptr);

            Integer idx = map.get((target - current));

            if(idx!=null && ptr != idx){
                //solution found
                return new int[]{ptr, idx};
            }

            ptr++;
        }

        return null;
    }

    public static void main(String[] argz){
        int[] res = twoSum(new int[]{3,2,4}, 6);
        System.out.println(res);

    }
}
