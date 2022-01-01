package com.rau.leetcode.easy;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        //int[][] res = matrixReshape(new int[][]{{1,2},{3,4}},  1,  4);
        int[][] res = matrixReshape(new int[][]{{1,2},{3,4}},  2,  4);

        int oR=res.length, oC = res[0].length;
        System.out.print("{");
        for(int row=0;row<oR;row++){
            System.out.print("{");
            for(int col=0;col<oC;col++){
                if(col==oC-1)
                    System.out.print(res[row][col]);
                else
                System.out.print(res[row][col]+",");
            }
            System.out.print("}");
        }
        System.out.print("}");
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int oR=mat.length, oC = mat[0].length;
        if(oR*oC<r*c) return  mat;
        int[][] res = new int[r][c];

        int r1=0,c1=0;
        for(int row=0;row<oR;row++){
            for(int col=0;col<oC;col++){

                if(r1<r && c1<c) {
                    res[r1][c1++] = mat[row][col];
                }else {
                    r1++;
                    c1=0;
                    if(r1<r && c1<c) res[r1][c1++] = mat[row][col];
                    else{
                        return  mat;
                    }
                }
            }
        }
        return res;

    }
}
