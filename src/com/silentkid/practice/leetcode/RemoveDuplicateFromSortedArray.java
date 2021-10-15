package com.silentkid.practice.leetcode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i+1;
    }


    public static void main(String[] argz){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicateFromSortedArray r = new RemoveDuplicateFromSortedArray();
        int length = r.removeDuplicates(nums);

        System.out.println(length);
    }

}
