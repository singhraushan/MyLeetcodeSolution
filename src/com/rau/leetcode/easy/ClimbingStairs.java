package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));//2
        System.out.println(climbStairs(3));//3
    }

    //Bottom-up approach: O(n)
    public static int climbStairs(int n) {
        int lastStairs=1,secondLastStairs=1;
        while (n-->=2){
            int currStairs = lastStairs+secondLastStairs;
            secondLastStairs = lastStairs;
            lastStairs = currStairs;
        }
        return lastStairs;
    }

    //Recursive without memoization: O(2^n)
    public static int climbStairs2(int n) {
        if(n==0 || n==-1) return n+1;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    //Recursive with memoization: O(n)
    public static int climbStairs3(int n) {
        return rec(n,new HashMap<>());
    }

    private static int rec(int n, Map<Integer,Integer> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n==0 || n==-1)return n+1;
        int res = rec(n-1,memo)+rec(n-2,memo);
        memo.put(n,res);
        return res;
    }

}
