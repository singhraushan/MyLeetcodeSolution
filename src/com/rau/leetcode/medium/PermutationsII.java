package com.rau.leetcode.medium;

import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permuteUnique(nums, 0, nums.length - 1,new HashSet<>(), lists);
        return lists;
    }

    private static void permuteUnique(int[] nums, int startIndex, int endIndex, Set<String> seen, List<List<Integer>> lists) {
        if (startIndex == endIndex) {
                List<Integer> list = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for(int n: nums){
                    list.add(n);
                    sb.append(n);
                }
               String uniueCode = sb.toString();
                if(!seen.contains(uniueCode)) {
                    lists.add(list);
                    seen.add(uniueCode);
                }
        } else {
            for (int i = startIndex; i <= endIndex; i++) {
                swap(nums, startIndex, i);
                permuteUnique(nums, startIndex + 1, endIndex, seen ,lists);
                swap(nums, startIndex, i);
            }
        }
    }

    private static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
