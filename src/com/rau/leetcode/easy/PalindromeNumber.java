package com.rau.leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("isPalindrome: " + isPalindrome(121));//true
        System.out.println("isPalindrome: " + isPalindrome(-121));//false
        System.out.println("isPalindrome: " + isPalindrome(10));//false

    }

    public static boolean isPalindrome(int x) {
        int rev = 0, original = x;
        int max = Integer.MAX_VALUE / 10;
        while (x != 0) {
            if (rev > max) {
                rev = 0;
                break;
            }
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return original == rev && rev >= 0;
    }
}
