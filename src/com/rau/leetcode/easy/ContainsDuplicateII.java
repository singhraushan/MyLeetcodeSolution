package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));//true
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1},1));//true
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));//false
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,List<Integer>> valuesIndexesMap = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            List<Integer> list = valuesIndexesMap.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            valuesIndexesMap.put(nums[i],list);
        }
        for(List<Integer> indexes : valuesIndexesMap.values()){
            if(matching(indexes, k)) return true;
        }

        return false;
    }
    private static boolean matching(List<Integer> indexes, int k) {
        int len = indexes.size();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if( Math.abs(indexes.get(i)-indexes.get(j)) <=k ) return true;
            }
        }
        return false;
    }
}
