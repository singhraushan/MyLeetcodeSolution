package com.rau.leetcode.hard;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println("res:"+calculate("1 + 1"));//2
    }
    public static int calculate(String s) {
        int res=0;
        Stack<String> nums = new Stack<>();
        Stack<Character> operators = new Stack<>(),opens = new Stack<>();
        for (char ch : s.toCharArray()){
            if(ch=='('){
                opens.add(ch);
            }else if(ch=='+' || ch=='-'){
                operators.add(ch);
            }else if(ch==' ' || ch==')'){

            }else {

            }
        }
        return res;
    }
    private static int calculate(int a, char sign, int b) {
        switch (sign){
            case '+': return a+b;
            default: return a-b;
        }
    }
}
