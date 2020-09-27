package com.rau.leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println("intToRoman: " + intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String roman = "";
        if (num <= 0)
            return roman;
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        for (int key : map.keySet()) {
            while (num >= key) {
                roman += map.get(key);
                num -= key;
            }
        }
        return roman;
    }
}
