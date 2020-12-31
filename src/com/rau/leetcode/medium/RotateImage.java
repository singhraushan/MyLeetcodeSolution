package com.rau.leetcode.medium;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}} ;
        rotate(matrix);
        for(int row =0;row<matrix.length;row++ ){
            for(int col = 0; col<matrix.length;col++ ){
                System.out.print(matrix[row][col]+",");
            }
            System.out.println();
        }

        //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //Output: [[7,4,1],[8,5,2],[9,6,3]]
        //input = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for(int row =0;row<len;row++ ){
            for(int col = row; col<len;col++ ){
                //swap
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for(int row =0;row<len;row++ ){
            for(int col = 0; col<len/2;col++ ){
                //swap
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][len-1-col];
                matrix[row][len-1-col] = temp;
            }
        }
    }
}
