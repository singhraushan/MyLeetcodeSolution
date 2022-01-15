package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("res: "+Arrays.stream(nums).boxed().collect(Collectors.toList()));//{0,0,1,3,12}
    }
    //No extra memory but slower
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
                if(nums[i]==0){
                        for(int j=i+1;j<len;j++){
                            if(nums[j]!=0){
                                nums[i]=nums[j];
                                nums[j]=0;
                                if(j==len-1)return;
                                break;
                            }
                            if(j==len-1)return;
                        }
                }
        }
    }
    //extra memory but faster
    public static void moveZeroes1(int[] nums) {
        List<Integer> nonZeros = new ArrayList<>();
        for(int num: nums){
            if(num!=0){
                nonZeros.add(num);
            }
        }
        int len = nonZeros.size();
        for(int i=0;i<len;i++){
            nums[i]=nonZeros.get(i);
        }
        len = nums.length;
        for(int i=nonZeros.size();i<len;i++){
            nums[i]=0;
        }
    }
}
