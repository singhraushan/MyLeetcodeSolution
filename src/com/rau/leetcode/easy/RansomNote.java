package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println("res:"+canConstruct("a", "b"));
        System.out.println("res:"+canConstruct("aa", "ab"));
        System.out.println("res:"+canConstruct("aa", "aab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> magazineWordsCountMap = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            magazineWordsCountMap.put(ch,magazineWordsCountMap.getOrDefault(ch,0)+1);
        }

        for(char ch : ransomNote.toCharArray()){
            if(magazineWordsCountMap.containsKey(ch)){
                int count = magazineWordsCountMap.get(ch);
                if(count==1)
                    magazineWordsCountMap.remove(ch);
                else magazineWordsCountMap.put(ch,--count);
            }else return false;
        }

        return true;
    }
}
