package com.rau.leetcode.medium;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));//true
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));//false
        System.out.println(searchMatrix(new int[][]{{-5}},-5));//true
        System.out.println(searchMatrix(new int[][]{{-1,3}},3));//true
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowMax=matrix.length,colMax=matrix[0].length;

            for(int row=0;row<rowMax;row++){

                for (int col=row;col<colMax;col++){

                    int startV = matrix[row][col];

                    if(target<startV) return false;
                    if(matrix[row][col]==target) return true;

                    //left-right
                    int rightEndV = matrix[row][colMax-1];
                    if(target<=rightEndV){
                        int leftP=col,rightP=colMax-1;
                        while (leftP<rightP){
                            int midP = (leftP+rightP)/2;
                            if(matrix[row][midP]==target || matrix[row][midP+1]==target){
                                return true;
                            }if(target<matrix[row][midP]){
                                rightP = midP;
                            }else {
                                leftP = midP+1;
                            }
                        }
                    }
                    //top-bottom
                    int bottomEndV = matrix[rowMax-1][col];
                    if(target<=bottomEndV){
                        int topP=row,bottomP=rowMax-1;
                        while (topP<bottomP){
                            int midP = (topP+bottomP)/2;
                            if(matrix[midP][col]==target || matrix[midP+1][col]==target){
                                return true;
                            }if(target<matrix[midP][col]){
                                bottomP = midP;
                            }else {
                                topP = midP+1;
                            }
                        }
                    }
                }
            }

        return false;
    }

}
