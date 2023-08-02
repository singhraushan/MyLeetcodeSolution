package com.rau.leetcode.test;

import java.util.Scanner;

public class TechgigCodeGladiators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String virusName = sc.next().trim();
        int bloodCount = sc.nextInt();
        for(int i=0;i<bloodCount;i++){
            if(isNegative(sc.next().trim(),virusName)==-1){
                System.out.println("NEGATIVE");
            }else {
                System.out.println("POSITIVE");
            }
        }
    }

    public static int isNegative(String blood,String virus) {
        int len = blood.length(), start = 0;

        for(int i=0;i<len;i++){
            char ch = blood.charAt(i);
            start = virus.indexOf(ch,start);
            if(start==-1){
                return -1;
            }
        }
        return 0;
    }

}
