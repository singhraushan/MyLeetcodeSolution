package com.rau.leetcode.easy;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("maxSubArray: " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public static int maxSubArray(int[] nums) {
        int max = 0, len = nums.length;
        if (len==0)return 0;
        max = nums[0];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                max = Math.max(max,getSum(nums, i, j));
            }
        }
        return max;
    }

    public static int getSum(int[] nums, int startIndex, int endIndex){
        int sum =0;
        for (int i=startIndex;i<=endIndex;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
