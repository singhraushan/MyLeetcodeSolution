package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Subsets {
    public static void main(String[] args) {
        System.out.println("All possible subSets: " + subsets(new int[]{1, 2, 3}));
    }

    private static List<List<Integer>> lists;
    private static int len;
    private static int[] input;

    public static List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        input = nums;
        len = nums.length;
        subsets(0, new ArrayList<>());
        return lists;
    }

    public static void subsets(int currIndex, List<Integer> list) {
        if (currIndex == len) {
            lists.add(list.stream().filter(Objects:: nonNull).collect(Collectors.toList()));
        } else {
            if (currIndex < list.size())
                list.set(currIndex, null);
            else
                list.add(null);
            subsets(currIndex + 1, list);

            if (currIndex < list.size())
                list.set(currIndex, input[currIndex]);
            else
                list.add(input[currIndex]);
            subsets(currIndex + 1, list);
        }
    }
}
