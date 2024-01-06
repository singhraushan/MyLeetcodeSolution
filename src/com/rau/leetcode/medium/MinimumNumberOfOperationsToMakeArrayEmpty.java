package com.rau.leetcode.medium;

import java.util.HashMap;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public static void main(String[] args) {
        System.out.println("result: "+minOperations(new int[]{2,3,3,2,2,4,2,3,4}));//4
        System.out.println("result: "+minOperations(new int[]{2,1,2,2,3,3}));//-1
        System.out.println("result: "+minOperations(new int[]{14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12}));//7
        System.out.println("result: "+minOperations(new int[]{19,19,19,19,19,19,19,19,19,19,19,19,19}));//5

    }
    public static int minOperations(int[] nums) {
        HashMap<Integer,Integer> elementCountMap = new HashMap<>();
        for(int v: nums)
            elementCountMap.put(v, elementCountMap.getOrDefault(v,0)+1);
        int count=0;
        for(int key: elementCountMap.keySet()){
            int value = elementCountMap.get(key);
                //divisible by 3 then by 2:
                if(value==1)return -1;
                count += value / 3;
                    if (value % 3 != 0){
                        count++;
                    }
        }
        return count;
    }
}
