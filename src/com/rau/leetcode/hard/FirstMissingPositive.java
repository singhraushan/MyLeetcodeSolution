package com.rau.leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("firstMissingPositive: "+firstMissingPositive(new int[]{1,2,0}));
        System.out.println("firstMissingPositive: "+firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println("firstMissingPositive: "+firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i = 1;
        while (seen.contains(i)) i++;
        return i;
    }
}
