package com.rau.leetcode.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {

        System.out.println("res:" + evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println("res:" + evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println("res:" + evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for (String v : tokens) {
            switch (v) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    int first = stack.pop();
                    int sec = stack.pop();
                    stack.push(sec - first);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int first = stack.pop();
                    int sec = stack.pop();
                    stack.push(sec / first);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(v));
            }
        }
        return stack.pop();
    }
}
