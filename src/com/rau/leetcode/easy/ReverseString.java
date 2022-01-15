package com.rau.leetcode.easy;


public class ReverseString {
    public static void main(String[] args) {
        char[] arr= new char[]{'h','e','l','l','o'};
        reverseString(arr);
        System.out.println(new String(arr));//olleh
    }
    public static void reverseString(char[] s) {
       int left =0,right = s.length-1;
       while (left<right){
           char temp = s[left];
           s[left++] = s[right];
           s[right--]=temp;
       }
    }
}
