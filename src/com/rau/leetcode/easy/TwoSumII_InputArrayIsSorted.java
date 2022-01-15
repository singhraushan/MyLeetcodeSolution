package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(res[0]+","+res[1]);//1,2

        res = twoSum(new int[]{2,3,4}, 6);
        System.out.println(res[0]+","+res[1]);//1,3

        res = twoSum(new int[]{5,25,75}, 100);
        System.out.println(res[0]+","+res[1]);//2,3
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> seenMap = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(seenMap.containsKey(target-numbers[i])){
                res[0]=seenMap.get(target-numbers[i])+1;
                res[1]=i+1;
                return res;
            }
            seenMap.put(numbers[i],i);
        }
        return res;
    }
    //2nd way
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> seenMap = new HashMap<>();
        int left=0,right=numbers.length-1;
        while (left<right){
            if(seenMap.containsKey(target-numbers[left])){
                res[0]=Math.min(seenMap.get(target-numbers[left])+1, left+1);
                res[1]=Math.max(seenMap.get(target-numbers[left])+1, left+1);
                return res;
            }else if(seenMap.containsKey(target-numbers[right])){
                res[0]=Math.min(seenMap.get(target-numbers[right])+1, right+1);
                res[1]=Math.max(seenMap.get(target-numbers[right])+1, right+1);
                return res;
            }else if(numbers[left]+numbers[right]==target){
                res[0]=Math.min(left+1,right+1);
                res[1]=Math.max(left+1,right+1);
                return res;
            }
            seenMap.put(numbers[left],left++);
            seenMap.put(numbers[right],right--);
        }
        if(numbers.length%2!=0){
            if(seenMap.containsKey(target-numbers[numbers.length/2])){
                res[0]=Math.min(seenMap.get(target-numbers[numbers.length/2])+1, numbers.length/2+1);
                res[1]=Math.max(seenMap.get(target-numbers[numbers.length/2])+1, numbers.length/2+1);
                return res;
            }
        }
        return res;
    }
}
