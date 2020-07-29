package com.rau.leetcode.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Is valid isPalindrome :" + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Is valid isPalindrome :" + isPalindrome("race a car"));
        System.out.println("Is valid isPalindrome :" + isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        int j = len;
        for (int i = 0; i < len; i++) {
            char left = s.charAt(i);
            if (!((left >= 65 && left <= 90) || (left >= 97 && left <= 122) || (left >= 48 && left <= 57))) {
                continue;
            }

            while (isNotChar(s, --j)) {
            }
            char right = s.charAt(j);

            if (!Character.toString(left).equalsIgnoreCase(Character.toString(right))) {
                return false;
            }

        }
        return true;
    }

    public static boolean isNotChar(String s, int index) {
        char right = s.charAt(index);
        if ((right >= 65 && right <= 90) || (right >= 97 && right <= 122) || (right >= 48 && right <= 57)) {
            return false;
        }
        return true;
    }


}
