package com.rau.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        /*char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};*/

        char[][] board = new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("isValidSudoku:" + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        return isRowValid(board) && isColumnValid(board) && is3X3BoxValidValid(board);
    }

    private static boolean isRowValid(char[][] board) {
        Set<Character> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if(!isValidSudokuBoxValue(board[r][c],seen)){
                    return false;
                }
            }
            seen.clear();
        }
        return true;
    }

    private static boolean isColumnValid(char[][] board) {
        Set<Character> seen = new HashSet<>();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                if(!isValidSudokuBoxValue(board[r][c],seen)){
                    return false;
                }
            }
            seen.clear();
        }
        return true;
    }

    private static boolean is3X3BoxValidValid(char[][] board) {
        Set<Character> seen = new HashSet<>();
        int i = 0, j = 0;
        while (i != 9 && j != 9) {
            j = 0;
            //3X3 box
            for (int r = i; r < 3 + i; r++) {
                for (int c = j; c < 3 + j; c++) {
                    if(!isValidSudokuBoxValue(board[r][c],seen)){
                        return false;
                    }
                }
            }
            seen.clear();

            j += 3;
            //3X3 box
            for (int r = i; r < 3 + i; r++) {
                for (int c = j; c < 3 + j; c++) {
                    if(!isValidSudokuBoxValue(board[r][c],seen)){
                        return false;
                    }
                }
            }
            seen.clear();


            j += 3;
            //3X3 box
            for (int r = i; r < 3 + i; r++) {
                for (int c = j; c < 3 + j; c++) {
                    if(!isValidSudokuBoxValue(board[r][c],seen)){
                        return false;
                    }
                }
            }
            seen.clear();
            i += 3;

        }

        return true;
    }

    private static boolean isValidSudokuBoxValue(char v, Set<Character> seen) {
        if (v == '.') {
            return true;
        } else if (v > 57 || v < 49) {
            return false;
        } else {
            if (seen.contains(v)) {
                return false;
            }
            seen.add(v);
        }
        return true;
    }
}
