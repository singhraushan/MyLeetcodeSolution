package com.rau.leetcode.medium;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println("res:"+search(new int[]{4,5,6,7,0,1,2}, 0));//4
        System.out.println("res:"+search(new int[]{4,5,6,7,0,1,2}, 3));//-1
        System.out.println("res:"+search(new int[]{1}, 0));//-1
        System.out.println("res:"+search(new int[]{3,4,5,6,7,8,9,1,2}, 1));//7
        System.out.println("res:"+search(new int[]{7,8,9,1,2,3,4,5,6}, 1));//3
        System.out.println("res:"+search(new int[]{5,6,7,8,9,1,2,3,4}, 1));//5
        System.out.println("res:"+search(new int[]{1,2,3,4,5,6,7,8,9}, 1));//0
    }
    public static int search(int[] nums, int target) {
        int left =0, right =nums.length-1;
        if(right==0){
            if(nums[0]==target) return 0;
        }

        while (left<right){
          int mid = (left+right)/2;
            if(nums[left]==target){
                  return left;
            }
            if(nums[right]==target){
                return right;
            }
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid+1]==target){
                return mid+1;
            }
            if(mid==left || mid+1==right){
                return -1;
            }
            if(nums[mid]>nums[left]){//both half sorted OR 1st half only sorted
                if(target < nums[mid] && target>nums[left]){//within 1st part
                    right = mid;
                }else {//not in 1st part
                    left = mid+1;
                }
            }else {//2nd half only sorted
                if(nums[mid+1] < target && target<nums[right]){//within 2nd part
                    left = mid+1;
                }else {//not in 2nd part
                    right = mid+1;
                }
            }
        }
        return -1;
    }
}
