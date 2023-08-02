package com.rau.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class UbsTest {

    public static void main(String[] args) {
        //System.out.println(getSequenceSum(5,9,6));
        List<String> res = new ArrayList<>();
        permutaion(new StringBuilder("abc"),0,res);
        System.out.println("res:"+res);
    }

    public static long getSequenceSum(int i, int j, int k) {
        long res = 0;
        for (int fi = i; fi < j; fi++) {
            res += fi;
        }
        for (int fj = j; fj >= k; fj--) {
            res += fj;
        }
        return res;
    }

    public static void permutaion(StringBuilder input, int curIndex, List<String> res) {
        if (curIndex==input.length()){
            res.add(input.toString());
        }else {
            for(int i=curIndex;i<input.length();i++){
                swap(input,curIndex,i);
                permutaion(input, curIndex+1, res);
                swap(input,curIndex,i);
            }
        }
    }

    public static void swap(StringBuilder sb, int i, int j) {
        char ch = sb.charAt(i);
        sb.replace(i,i+1,Character.toString(sb.charAt(j)));
        sb.replace(j,j+1,Character.toString(ch));
    }
}
