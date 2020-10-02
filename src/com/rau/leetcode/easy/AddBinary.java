package com.rau.leetcode.easy;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1", "1"));//10
        System.out.println(addBinary("11", "1"));//100
        System.out.println(addBinary("1010", "1011"));//10101
        System.out.println(addBinary("100", "1"));//101
        System.out.println(addBinary("101", "101"));//1010
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry =0;//carry cab be max 1.

        while (i>=0 && j >=0) {
            char a1 = a.charAt(i--), b1 = b.charAt(j--);
            if(a1==b1){
                if(a1=='0'){
                    if(carry>0){
                        sb.append(1);
                        carry=0;
                    }else {
                        sb.append(0);
                    }
                }else {//both are 1
                    if(carry>0){
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    carry=1;
                }
            }else {// 0 & 1
                if(carry>0){
                    sb.append(0);
                    carry=1;
                }else {
                    sb.append(1);
                }
            }
        }
        while (i >=0) {
            char a1 = a.charAt(i--);
            if(a1=='0'){
                if(carry>0){
                    sb.append(1);
                    carry=0;
                }else {
                    sb.append(0);
                }
            }else {//1
                if(carry>0){
                    sb.append(0);
                    carry=1;
                }else {
                    sb.append(1);
                }
            }
        }
        while (j >=0) {
            char b1 = b.charAt(j--);
            if(b1=='0'){
                if(carry>0){
                    sb.append(1);
                    carry=0;
                }else {
                    sb.append(0);
                }
            }else {//1
                if(carry>0){
                    sb.append(0);
                    carry=1;
                }else {
                    sb.append(1);
                }
            }
        }
        if(carry>0)
            sb.append(1);
        return sb.reverse().toString();
    }

}
