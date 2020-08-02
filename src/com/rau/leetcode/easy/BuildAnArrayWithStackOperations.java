package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        //System.out.println(buildArray(new int[]{1,3},3));
        //System.out.println(buildArray(new int[]{1,2,3},3));
        //System.out.println(buildArray(new int[]{1,2},4));
        System.out.println(buildArray(new int[]{2, 3, 4}, 4));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int len = target.length, j = 0;

        for (int i = 1; i <= n && j < len; i++) {
            list.add("Push");
            for (int k = j; k < len; k++) {
                if (target[k] == i) {
                    j++;
                    break;
                } else if (k == len - 1) {
                    list.add("Pop");
                }
            }
        }
        return list;
    }
}
