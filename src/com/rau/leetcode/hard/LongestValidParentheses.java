package com.rau.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println("longestValidParentheses: " + longestValidParentheses(")()())"));
        //System.out.println("longestValidParentheses: " + longestValidParentheses("())()()((()()()))"));
        //System.out.println("longestValidParentheses: " + longestValidParentheses("()()))(()())"));
        //System.out.println("longestValidParentheses: " + longestValidParentheses("()(())"));
    }

    public static int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || len == 1)
            return 0;
        int maxLen = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j+=2) {// no need to check odd length.
                if ((j - i) % 2 != 0 && isValidParentheses(s.substring(i, j + 1), map)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static boolean isValidParentheses(String input, Map<Character, Character> map) {
        Stack<Character> stack = new Stack<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']' || ch == '}' || ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(stack.pop()) != ch) {
                    return false;
                }
            } else {//not a parentheses
                return false;
            }
        }
        return stack.isEmpty();
    }
    //2nd way 
    /*public static int longestValidParentheses(String s) {
        int len = s.length(), maxLen = 0, temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j += 2) {// no need to check odd length.
                temp = (j - i);
                if (temp > maxLen && isValidSmallParentheses(s.substring(i, j + 1))) {
                    temp++;
                    maxLen = maxLen > temp ? maxLen : temp;
                }
            }
        }
        return maxLen;
    }

    public static boolean isValidSmallParentheses(String input) {
        int stackCount = 0, len = input.length();
        char open = '(', ch;
        if(input.charAt(0)==')' || input.charAt(len-1)==open)
            return false;
        for (int i = 0; i < len; i++) {
            ch = input.charAt(i);
            if (ch == open) {
                stackCount++;
            } else {
                if (stackCount == 0)
                    return false;
                stackCount--;
            }
        }
        return stackCount == 0 ? true : false;
    }
    */
}
