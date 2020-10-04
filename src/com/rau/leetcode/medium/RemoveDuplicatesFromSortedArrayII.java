package com.rau.leetcode.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        nums = new int[]{1, 1, 1};
        len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1, prev, len = nums.length, res = len;
        if (len == 0) {
            return 0;
        }
        prev = nums[0];
        for (int i = 1; i < res; i++) {
            if (nums[i] == prev) {
                count++;
            } else {
                count = 1;
                prev = nums[i];
            }

            if (count > 2) {
                shiftAndMove(nums, i + 1, prev);
                res--;
                i--;
            }
        }
        return res;
    }

    private static void shiftAndMove(int[] nums, int startIndex, int move) {
        int len = nums.length;
        for (int i = startIndex; i < len; i++) {
            nums[i - 1] = nums[i];
        }
        nums[len - 1] = move;
    }
}
