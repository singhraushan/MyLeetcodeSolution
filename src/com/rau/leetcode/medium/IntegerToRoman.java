package com.rau.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println("intToRoman: " + intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String roman = "";
        if (num <= 0)
            return roman;
        int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        for (int i : bases) {
            while (num >= i) {
                roman += map.get(i);
                num -= i;
            }
        }
        return roman;
    }
}
