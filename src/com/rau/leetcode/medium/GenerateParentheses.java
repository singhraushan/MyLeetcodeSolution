package com.rau.leetcode.medium;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println("generateParenthesis: " + generateParenthesis(6));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n,0,0,"",res);
        return res;
    }

    private static void backTrack(int count, int currOpen,int currClose,String currStr,List<String> finalRes){
        if(currStr.length()==count*2){
          finalRes.add(currStr);
          return;
        }
        if(currOpen<count){
            backTrack(count,currOpen+1,currClose,currStr+"(",finalRes);
        }
        if(currClose<currOpen){
            backTrack(count,currOpen,currClose+1,currStr+")",finalRes);
        }
    }


}
