package com.rau.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result.size());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            int uniqueHashCode = sortedStr.hashCode();
            List<String> tempList = map.get(uniqueHashCode);
            if (tempList != null) {
                tempList.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                map.put(uniqueHashCode,list);
            }
        }
        return result;
    }
}
