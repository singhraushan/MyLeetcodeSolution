package com.rau.leetcode.medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring is :" + lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxSubStr = 0;
        if (len == 1)
            return 1;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                HashMap<Character, String> map = new HashMap<>();
                boolean iSDuplicate = false;
                for (int k = i; k <= j; k++) {
                    char c = s.charAt(k);
                    if (map.get(c) != null) {
                        iSDuplicate = true;
                        break;
                    } else {
                        map.put(c, "");
                    }
                }
                if (!iSDuplicate && map.size() > maxSubStr) {
                    maxSubStr = map.size();
                }
            }
        }

        return maxSubStr;
    }
}
