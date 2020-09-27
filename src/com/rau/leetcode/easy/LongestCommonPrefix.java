package com.rau.leetcode.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("longestCommonPrefix: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("longestCommonPrefix: " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("longestCommonPrefix: " + longestCommonPrefix(new String[]{"c", "acc", "ccc"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0)
            return "";
        String firstStr = strs[0];
        if (len == 1)
            return firstStr;
        int firstStrLen = firstStr.length();
        for (int i = 0; i < firstStrLen; i++) {
            String subStr = firstStr.substring(0, i+1);

            for (int j = 1; j < len; j++) {
                if(!strs[j].startsWith(subStr)){
                    if(subStr.length()-1>0){
                        return subStr.substring(0,subStr.length()-1);
                    }else return "";
                }
            }
        }
        return firstStr;
    }
}
