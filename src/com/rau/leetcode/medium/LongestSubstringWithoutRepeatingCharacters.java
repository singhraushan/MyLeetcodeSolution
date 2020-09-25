package com.rau.leetcode.medium;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring is :" + lengthOfLongestSubstring("pwwkew"));
        System.out.println("lengthOfLongestSubstring is :" + lengthOfLongestSubstring("abcdcfgh"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length(), max = 0, end_pointer = 0;
        String seen = "";
        while (end_pointer < len) {
            String ch = String.valueOf(s.charAt(end_pointer));
            if (seen.contains(ch)) {
                seen = seen.substring(seen.indexOf(ch)+1);
            }
            seen = seen + ch;
            max = Math.max(max, seen.length());
            end_pointer++;
        }
        return max;
    }
}
