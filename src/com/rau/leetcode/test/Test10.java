package com.rau.leetcode.test;

public class Test10 {

    public static void main(String[] args) {
        swap(2,3);
    }

    public static void swap(int a, int b) {//2,3
       a= a+b;//a=5,b = 3
       b = a-b;//a=5,b = 2
       a = a-b;//a=3,b=2
       System.out.println("a:"+a+"---b:"+b);
    }
}
