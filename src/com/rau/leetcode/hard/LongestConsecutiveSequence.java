package com.rau.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println("res: " + longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {

        int len = nums.length;
        if (len < 1)
            return 0;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int v: nums) {
            map.put(v, false);
        }
        int max = 1;
        for (int v: nums) {
            int tempCount = 1,prev = v - 1,next = v + 1;
            while (map.containsKey(prev) && !map.get(prev)) {
                    map.put(prev, true);
                    ++tempCount;
                    --prev;
            }
            while (map.containsKey(next) && !map.get(next)) {
                    map.put(next, true);
                    ++tempCount;
                    ++next;
            }
            max = Math.max(max, tempCount);
        }
        return max;
    }
}
