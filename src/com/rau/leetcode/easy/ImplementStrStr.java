package com.rau.leetcode.easy;

public class ImplementStrStr {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("strStr: "+strStr("hello","ll"));
        System.out.println("strStr: "+strStr("aaaaa","bba"));
        System.out.println("strStr: "+strStr("abc","c"));
        System.out.println(System.nanoTime()-startTime);
    }

    public static int strStr(String haystack, String needle) {
        int nLen = needle.length(), hLen = haystack.length();
        if (nLen == 0)
            return 0;
        else if (hLen < nLen || !haystack.contains(needle))
            return -1;

        int matchedIndex = 0;
        for (int i = 0; i < hLen; i++) {

            for (int j = 0; j < nLen; j++) {

                if (i+j < hLen && haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == 0)
                        matchedIndex = i;
                    if (j == nLen - 1)
                        return matchedIndex;
                } else
                    break;
            }
        }
        return -1;
    }
}
