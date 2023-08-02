package com.rau.leetcode.test;

import java.util.*;
import java.util.stream.IntStream;

public class MovingTotal {
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    private Set<Integer> threeSumSet = new HashSet<>();
    private List<Integer> allAppendedValues = new ArrayList<>();
    public void append(int[] list) {
        for(int v: list){
            allAppendedValues.add(v);
        }
        threeSum(allAppendedValues);
    }

    private void threeSum(List<Integer> nums) {
        int len = nums.size();
        for (int i = 0; i+2 < len; i++) {
            threeSumSet.add(nums.get(i) + nums.get(i+1) + nums.get(i+2));
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        return threeSumSet.contains(total);
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));        
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }


    {
        int[] arr = new int[]{1,2,3};
        int res = IntStream.of(arr).filter(i->i>5).map(i->i*3).sum();
    }
}