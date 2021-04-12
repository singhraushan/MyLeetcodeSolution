package com.rau.leetcode.medium;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));//4
        System.out.println(rob(new int[]{2,7,9,3,1}));//12
        System.out.println(rob(new int[]{2,1,1,2}));//4
        System.out.println(rob(new int[]{1,7,2,1,9,1}));//16
    }
    public static int rob(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            map.computeIfAbsent(i,k->nums[k]);
            for(int j=i+2;j<len;j++){
                if(map.get(j)==null){
                    map.put(j, nums[j]+nums[i]);
                }else{
                    map.put(j, Math.max(map.get(j),map.get(i)+nums[j])  );
                }
            }
        }
        int max =0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
