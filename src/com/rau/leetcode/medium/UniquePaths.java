package com.rau.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println("count:"+new UniquePaths().uniquePaths(3, 7));//28
        System.out.println("count:"+new UniquePaths().uniquePaths(3, 2));//3
        System.out.println("count:"+new UniquePaths().uniquePaths(7, 3));//28
        System.out.println("count:"+new UniquePaths().uniquePaths(3, 3));//6
        System.out.println("count:"+new UniquePaths().uniquePaths(51, 9));//1916797311
    }

    public int uniquePaths(int m, int n) {
         return dfs(0,0,n-1,m-1, new HashMap<>());
    }
    private int dfs(int x, int y,int fX,int fY, Map<String, Integer> memo) {
        if (fX==x && fY==y){
            return 1;
        }
        if (x>fX || y>fY){
            return 0;
        }
        if (memo.get(x+"-"+y)!=null){
            return memo.get(x+"-"+y);
        }
         int res = dfs(x+1,y,fX, fY,memo)+ dfs(x, y+1,fX, fY,memo);
        memo.put(x+"-"+y,res);
        return res;
    }

}
