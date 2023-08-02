package com.rau.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class DharamZalandoTest {
    public static void main(String[] args) {
        System.out.println("res:"+new DharamZalandoTest().solution(new String[]{"X.....>","..v..X.",".>..X..","A......"}));//false
        System.out.println("res:"+new DharamZalandoTest().solution(new String[]{"...Xv", "AX..^", ".XX.."}));//true
        System.out.println("res:"+new DharamZalandoTest().solution(new String[]{"...", ">.A"}));//false
        System.out.println("res:"+new DharamZalandoTest().solution(new String[]{"A.v", "..."}));//false

    }
    private boolean isReached,isCatched;
    private int rowMax , colMax/*,count*/;
    private Set<String> seen = new HashSet<>();

    public boolean solution(String[] B) {
        String[][] grid = makeGrid(B);
        rowMax =grid.length;
        colMax=grid[0].length;

        fillObstacleByGuard(grid);
        if(isCatched) return false;

         for(int row=0;row<rowMax;row++){
            for(int col=0;col<colMax;col++){
                if(grid[row][col].contains("A")) {
                    rec(grid, row, col);
                    return isReached;
                }
            }
        }
        return isReached;
    }
    private void fillObstacleByGuard(String[][] grid) {
        for(int row=0;row<rowMax;row++){
            for(int col=0;col<colMax;col++){
                if(grid[row][col].contains("^")){//fill upward in current col

                    for(int currR=row;currR>=0;currR--){
                        if(grid[currR][col].contains("X") || grid[currR][col].contains("v") || grid[currR][col].contains("<") || grid[currR][col].contains(">")){
                           break;
                        }else {
                            if(grid[currR][col].contains("A")){
                                isCatched = true;
                                return;
                            }
                            grid[currR][col] = grid[currR][col]+"F";
                        }
                    }
                    //remove current ^
                    grid[row][col] = grid[row][col].replace("^","");
                }else if(grid[row][col].contains("v")){//fill downward in current col

                    for(int currR=row;currR<rowMax;currR++){
                        if(grid[currR][col].contains("X") || grid[currR][col].contains("^") || grid[currR][col].contains("<") || grid[currR][col].contains(">")){
                            break;
                        }else {
                            if(grid[currR][col].contains("A")){
                                isCatched = true;
                                return;
                            }
                            grid[currR][col] = grid[currR][col]+"F";
                        }
                    }
                    //remove current v
                    grid[row][col] = grid[row][col].replace("v","");

                }else if(grid[row][col].contains("<")){//fill leftward in current row

                    for(int currC=col;currC>=0;currC--){
                        if(grid[row][currC].contains("X") || grid[row][currC].contains("v") || grid[row][currC].contains("^") || grid[row][currC].contains(">")){
                            break;
                        }else {
                            if(grid[row][currC].contains("A")){
                                isCatched = true;
                                return;
                            }
                            grid[row][currC] = grid[row][currC]+"F";
                        }
                    }
                    //remove current <
                    grid[row][col] = grid[row][col].replace("<","");

                }else if(grid[row][col].contains(">")){//fill rightward in current row

                    for(int currC=col;currC<colMax;currC++){
                        if(grid[row][currC].contains("X") || grid[row][currC].contains("v") || grid[row][currC].contains("^") || grid[row][currC].contains("<")){
                           break;
                        }else {
                            if(grid[row][currC].contains("A")){
                                isCatched = true;
                                return;
                            }
                            grid[row][currC] = grid[row][currC]+"F";
                        }
                    }
                    //remove current >
                    grid[row][col] = grid[row][col].replace(">","");
                }
            }
        }
    }

    private String[][] makeGrid(String[] B) {
        int colMax=B[0].length(),r=0;
        String[][] grid = new String[B.length][colMax];

        for(String row : B){
            for(int col=0;col<colMax;col++) grid[r][col]=String.valueOf(row.charAt(col));
            r++;
        }
        return grid;
    }

    private void rec(String[][] grid, int row, int col) {
        /*count++;
        if(count>Integer.MAX_VALUE)
            return;*/
        if(isReached) return;
        if(row==grid.length-1 && col==grid[0].length-1){
            if(!grid[row][col].contains("X") && !grid[row][col].contains("F"))
                isReached=true;
            return;
        }else {
            //left move
            if(col-1>=0 && !grid[row][col-1].contains("X") && !grid[row][col-1].contains("F") && !seen.contains("left"+row+","+(col-1))) {
                //System.out.println("Left move: row:"+row+","+(col-1));
                seen.add("left"+row+","+(col-1));
                rec(grid, row, col - 1);
            }
            //right move
            if(col+1<grid[0].length && !grid[row][col+1].contains("X") && !grid[row][col+1].contains("F") && !seen.contains("right"+row+","+(col+1))) {
                //System.out.println("Right move: row:"+row+","+(col+1));
                seen.add("right"+row+","+(col+1));
                rec(grid, row, col + 1);
            }
            //up move
            if(row-1>=0 && !grid[row-1][col].contains("X") && !grid[row-1][col].contains("F") && !seen.contains("up"+(row-1)+","+col)) {
                //System.out.println("Up move: row:"+(row-1)+","+col);
                seen.add("up"+(row-1)+","+col);
                rec(grid, row - 1, col);
            }
            //down move
            if(row+1<grid.length && !grid[row+1][col].contains("X") && !grid[row+1][col].contains("F") && !seen.contains("down"+(row+1)+","+col)) {
                //System.out.println("down move: row:"+(row+1)+","+col);
                seen.add("down"+(row+1)+","+col);
                rec(grid, row + 1, col);
            }
        }
    }
}
