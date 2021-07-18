package com.silentkid.practice.leetcode;

public class medianOfTwoSortedArray {

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int ptr1 = 0 , ptr2 = 0 , currentIdx = 0;
        int[] result = new int[nums1.length + nums2.length];
        while(ptr1 < nums1.length && ptr2 < nums1.length) {
            if(nums1[ptr1] >= nums2[ptr2]){
                result[currentIdx++] = nums2[ptr2++];
            }else{
                result[currentIdx++] = nums1[ptr1++];
            }
        }

        while(ptr1 < nums1.length ){
            result[currentIdx++] = nums1[ptr1++];
        }

        while(ptr2 < nums2.length ){
            result[currentIdx++] = nums2[ptr2++];
        }
        double res = 0.0;
        if(result.length % 2 == 0){
            res = (result[result.length/ 2] + result[(result.length/ 2)+1])/2;
        }else{
            res = result[result.length/ 2];
        }

        return res;
    }



    public static void main(String[] argz){
        double res = findMedianSortedArrays2(new int[]{1,3,4}, new int[]{2,5});
        System.out.println(res);

    }

}
