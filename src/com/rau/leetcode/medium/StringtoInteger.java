package com.rau.leetcode.medium;

public class StringtoInteger {
    public static void main(String[] args) {
        System.out.println("myAtoi: " + myAtoi("20000000000000000000"));
        System.out.println("myAtoi: " + myAtoi("+000000000000001"));
        System.out.println("myAtoi: " + myAtoi("    0000000000000   "));
        System.out.println("myAtoi: " + myAtoi("-2147483647"));
        System.out.println("myAtoi: " + myAtoi("00000000000001"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if (len == 0)
            return 0;
        int i = 0, leadingZeroCount = 0;
        boolean isContinueZero = false, isSigned = false;
        // find valid number, leadingZero & signed
        for (; i < len; i++) {
            char ch = str.charAt(i);
            if (i == 0) {
                if (ch == 43 || ch == 45 || (ch >= 48 && ch <= 57)) {
                    if (ch == 43 || ch == 45) {
                        isSigned = true;
                        isContinueZero = true;
                    } else if (ch == '0') {
                        leadingZeroCount++;
                        isContinueZero = true;
                    }
                } else {
                    return 0;
                }
            } else {
                if (ch >= 48 && ch <= 57) {
                    if (ch == '0' && isContinueZero) {
                        leadingZeroCount++;
                    } else isContinueZero = false;
                } else
                    break;
            }
        }
        String validStr = str.substring(0, i);
        // to remove leading zero
        if (isSigned) {
            if (leadingZeroCount > 0) {
                validStr = validStr.charAt(0) + validStr.substring(leadingZeroCount+1);
            }
        } else {
            if (leadingZeroCount > 0) {
                validStr = validStr.substring(leadingZeroCount);
            }
        }
        if (validStr.length() == 0 || (validStr.length() == 1 && (validStr.startsWith("+") || validStr.startsWith("-"))))// if only leading zero
            return 0;
        if ((validStr.length() > 11 && !validStr.startsWith("0") && validStr.startsWith("-")))
            return Integer.MIN_VALUE;
        if ((validStr.length() > 11 && !validStr.startsWith("0")))
            return Integer.MAX_VALUE;
        if ((Long.parseLong(validStr) < Integer.MIN_VALUE))
            return Integer.MIN_VALUE;
        if ((Long.parseLong(validStr) > Integer.MAX_VALUE))
            return Integer.MAX_VALUE;
        return Integer.parseInt(validStr);
    }
}
