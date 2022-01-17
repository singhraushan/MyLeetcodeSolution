package com.rau.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));//

        grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));//4
    }

    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0, maxCol=grid[0].length, maxRow=grid.length;
        Set<String> visited = new HashSet<>();
        for(int r=0;r<maxRow;r++){
            for(int c=0;c<maxCol;c++){
                if(grid[r][c]==1){
                    findIsland(grid, r, c,maxRow, maxCol,visited);
                    maxArea = Math.max(area,maxArea);
                    area=0;
                }
            }
        }
        return maxArea;
    }

    private void findIsland(int[][] grid, int row, int col ,int maxRow, int maxCol,Set<String> visited) {
         if(grid[row][col]==1 && !visited.contains(row+","+col)){
             visited.add(row+","+col);
             area++;
             //right
             if(col+1<maxCol)
             findIsland(grid,row,col+1, maxRow, maxCol,visited);
            //left
             if(col-1>=0)
                 findIsland(grid,row,col-1, maxRow, maxCol,visited);
             //top
             if(row-1>=0)
                 findIsland(grid,row-1,col, maxRow, maxCol,visited);
            //bottom
             if(row+1<maxRow)
                 findIsland(grid,row+1,col, maxRow, maxCol,visited);
         }
    }
}
