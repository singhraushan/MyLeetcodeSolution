package com.rau.leetcode.medium;

import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        grayCode(2);
    }
    public static List<Integer> grayCode(int n) {
        int[] arr = new int[n];
        List<String> list = new ArrayList<>();
        dfs(arr, 0,n,list);
        System.out.println(list);
        return null;
    }
    private static void dfs( int[] arr, int currIndex, int n,List<String> list) {
        if (currIndex==n){
            list.add(Arrays.toString(arr));
            return ;
        }
        arr[currIndex]=0;
        dfs(arr,currIndex+1,n,list);
        arr[currIndex]=1;
        dfs(arr,currIndex+1,n,list);
    }
    /*public static List<Integer> grayCode(int n) {
       int[] arr = new int[n];
        dfs(arr, 0,n);
        System.out.println(set);
       return null;
    }

    private static Set<String> set = new HashSet<>();
    private static List<Integer> list = new ArrayList<>();
    private static void dfs( int[] arr, int currIndex, int n) {
        if (currIndex==n){
            set.add(Arrays.toString(arr));
            list.add(currIndex);
            return ;
        }
        if (list.contains(currIndex)){
            set.add(Arrays.toString(arr));
            return ;
        }
        arr[currIndex]=0;
        dfs(arr,currIndex+1,n);
        arr[currIndex]=1;
        dfs(arr,currIndex+1,n);
    }*/
}
