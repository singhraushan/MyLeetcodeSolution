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
        if(len==1)
            return 1;
        int start = 0;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i) != ' ' && s.charAt(i-1)==' ')
                start = i;
        }
        return len-start;
    }
}
