package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});//output: [9, 4]
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> seenCount= new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int v: nums1){
            seenCount.put(v,seenCount.getOrDefault(v,0)+1);
        }

        for(int v: nums2){
            if(seenCount.containsKey(v) && seenCount.get(v)>0){
                seenCount.put(v,seenCount.get(v)-1);
                res.add(v);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
