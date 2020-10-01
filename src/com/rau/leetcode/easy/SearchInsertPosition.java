package com.rau.leetcode.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5, 6}, 5));//2
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5, 6}, 2));//1
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5, 6}, 7));//4
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5, 6}, 4));//2
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5, 6}, 0));//0
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5}, 3));//1
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5}, 2));//1
        System.out.println("searchInsert: " + searchInsert(new int[]{1, 3, 5}, 4));//2
        System.out.println("searchInsert: " + searchInsert(new int[]{1}, 1));//0
        System.out.println("searchInsert: " + searchInsert(new int[]{1}, 2));//1
        System.out.println("searchInsert: " + searchInsert(new int[]{1}, 0));//0

    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length, lenMin1 = len - 1, half = len / 2;

        if (len % 2 != 0) {
            if (nums[half] == target || (len > 2 && nums[half - 1] < target && nums[half] > target))
                return half;
            if(len==1 && target< nums[0] )
                return 0;
        }
        for (int i = 0; i < half; i++) {
            if (nums[i] == target || target < nums[i]) {
                return i;
            } else if (nums[lenMin1 - i] == target || (target < nums[lenMin1 - i] && nums[lenMin1 - i - 1] < target)) {
                return lenMin1 - i;
            }
        }
        return len;
    }
}
