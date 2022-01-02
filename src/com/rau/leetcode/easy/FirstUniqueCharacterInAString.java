package com.rau.leetcode.easy;

import java.util.LinkedHashMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));//0
        System.out.println(firstUniqChar("loveleetcode"));//2
        System.out.println(firstUniqChar("aadadaad"));//-1
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();

        int size = s.length();
        for (int i=0;i<size;i++){
            if(map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i), -1);
            }else{
                map.put(s.charAt(i), i);
            }
        }

        for(int index: map.values()){
            if(index!=-1)
                return index;
        }
        return -1;
    }

}
