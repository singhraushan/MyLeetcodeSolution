package com.rau.leetcode.medium;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println("reverseWords: " + reverseWords("the sky is blue"));
        System.out.println("reverseWords: " + reverseWords("  hello world!  "));
        System.out.println("reverseWords: " + reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        int len = words.length;

        for (int i=len-1;i>=0;i--) {
            String word = words[i].trim();
            if (!word.isEmpty()) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
