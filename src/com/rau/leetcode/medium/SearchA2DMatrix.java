package com.rau.leetcode.medium;

import java.util.concurrent.atomic.AtomicBoolean;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix= new int[][]{ {1,3,5,7},{10,11,16,20},{23,30,34,60} };
        System.out.println("res: "+searchMatrix(matrix, 3));//true

        matrix= new int[][]{ {1,3,5,7},{10,11,16,20},{23,30,34,60} };
        System.out.println("res: "+searchMatrix(matrix, 13));//false
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length, colCount = matrix[0].length;
        for(int row=0;row<rowCount;row++){
            if(target>=matrix[row][0] && target<=matrix[row][colCount-1]){
                //apply binary search
                AtomicBoolean res = new AtomicBoolean();
                binarySearch(matrix, row, 0, colCount-1,target, res);
                if(res.get()){
                    return true;
                }
            }else if(target<matrix[row][0]){
                return false;
            }
        }
        return false;
    }

    public static void binarySearch(int[][] matrix, int row, int sCol, int eCol, int target, AtomicBoolean res) {
        if(sCol<=eCol){
            if(target==matrix[row][sCol] || target==matrix[row][eCol]){
                res.set(true);
                return;
            }
            int midCol = (sCol+eCol)/2;
            if(target>=matrix[row][sCol] && target<=matrix[row][midCol])
                binarySearch(matrix, row, sCol, midCol, target,res);
            else
                binarySearch(matrix, row, midCol+1,eCol, target, res);
        }
    }
}
