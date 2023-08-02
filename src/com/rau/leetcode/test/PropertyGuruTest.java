package com.rau.leetcode.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PropertyGuruTest {
    public static void main(String[] args) {
        //System.out.println(solution(new int[][]{{1,2,2},{3,1,4}}));
        System.out.println(solution(new String[]{"...X..","....XX","..X..."}));
    }
    public static int solution(int[][] A) {
        Set<Integer> alreadyCounted = new HashSet<>();
        Set<Integer> prevRows = new HashSet<>();
        for(int row=0;row<A.length;row++){

            for(int col=0;col<A[row].length; col++){
                int value = A[row][col];
                if(prevRows.contains(value)){
                    if(!alreadyCounted.contains(value))
                        alreadyCounted.add(value);
                }
            }
            prevRows.addAll(Arrays.stream(A[row]).boxed().collect(Collectors.toSet()));
        }
        return alreadyCounted.size();
    }

    public static int solution(String[] R) {
        Set<String> alreadyCounted = new HashSet<>();
        int row=0,col=0, repeatCount=0;
        int rowLen=R.length, colLen = R[0].length();
        while(true){

            //left-right
            for(;col<colLen; col++){
                if(R[row].charAt(col)=='.'){//move right
                    alreadyCounted.add(row+","+col);
                    repeatCount++;
                }else {
                    if(col-1>=0)
                    col--;
                    break;
                }
            }
            if(col==colLen)
                col--;
            if(repeatCount>=rowLen*colLen)
                break;
            //top-bottom
            for(;row<rowLen; row++){
                if(R[row].charAt(col)=='.'){//top to bottom
                    alreadyCounted.add(row+","+col);
                    repeatCount++;
                }else {
                    if(row-1>=0)
                    row--;
                    break;
                }
            }
            if(row==rowLen)
                row--;
            if(repeatCount>=rowLen*colLen)
                break;
            //right-left
            for(;col>=0; col--){
                if(R[row].charAt(col)=='.'){//right left
                    alreadyCounted.add(row+","+col);
                    repeatCount++;
                }else {
                    if(col+1<colLen)
                    col++;
                    break;
                }
            }
            if(col==-1)
                col++;
            if(repeatCount>=rowLen*colLen)
                break;
            //bottom-top
            for(;row>=0; row--){
                if(R[row].charAt(col)=='.'){//bottom top
                    alreadyCounted.add(row+","+col);
                    repeatCount++;
                }else {
                    if(row+1<rowLen)
                    row++;
                    break;
                }
            }
            if(row==-1)
                row++;
            if(repeatCount>=rowLen*colLen)
                break;
        }

        return alreadyCounted.size();
        }


}
