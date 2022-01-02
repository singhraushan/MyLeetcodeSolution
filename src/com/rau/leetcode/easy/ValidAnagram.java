package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> seen = new HashMap<>();
        for(char ch : s.toCharArray()){
            seen.put(ch,seen.getOrDefault(ch,0)+1);
        }

        for(char ch : t.toCharArray()){
            if(seen.containsKey(ch)){
                int count = seen.get(ch);
                if(count==1)
                    seen.remove(ch);
                else seen.put(ch,--count);
            }else return false;
        }

        return seen.isEmpty();
    }
}
