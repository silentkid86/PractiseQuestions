package com.silentkid.practice.leetcode;

//https://leetcode.com/problems/first-missing-positive/submissions/
public class FirstMissingPositiveNumber {

    public static int firstMissingPositive(int[] nums) {
        // possible range of positive number is
        // 1 ~ N , N + 1

        int n = nums.length;
        //step one , clean up negative number and number < n
        //detect if no 1 exist, return 1;
        boolean oneExist = false;
        for(int i = 0; i < n ; i++){
            if(nums[i] == 1){
                oneExist= true;
            }
            if(nums[i] < 1 || nums[i] > n){
                nums[i] = 1;
            }
        }

        if(!oneExist) return 1;

        //step two : negative marking
        for(int i = 0; i < n ; i++){
            int currIdx = Math.abs(nums[i]) - 1;
            nums[currIdx] = nums[currIdx] > 0 ? -nums[currIdx]: nums[currIdx];
        }

        for(int i = 0; i < n ; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return n + 1;

    }

    public static void main(String[] argz){
        int[] arr = {3,2,-1,4};
        int res = firstMissingPositive(arr);
        System.out.println(res);
    }
}
