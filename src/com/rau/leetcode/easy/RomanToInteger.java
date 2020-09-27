package com.rau.leetcode.easy;


import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));//1994
    }

    //Roman numerals are represented by seven different symbols: I, V, X, L(50), C(100), D(500) and M(1000).
    public static int romanToInt(String s) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);//no need 4 separate
        map.put('X', 10);//no need 9 separate
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(),prev = 0;
        for (int i = 0; i < len; i++) {
            int val = map.get(s.charAt(i));
            if (res == 0) {
                res = val;
            } else if (val > prev) {
                res = res + val - 2*prev;//since added once already, so substracting twice
            } else {
                res += val;
            }
            prev = val;
        }
        return res;
    }
}
