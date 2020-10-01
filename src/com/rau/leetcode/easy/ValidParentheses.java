package com.rau.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("isValid: " + isValid("{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !(map.get(ch) == stack.pop())) {
                    return false;
                }
            }
        }
        return !(stack.size() > 0);
    }

}
