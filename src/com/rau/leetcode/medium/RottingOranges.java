package com.rau.leetcode.medium;

public class RottingOranges {
    public static void main(String[] args) {

    }
    int freshCount = 0;
    public int orangesRotting(int[][] grid) {
        if(grid==null) return 0;
        int rottenCount=0,maxR=grid.length,maxC=grid[0].length;
        int res=0;
        for(int row=0;row<maxR;row++){
            for(int col=0;col<maxC;col++){
                if(grid[row][col]==2){
                    rec(grid, row,col,maxR,maxC);
                }
            }
        }
        return res;
    }

    public void rec(int[][] grid, int row,int col, int maxR, int maxC) {
        if(grid[row][col]==0)
            return;

        if(grid[row][col]==1)
            grid[row][col]=2;

        //right
        if(col+1<maxC)
        rec(grid, row,col+1,maxR,maxC);

        //left
        if(col-1>=0)
            rec(grid, row,col-1,maxR,maxC);

        //top
        if(row-1>=0)
            rec(grid, row-1,col,maxR,maxC);

        //bottom
        if(row+1<maxR)
            rec(grid, row+1,col,maxR,maxC);
    }
}
