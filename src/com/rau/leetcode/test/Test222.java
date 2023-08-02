package com.rau.leetcode.test;

import java.util.TreeMap;

public class Test222 {
    public static void main(String[] args) {
        String s1= new String("abc");
        String s2= "abc";
        String s3= new String("abc");
        System.out.println(s1==s1.intern());
        System.out.println(s2==s2.intern());
        System.out.println(s1.intern()==s3.intern());
        new TreeMap().lastEntry().getValue();


    }
}
