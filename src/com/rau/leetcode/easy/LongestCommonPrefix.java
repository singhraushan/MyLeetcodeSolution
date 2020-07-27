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
        for (int i = firstStrLen; i > 0; i--) {
            String subStr = firstStr.substring(0, i);

            for (int j = 1; j < len; j++) {
                if (!strs[j].contains(subStr)) {
                    break;
                }else if(strs[j].length()>subStr.length()){
                    String prefix = strs[j].substring(0,subStr.length());
                    if (!(prefix.equals(subStr))) {
                        break;
                    }
                }

                if (j == len - 1)
                    return subStr;
            }
        }
        return "";
    }
}
