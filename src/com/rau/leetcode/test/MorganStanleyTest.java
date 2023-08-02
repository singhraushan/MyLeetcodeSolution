package com.rau.leetcode.test;


import java.util.*;

public class MorganStanleyTest {

    public static void main(String[] args) {
        /*List<Integer> strocksProfit = new ArrayList<>();
        Integer[] arr = new Integer[]{1,3,46,1,3,9};
        strocksProfit.addAll(Arrays.asList(arr));
        System.out.println(sp(strocksProfit, 47));
        System.out.println("------");*/
        List<Integer> strocksProfit = new ArrayList<>();
        Integer[] arr = new Integer[]{6,6,3,9,3,5,1};
        strocksProfit.addAll(Arrays.asList(arr));
        System.out.println(sp(strocksProfit, 12));
    }
    public static int sp(List<Integer> strocksProfit, long target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> forCount = new HashSet<>();
        int len = strocksProfit.size();
        for(int v: strocksProfit){
            if(seen.contains((int)(target-v))){
                if(!(forCount.contains(v+"-"+(target-v)) || forCount.contains((target-v)+v+"-"))){
                    forCount.add(v+"-"+(target-v));
                }
            }else {
                seen.add(v);
            }
        }
        return forCount.size();
    }

}
