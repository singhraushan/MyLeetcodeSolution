package com.rau.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class SapTest {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3,1,2,3,7},{1,2,3,1,2,3,7},{1,2,3,1,2,3,7}};//m=3, n= 7, //output=28;

        System.out.println("res:"+allPossiblePath(grid));

        grid = new int[][]{{1,2},{1,2},{1,2}};//m=3, n=2, //output=3;
        System.out.println("res:"+allPossiblePath(grid));


    }
    private static int count=0;
    public static int allPossiblePath(int[][] grid) {
        count=0;
        rec(grid,0, 0);
        return count;
    }

    public static void rec(int[][] grid,int row, int col) {
        if(row==grid.length-1 && col==grid[0].length-1){
            count++;
        }else {
            //right move
            if(col+1<grid[0].length)
            rec(grid,row, col+1);

            //bottom move
            if(row+1<grid.length)
            rec(grid,row+1, col);
        }
    }
}
