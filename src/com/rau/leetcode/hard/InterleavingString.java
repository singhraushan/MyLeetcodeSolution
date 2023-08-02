package com.rau.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class InterleavingString {
    public static void main(String[] args) {
        System.out.println("isInterleave: "+isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        Queue<Character> q1 = new LinkedList<>(),q2 = new LinkedList<>();
        int l1= s1.length(),l2= s2.length(),l3= s3.length();
        int i=0,j=0,k=0;
        while(k<l3){
            if(i<l1){
                q1.add(s1.charAt(i++));
            }
            if(j<l2){
                q2.add(s2.charAt(j++));
            }
            char ch = s3.charAt(k++);
            if(!q1.isEmpty() && q1.element()==ch && !q2.isEmpty() && q2.element()==ch){
                //complex
            }else if(!q1.isEmpty() && q1.element()==ch){
                q1.poll();
            }else if(!q2.isEmpty() && q2.element()==ch){
                q2.poll();
            }else {
                if(k==9){
                    System.out.println("q1:"+q1);
                    System.out.println("q2:"+q2);
                }
                System.out.println("ch: "+ch+"--k:"+k);
                return false;
            }
        }
        System.out.println("q1.isEmpty() && q2.isEmpty():"+(q1.isEmpty() && q2.isEmpty()));
        return q1.isEmpty() && q2.isEmpty();
    }
}
