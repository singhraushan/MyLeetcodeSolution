package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));//true
        System.out.println(isIsomorphic("foo","bar"));//false
        System.out.println(isIsomorphic("paper","title"));//true
        System.out.println(isIsomorphic("ab","aa"));//false
    }

    public static boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen)
            return false;
        Map<Character, Character> sMapT = new HashMap<>();

        for (int i = 0; i < sLen; i++) {
            if (sMapT.containsKey(s.charAt(i))) {
                if (sMapT.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if(sMapT.containsValue(t.charAt(i))) return false;
                sMapT.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
