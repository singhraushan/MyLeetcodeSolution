package com.rau.leetcode.easy;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(IntStream.of(sortedSquares(new int[]{-4,-1,0,3,10})).boxed().collect(Collectors.toList()));
    }
    public static int[] sortedSquares(int[] nums) {

        int left=0,right= nums.length-1;
        int[] result = new int[nums.length];
        for(int p=nums.length-1;p>=0;p--){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[p]=nums[left]*nums[left];
                left++;
            }else {
                result[p]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
