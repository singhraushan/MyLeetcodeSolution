package com.rau.leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] r = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int len = nums.length;
        if (len == 0)
            return result;
        if (len == 1) {
            if (nums[0] == target) {
                result[0] = 0;
                result[1] = 0;
            }
            return result;
        }
        int lastIndex = 0;
        for (int i = 0; i < len; i++) {
            if (result[0] != -1 && result[1] != -1)
                break;

            if (nums[i] == target) {
                if (result[0] == -1)
                    result[0] = i;
                lastIndex = i;
            }

            if (nums[i] != target && lastIndex > 0) {
                result[1] = lastIndex;
            }
        }
        if (nums[len - 1] == target)
            result[1] = lastIndex;
        if (result[0] != -1 && result[1] == -1) {
            result[1] = result[0];
        } else if (result[0] == -1 && result[1] != -1) {
            result[0] = result[1];
        }
        return result;
    }
}