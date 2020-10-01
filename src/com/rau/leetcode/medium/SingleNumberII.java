package com.rau.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println("singleNumber : " + singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println("singleNumber : " + singleNumber(new int[]{0,1,0,1,0,1,99}));
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
