package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int res[] = twoSum(new int[]{0,5,5,0}, 0);
        //int res[] = twoSum(new int[]{2,5,5,11}, 10);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] output = new int[]{-1, -1};// return indexes of both couple value
        Map<Integer, Integer> seen = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (seen.containsKey(target - nums[i])) {
                output[0] = seen.get(target - nums[i]);
                output[1] = i;
                return output;
            } else {
                seen.put(nums[i], i);
            }
        }
        return output;
    }

    //2nd way to solve
    /*public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        for (int i=0;i<nums.length;i++) {
            int fst=nums[i];
            int snd=0;
            for (int j=i+1;j<nums.length;j++) {
                snd=nums[j];
                if(snd+fst==target) {
                    //System.out.println("["+i+","+j+"]");
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }*/
}
