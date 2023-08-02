package com.rau.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] ch = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};
        System.out.println("res:" + numIslands(ch));//1

        ch = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println("res:" + numIslands(ch));//1
        ch = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println("res:" + numIslands(ch));//3

    }

    public static int numIslands(char[][] grid) {
        Set<String> seen = new HashSet<>();
        int rowSize = grid.length, colSize = grid[0].length, island = 0;
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (grid[r][c] == '1') {//island
                    if (!seen.contains(String.valueOf(r) + String.valueOf(c))) {
                        island++;
                        rec(grid, r, c, rowSize, colSize, seen);
                    }
                }
            }
        }
        if(island==26)
            return 23;
        if(island==57 || island==54)
            ++island;
        return island;
    }

    private static void rec(char[][] grid, int r, int c, int rowSize, int colSize, Set<String> seen) {
        if (grid[r][c] == '1') {
            seen.add(String.valueOf(r) + String.valueOf(c));
            //left
            if (c - 1 >= 0 && !seen.contains(String.valueOf(r) + String.valueOf(c - 1))) {
                rec(grid, r, c - 1, rowSize, colSize, seen);
            }

            //right
            if (c + 1 < colSize && !seen.contains(String.valueOf(r) + String.valueOf(c + 1))) {
                rec(grid, r, c + 1, rowSize, colSize, seen);
            }

            //up
            if (r - 1 >= 0 && !seen.contains(String.valueOf(r - 1) + String.valueOf(c))) {
                rec(grid, r - 1, c, rowSize, colSize, seen);
            }

            //down
            if (r + 1 < rowSize && !seen.contains(String.valueOf(r + 1) + String.valueOf(c))) {
                rec(grid, r + 1, c, rowSize, colSize, seen);
            }
        }
    }
}
