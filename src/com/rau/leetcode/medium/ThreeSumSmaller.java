package com.rau.leetcode.medium;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        System.out.println("res:"+threeSumSmaller(new int[]{-2,0,1,3}, 2));//2
        System.out.println("res:"+threeSumSmaller(new int[]{}, 0));//0
        System.out.println("res:"+threeSumSmaller(new int[]{0}, 0));//0
        System.out.println("res:"+threeSumSmaller(new int[]{-2,0,5,3}, 6));//2
    }
    public static int threeSumSmaller(int[] nums, int target) {
        int res=0,len =nums.length;

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    if(nums[i]+nums[j]+nums[k]<target)res++;
                }
            }
        }
        return res;
    }
}
