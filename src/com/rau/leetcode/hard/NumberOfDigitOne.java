package com.rau.leetcode.hard;

public class NumberOfDigitOne {
    public static void main(String[] args) {
        System.out.println("res:"+countDigitOne(13));
        System.out.println("res:"+countDigitOne(0));
    }
    public static int countDigitOne(int n) {
        int count =0;
        for (int i=1;i<=n;i++) count +=countDigit(String.valueOf(i));
        //for (int i=1;i<=n;i++) count +=countDigit(i);
        return count;
    }
    private static int countDigit(int n) {
        int count=0;
        while(n!=0) {
            if(n%10==1) count++;
            n = n/10;
        }
        return count;
    }
    private static int countDigit(String n) {
        int count=n.length();
        n = n.replaceAll("1","");
        return count-n.length();
    }
}
