package com.rau.leetcode.medium;

import java.util.*;

public class WordSearch {

    public static void main(String[] args) {
        char[][] /*board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("res:"+exist(board, "ABCCED"));//true

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("res:"+exist(board, "SEE"));//true

        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("res:"+exist(board, "ABCB"));//false*/

        board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println("res:"+exist(board, "ABCESEEEFS"));//true
    }

    public static boolean exist(char[][] board, String word) {
        Set<String> seen = new HashSet<>();
        int rM=board.length,cM=board[0].length;
        for(int r=0;r<rM;r++){
            for(int c=0;c<cM;c++){
               if(word.startsWith(board[r][c]+"")){
                   rec(board, new boolean[rM][cM],board[r][c]+"",word,  r ,c, seen);
                   System.out.println(seen);
                   if(seen.contains(word))return true;
               }
            }
        }

        return false;
    }

    private static void rec(char[][] board, boolean[][] visited, String currStr,String word, int r,int c , Set<String> seen){
        seen.add(currStr);
        if(seen.contains(word))return;
        //left
        /*if(c-1>=0 && visited[r][c-1]==false) {
            visited[r][c-1]=true;
            rec(board, visited, currStr+board[r][c-1], word, r, c-1, seen);
        }*/
        //right
        if(c+1<board[0].length && visited[r][c+1]==false) {
            visited[r][c+1]=true;
            rec(board, visited, currStr+board[r][c+1], word, r, c+1, seen);
        }
        //top
        /*if(r-1>=0 && visited[r-1][c]==false) {
            visited[r-1][c]=true;
            rec(board, visited, currStr+board[r-1][c], word, r-1, c, seen);
        }*/
        //bottom
        if(r+1<board.length && visited[r+1][c]==false) {
            visited[r+1][c]=true;
            rec(board, visited, currStr+board[r+1][c], word, r+1, c, seen);
        }
    }
}
