package com.rau.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println("singleNumber : " + singleNumber(new int[]{2, 2, 1}));
        System.out.println("singleNumber : " + singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> firstTime = new HashSet<>(), secondTime = new HashSet<>();

        for (int temp : nums) {
            if (!secondTime.contains(temp)) {
                if (firstTime.contains(temp)) {
                    secondTime.add(temp);
                    firstTime.remove(temp);
                } else {
                    firstTime.add(temp);
                }
            }
        }
        return firstTime.iterator().next();
    }
}
