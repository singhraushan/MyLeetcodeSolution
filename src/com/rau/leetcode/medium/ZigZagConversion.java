package com.rau.leetcode.medium;

import java.util.ArrayList;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println("ZigZag Pattern reading : " + convert("PAYPALISHIRING", 2));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        ArrayList<String> list = new ArrayList<>(numRows);
        int col = 0, index = 0;
        while (index < s.length()) {
            for (int row = 0; row < numRows; row++) {
                if (index >= s.length())
                    break;
                else if (col == 0 || col % (numRows - 1) == 0) {
                    if (index < numRows) {
                        list.add(String.valueOf(s.charAt(index++)));
                    } else {
                        String val = list.get(row);
                        val = val + s.charAt(index++);
                        list.set(row, val);
                    }
                } else {
                    int curRow;
                    if (col >= numRows) {
                        curRow = (numRows - 1) - col % (numRows - 1);
                    } else
                        curRow = numRows - col - 1;
                    String val = list.get(curRow);
                    val = val + s.charAt(index++);
                    list.set(curRow, val);
                    break;
                }
            }
            col++;
        }
        String result = "";
        for (String s1 : list) {
            result = result.concat(s1);
        }
        return result;
    }
}
