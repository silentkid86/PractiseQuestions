package com.silentkid.practice.leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        //Binary Search in the search space
        // 1 ~ N
        // in the range of this each number should only have
        // equal or less number that is smaller or equals of itself
        // for array   1 2 3 4 5 5
        //             1 2 3 4 6 6
        // l and h pointer is for indexes in the range
        int l = 1;
        int h = nums.length;
        int dup = -1;
        while(l <= h){
            int mid = l + (h - l) /2;
            int count = 0;
            for(int i : nums){
                if(i <= mid){
                    count++;
                }
            }

            if(count > mid){
                //go left
                dup = mid;
                h = mid - 1;
            }else{
                //go right
                l = mid + 1;
            }

        }
        return dup;
    }

    public static void main(String[] argx){
        int[] arr = {1,3,4,2,2};
        int a=findDuplicate(arr);
        System.out.println(a);
    }
}
