package com.rau.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println("multiply: " + multiply("2", "3"));//6
        System.out.println("multiply: " + multiply("123", "456"));//56088
        System.out.println("multiply: " + multiply("123456789","987654321"));//121932631112635269
        System.out.println("multiply: " + multiply("498828660196","840477629533"));//419254329864656431168468
    }

    public static String multiply(String num1, String num2) {
        Map<Character, Integer> map = new HashMap();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        int len1 = num1.length(), len2 = num2.length(), i = 0, j = 0;
        long n1 = 0, n2 = 0;
        while (i < len1 || j < len2) {
            if (i < len1) {
                n1 = n1 * 10 + map.get(num1.charAt(i));
                i++;
            }

            if (j < len2) {
                n2 = n2 * 10 + map.get(num2.charAt(j));
                j++;
            }
        }
        long res = n1 * n2;
        if (res == 0)
            return "0";
        String str = "";
        if(res<0) res = -res;
        while (res != 0) {
            str = res % 10 + str;
            res /= 10;
        }
        return str;
    }
}
