package com.rau.leetcode.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class VKeyTest {
    public static void main(String[] args) {
        //solution1(4);

        //System.out.println(solution2(new int[]{3,5,7},new int[]{1,2,2,3,3,4}));
        //System.out.println(solution2(new int[]{1,3,2,1},new int[]{4,2,5,3,2}));
        //System.out.println(solution2(new int[]{4,2,5,3,2},new int[]{1,3,2,1}));
        //System.out.println(solution3(new int[]{100, 200, 100}, new int[]{50, 100, 100}, 100, 100));
        //solution5();
    }
    public static void solution1(int N) {
        StringBuilder sb = new StringBuilder();
        String s ="L";
        for(int i=1;i<=N;i++){
            sb.append(s);
            if(i!=N){
                System.out.println(s);
            }else {
                System.out.println(sb);
            }
        }
    }
    static int solution2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n || i<m; ) {
            if (B[i] < A[k]) {
                if(i<m-1)i += 1;
                else k++;
            }else if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
    public static int solution3(int[] A, int[] B, int X, int Y) {
        int len = A.length;
        int count=0,R=400;
        for(int i=0;i<len;i++){
            System.out.println(((X-A[i])*(X-A[i])+(Y-B[i])*(Y-B[i])));
            if(((X-A[i])*(X-A[i])+(Y-B[i])*(Y-B[i]))<=R){
                count++;
            }
        }
        return count;
    }
    public int solution4(int[] A, int M) {
        int len = A.length;
        int max=1;
        for(int i=0;i<len;i++){
            int m1 =1,m2=1;
            for(int j=i+1;j<len;j++){
                if(Math.abs(A[i]-A[j])%M==0){
                    m1++;
                }
                if(Math.abs(A[j]-A[i])%M==0){
                    m2++;
                }
            }
            max = Math.max(max,Math.max(m1,m2));
        }
        return max;
    }
    public static String solution5(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> wordToNumber = new HashMap<>();
        for(int i=0;i<len;i++){
            sb.append(str.charAt(i));
        }
        return str;
    }

    public static String solution6() {
   return "";
    }
}


