package com.rau.leetcode.test;

import java.util.*;
import java.util.stream.Collectors;

public class GrabTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,1};
        //int[] arr = new int[]{1, 4, -1, 3, 2};
        System.out.println("res: " + solution1(arr));
    }

    public static int solution1(int[] A) {

        int res = 0, i = 0, len = A.length;
        Set<Integer> seen = new HashSet<>();

        for (int k = 0; k < len; k++) {
            int v = A[i];
            if (v == -1) {
                return ++res;
            } else if (v < len && v > -1) {
                if(seen.contains(v)){
                    return res;
                }
                seen.add(v);
                i = v;
                ++res;
            } else {
                throw new RuntimeException("Input is not correct(Out of index)");
            }
        }
        return res;
    }

    public static int[] solution(int[] A, int[] B) {

        int aVal = getSum(A), bVal = getSum(B);

        List<Integer> out = new ArrayList<>();
        int value = aVal + bVal;

        while (value != 0) {
            int remainder = value % -2;
            value = value / -2;
            if (remainder < 0) {
                remainder += 2;
                value += 1;
            }
            out.add(remainder);
        }

        int[] tout = new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            tout[i] = out.get(i);
        }

        return tout;
    }

    private static int getSum(int[] A){
        int sum =0, len = A.length;
        for (int i=0; i<len; i++) {
            sum += A[i] * Math.pow(-2, i);
        }
        return sum;
    }
}
