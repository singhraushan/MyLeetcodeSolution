package com.rau.leetcode.medium;

public class StringtoInteger {
    public static void main(String[] args) {
        System.out.println("myAtoi: " + myAtoi("20000000000000000000"));
        //System.out.println("myAtoi: " + myAtoi("+000000000000001"));
        //System.out.println("myAtoi: " + myAtoi("    0000000000000   "));
        //System.out.println("myAtoi: " + myAtoi("-2147483647"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;
        int i = 0, len = str.length();
        for (i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            if (i == 0) {
                if (!(currentChar == 43 || currentChar == 45 || (currentChar >= 48 && currentChar <= 57)))
                    break;
            } else {
                if (!(currentChar >= 48 && currentChar <= 57))
                    break;
            }
        }
        String valid = str.substring(0, i);
        boolean isSigned = false;
        int j = 0;
        for (j = 0; j < valid.length(); j++) {
            char validChar = valid.charAt(j);
            if (j == 0) {
                if (validChar == 43 || validChar == 45)
                    isSigned = true;
                else if (!(validChar == '0'))
                    break;
            } else if (!(validChar == '0'))
                break;
        }
        if (j > 1) {
            if (isSigned)
                valid = valid.charAt(0) + valid.substring(j, valid.length());
            else
                valid = valid.substring(j, valid.length());
        }
        if (valid.length() == 0)
            return 0;
        if (valid.length() == 1 && (valid.startsWith("+") || valid.startsWith("-")))
            return 0;
        if ((valid.length() > 11 && !valid.startsWith("0") && valid.startsWith("-")))
            return Integer.MIN_VALUE;
        if ((valid.length() > 11 && !valid.startsWith("0")))
            return Integer.MAX_VALUE;
        if ((Long.parseLong(valid) < Integer.MIN_VALUE))
            return Integer.MIN_VALUE;
        if ((Long.parseLong(valid) > Integer.MAX_VALUE))
            return Integer.MAX_VALUE;
        return Integer.parseInt(valid);
    }
}
