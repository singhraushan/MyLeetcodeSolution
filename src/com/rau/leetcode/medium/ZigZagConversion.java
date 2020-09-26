package com.rau.leetcode.medium;

import java.util.ArrayList;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println("ZigZag Pattern reading: " + convert("PAYPALISHIRING", 2));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        ArrayList<String> list = new ArrayList<>(numRows);
        int col = 0, index = 0, len = s.length();
        while (index < len) {

            if (col == 0 || col % (numRows - 1) == 0) {
                for (int row = 0; row < numRows && index < len; row++) {
                    if (index < numRows)
                        list.add(String.valueOf(s.charAt(index++)));
                    else
                        list.set(row, list.get(row) + s.charAt(index++));
                }
            } else {
                int curRow = (col >= numRows) ? ((numRows - 1) - col % (numRows - 1)) : (numRows - 1) - col;
                list.set(curRow, list.get(curRow) + s.charAt(index++));
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
