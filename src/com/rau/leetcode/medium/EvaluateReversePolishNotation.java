package com.rau.leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line="110011,1010";

        while ((line = in.readLine()) != null) {

            String[] str = line.trim().split(",");
            String s1 = str[0].trim(),s2 = str[1].trim() ;

            int l1 = s1.length();
            int l2 = s2.length();

            int rem = 0;
            String out = "";

            while (l1 > 0 || l2 > 0) {

                String val1 = "0";
                String val2 = "0";

                if (l1 > 0) {
                    val1 = s1.charAt(l1 - 1) + "";
                }

                if (l2 > 0) {
                    val2 = s2.charAt(l2 - 1) + "";
                }


                if (val1.equals("1") && val2.equals("1")) {
                    if (rem == 1) {
                        out = "1" + out;
                    } else {
                        out = "0" + out;
                    }
                    rem = 1;

                } else if (!val1.equals(val2)) {
                    if (rem == 1) {
                        out = "0" + out;
                        rem = 1;
                    } else {
                        out = "1" + out;
                        rem = 0;
                    }
                } else {
                    if (rem == 1){
                        out = "1" + out;
                    } else {
                        out = "0" + out;
                    }
                    rem = 0;
                }

                l1--;
                l2--;
            }
            System.out.println(out.contains("1")?out:"0");


        }

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
