package com.rau.leetcode.easy;

import java.util.Arrays;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        if (len==0)
            return 0;
        int result = 0;
        for (int i = len-1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                break;
            }else {
                result++;
            }
        }
        return result;
    }
}
