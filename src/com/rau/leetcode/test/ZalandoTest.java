package com.rau.leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZalandoTest {
    public static void main(String[] args) {
        System.out.println("res:"+solution2("aaaabbbb"));//1
        System.out.println("res:"+solution2("ccaaffddecee"));//6
        System.out.println("res:"+solution2("eeee"));//0
        System.out.println("res:"+solution2("example"));//4
    }
    public static int solution2(String S) {
        Map<Character,Integer> seenCount = new HashMap<>();
        int len = S.length();
        for(int i=0;i<len;i++){
           char ch = S.charAt(i);
            if (seenCount.containsKey(ch)){
                int count = seenCount.get(ch);
                seenCount.put(ch,++count);
            }else {
                seenCount.put(ch,1);
            }
        }

        Set<Integer> uniuqe = new HashSet<>();
        int res = 0;
        for(Character key : seenCount.keySet()){
            int v = seenCount.get(key);
            if(uniuqe.contains(v)){
                int currCount=0;

                for(int i=v-1;i>=0;i--){
                    currCount++;
                    if(!uniuqe.contains(i)){
                        res+=currCount;
                        uniuqe.add(i);
                        break;
                    }else if(i==0){
                        uniuqe.add(0);
                        res+=currCount;
                    }
                }
            }else {
                uniuqe.add(v);
            }
        }
        return res;
    }

    public int solution1(String S) {
        int out = -1;
        for (int i=0; i<S.length()-1; i++) {

            int val = ((S.charAt(i) -'0') * 10 ) + (S.charAt(i+1)-'0');
            if (val > out) {
                out = val;
            }
        }
        return out;
    }
    public int solution3(int[] A) {
        int out = Integer.MAX_VALUE;
        for (int i=1; i < A.length-2; i++) {
            for (int j=i+2; j < A.length; j++) {
                int val = A[i] + A[j];
                if (val < out) {
                    out = val;
                }
            }
        }
        return out;
    }
}
