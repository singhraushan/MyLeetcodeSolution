package com.rau.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println("plusOne: "+ Arrays.toString(plusOne(new int[]{9,0,1})));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length, rem = 0;
        int j=len-1;
        int[] res = new int[0];
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                if (i == 0) {
                    res = new int[len + 1];
                    j = len;
                }
            } else {
                res = new int[len];
                break;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            int val = digits[i];
            if(i==len-1){
                if (val == 9) {
                    res[j] = 0;
                    rem = 1;
                } else {
                    res[j] = val + 1;
                }
            }else{
                if (val == 9) {
                    if(rem==1){
                        res[j]=0;
                        rem = 1;
                    }else {
                        res[j] = 9;
                    }
                } else {
                    res[j] = val + rem;
                    rem = 0;
                }
            }
            j--;
        }
        if(rem==1){
            res[0]=1;
        }
        return res;
    }
}
