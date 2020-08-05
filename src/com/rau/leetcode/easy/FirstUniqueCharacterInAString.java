package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));//0
        System.out.println(firstUniqChar("loveleetcode"));//2
        System.out.println(firstUniqChar("aadadaad"));//-1
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        List<Character> deleted = new ArrayList<>();

        int size = s.length();
        for (int i=0;i<size;i++){
            if(map.containsKey(s.charAt(i))){
                map.remove(s.charAt(i));
                deleted.add(s.charAt(i));
            }else if(!deleted.contains(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
        }
        if(map.size()==0)  return -1;
         Collection<Integer> c = map.values();
         return c.stream().findFirst().get();
    }

}
