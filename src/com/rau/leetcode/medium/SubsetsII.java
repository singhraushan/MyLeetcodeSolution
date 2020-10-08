package com.rau.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsII {
    public static void main(String[] args) {
        List<List<Integer>> res = subsetsWithDup(new int[]{4, 4, 4, 1,4});
        //List<List<Integer>> res = subsetsWithDup(new int[]{1, 2, 2});
        res.stream().forEach(e -> System.out.println(e));
        System.out.println("----------");
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        finalAllSubSet(nums, nums.length, 0, new ArrayList<>(), result, new HashSet<>());
        return result;
    }

    private static void finalAllSubSet(int[] nums, int len, int index, List<Integer> currentList, List<List<Integer>> collectedResult, Set<String> seen) {
        if (len == index) {
            List<Integer> nonNullCurrentList = currentList.stream().filter(Objects::nonNull).sorted().collect(Collectors.toList());
            String hashCode = nonNullCurrentList.toString();
            if(!seen.contains(hashCode)){
                seen.add(hashCode);
                collectedResult.add(nonNullCurrentList);
            }

        } else {
            if (currentList.size() > index)
                currentList.set(index, null);
            else currentList.add(null);
            finalAllSubSet(nums, len, index + 1, currentList, collectedResult,seen);

            if (currentList.size() > index)
                currentList.set(index, nums[index]);
            else currentList.add(nums[index]);
            finalAllSubSet(nums, len, index + 1, currentList, collectedResult,seen);
        }
    }
}
