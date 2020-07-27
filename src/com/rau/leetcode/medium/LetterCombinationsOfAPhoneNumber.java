package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static public List<String> letterCombinations(String digits) {
        List<String> result = null;
        Map<String, String> map = map();
        int len = digits.length();

        for (int i = 0; i < len; i++) {
            result = build(map, String.valueOf(digits.charAt(i)), result);
        }
        if (result == null)
            return new ArrayList<>();
        return result;
    }

    static public List<String> build(Map<String, String> map, String currVal, List<String> list) {

        String val = map.get(currVal);
        if (val == null)
            return null;

        if (list == null) {
            list = new ArrayList<>();
            for (int i = 0; i < val.length(); i++) {
                list.add(String.valueOf(val.charAt(i)));
            }
            return list;
        } else {
            List<String> total = new ArrayList<>();
            int size = list.size();

            for (int j = 0; j < size; j++) {
                for (int i = 0; i < val.length(); i++) {
                    total.add(list.get(j).concat(String.valueOf(val.charAt(i))));
                }
            }
            return total;
        }
    }

    static public Map<String, String> map() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return map;
    }
}
