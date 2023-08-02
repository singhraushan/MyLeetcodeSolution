package com.rau.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class JumpGameII {

    public static void main(String[] args) {
        System.out.println("min:" + jump(new int[]{1, 2, 1, 1, 1}));
        /*min = Integer.MAX_VALUE;
        System.out.println("min:" + jump(new int[]{2, 3, 1, 1, 4}));
        min = Integer.MAX_VALUE;
        System.out.println("min:" + jump(new int[]{2, 3, 0, 1, 4}));
         */
    }

    private static int min = Integer.MAX_VALUE;

    public static int jump(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        dfs(nums, 0, 0, memo);
        System.out.println(memo);
        return min;
    }

    private static int dfs(int[] nums, int index, int curCount, Map<Integer, Integer> memo) {
        /*if (memo.get(index) != null) {
            return memo.get(index);
        }*/
        if (index == nums.length - 1) {
            min = Math.min(min, curCount);
            return min;
        }
        if (index >= nums.length) {
            return 0;
        }
        int maxJump = nums[index], curMin = Integer.MAX_VALUE;

        for (int i = 1; i <= maxJump; i++) {
            int v = dfs(nums, index + i, curCount +1, memo);
            System.out.println("index:"+index+"---curMin:"+curMin+"--v:"+v+"--curCount:"+curCount);
            curMin = Math.min(curMin, v);
        }
        memo.put(index, curMin);
        return min;
    }
}
