package com.rau.leetcode.test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VMwareTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, gridCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(Collectors.toList());

        int maxTime = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.reachTheEnd(grid, maxTime);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
class Result {

    /*
     * Complete the 'reachTheEnd' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER maxTime
     */
    static String res="No";
    public static String reachTheEnd(List<String> grid, int maxTime) {
        //right
        res="No";
        dfs(grid, 0,0,maxTime, 0);
        return res;
    }
    public static void dfs(List<String> grid, int row,int col,int maxTime, int count) {
        //base case
        if (grid.size() == col + 1 && grid.get(0).length() == col + 1) {
            if (maxTime >= count)
                res = "Yes";
            return;
        }
        if (grid.size() > row) {
            String rValue = grid.get(row);
            //left & right
            if (rValue.length() > col + 1) {
                char right = rValue.charAt(col);
                if (right == '.' && maxTime >= count)
                    dfs(grid, row, col + 1, maxTime, count + 1);
            }
            if (rValue.length() > col && col - 1 >= 0) {
                char left = rValue.charAt(col - 1);
                if (left == '.' && maxTime >= count)
                    dfs(grid, row, col - 1, maxTime, count + 1);
            }

            //top and bottom
            if (grid.size() > row - 1 && row - 1 >= 0) {
                char top = rValue.charAt(row - 1);
                if (top == '.' && maxTime >= count)
                    dfs(grid, row - 1, col, maxTime, count + 1);
            }
            if (grid.size() > row + 1 && row + 1 >= 0) {
                char bottom = rValue.charAt(row + 1);
                if (bottom == '.' && maxTime >= count)
                    dfs(grid, row + 1, col, maxTime, count + 1);
            }
        }
    }
}
