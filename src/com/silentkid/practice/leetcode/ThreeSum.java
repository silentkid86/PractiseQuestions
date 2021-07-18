package com.silentkid.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        LinkedList<List<Integer>> res = new LinkedList<>();

        //go from left to right , fix the first number then get (0 - number)
        //then use 2 pointer closing from each sides to see if it is a pair
        for(int i = 0 ; i < nums.length; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int goal = 0 - nums[i];
                int low = i + 1;
                int high = nums.length - 1;

                while(low < high){

                    if(goal == nums[high] + nums[low]){
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low + 1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high - 1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if(nums[high] + nums[low] > goal){
                        high--;
                    }else{
                        low++;
                    }

                }
            }
        }

        return res;
    }

    public static void main(String[] argz){
        // -4 , -1 , -1 , 0 , 1, 2
        List<List<Integer>> res = threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});

        System.out.println(res);

    }
}
