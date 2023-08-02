package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutations {
    public static void main(String[] args) {

        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permuteChar(new char[]{'a', 'b', 'c'}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, nums.length-1, res);
        return res;
    }
    public static List<List<Character>> permuteChar(char[] chars) {
        List<List<Character>> res = new ArrayList<>();
        permuteChar(chars, 0, chars.length-1, res);
        return res;
    }

    public static void permute(int[] nums, int startIndx, int endIndx, List<List<Integer>> lists) {
        if (startIndx == endIndx) {
            List<Integer> l= new ArrayList<>();
            for(int n: nums){
                l.add(n);
            }
            lists.add(l);
        } else {
            for (int i = startIndx; i <= endIndx; i++) {
                swap(nums,i,startIndx);
                permute(nums,startIndx+1,endIndx,lists);
                swap(nums,i,startIndx);
            }
        }
    }

    public static int[] swap(int[] nums, int startIndx, int endIndx) {
        int temp = nums[startIndx];
        nums[startIndx] = nums[endIndx];
        nums[endIndx] = temp;
        return nums;
    }

    private static void permuteChar(char[] input, int currIndex, int lastIndex, List<List<Character>> res){
        if(currIndex==lastIndex){
            List<Character> curr = new ArrayList<>();
            for(char ch: input){
                curr.add(ch);
            }
            res.add(curr);
        }else {
            for(int i = currIndex;i<=lastIndex;i++ ){
                swap(input,i,currIndex);
                permuteChar(input, currIndex+1,lastIndex ,res);
                swap(input,i,currIndex);
            }
        }
    }

    public static void swap(char[] input, int i,int currIndex){
        char temp = input[i];
        input[i]= input[currIndex];
        input[currIndex]= temp;
    }
}
