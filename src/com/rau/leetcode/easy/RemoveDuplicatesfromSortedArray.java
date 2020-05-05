package com.rau.leetcode.easy;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        System.out.println("removeDuplicates: " + removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int modifiedLength = 1, length = nums.length;
        int prev = nums[0];
        for (int i = 1; i < length; i++) {
            if (!(prev == nums[i])) {
                prev = nums[i];
                nums[modifiedLength] = nums[i];
                modifiedLength++;
            } else {
                prev = nums[i];
            }

        }
        return modifiedLength;
    }


}
