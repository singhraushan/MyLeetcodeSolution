package com.rau.leetcode.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int len = height.length, lenMinus1 = len - 1, max =0;
        for (int i = 0; i < lenMinus1; i++) {
            for (int j = i + 1; j < len; j++) {
                    max = Math.max(max,(j-i)*(Math.min(height[i],height[j])));
            }
        }
        return max;
    }
}
