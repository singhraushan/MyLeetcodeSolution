package com.rau.leetcode.easy;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));//true
        System.out.println(reverseWords("God Ding").equals("doG gniD"));//true
    }
    public static String reverseWords(String s) {
        String space = " ";
        String[] words = s.split(space);

        StringBuilder sb = new StringBuilder();
        for (String word: words){
            reverseString(word,word.length()-1, sb);
            sb.append(space);
        }
        return sb.toString().trim();
    }
    private static void reverseString(String word, int currIndex,StringBuilder sb) {
        if(currIndex>=0) {
            sb.append(word.charAt(currIndex));
            reverseString(word,currIndex-1,sb);
        }
    }
}
