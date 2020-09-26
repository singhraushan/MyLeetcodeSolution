package com.rau.leetcode.easy;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("Reverse: " + reverse(120));
    }

    public static int reverse(int x) {
        int rev = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (rev > max)
                return 0;
            else if (rev < min)
                return 0;
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }
}
