package com.rau.leetcode.easy;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String res = "1";
        for(int i=1;i<n;i++){
            res = say(res);
        }
        return res;
    }

    private static String say(String s) {
        int count=1;
        char prev=s.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev){
                count++;
            }else {
                sb.append(count);
                sb.append(prev);
                count=1;
                prev=s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}
