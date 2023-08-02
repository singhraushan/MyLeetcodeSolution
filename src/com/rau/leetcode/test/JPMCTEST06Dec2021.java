package com.rau.leetcode.test;

import java.util.Iterator;
import java.util.TreeSet;

public class JPMCTEST06Dec2021 {
    public static void main(String[] args) {
        //find duplicate number
        //1,2,3,4,4,6,5}//output: 4,5
        //1,2,3,3,4,4,6,5}//output: 3,4
        //1,2,3,4,4}//output: 4
        //1,2,3,5,4,4,6}//output: 4,5

        /*test(new int[]{1,2,3,4,4,6});*/

        System.out.println(longestSubstring("abcabcbb"));//3
        System.out.println(longestSubstring("bbbbb"));//1
        System.out.println(longestSubstring("pwwkew"));//3
        System.out.println(longestSubstring(""));//0
    }
    public static void test(int[] input) {
         int dup=-1,nextNum=-1,len= input.length;
        TreeSet<Integer> set = new TreeSet<>();
        boolean isFirstDup =false;
        //dup
         for(int i=0;i<len;i++){
             int curr = input[i];
             if(set.contains(curr) && isFirstDup==false){
              dup=curr;
              isFirstDup = true;
             }
             set.add(curr);
         }
        Iterator<Integer> iterator = set.iterator();
         boolean nextFound = false;

        while (iterator.hasNext()){
            int v = iterator.next();
            if(nextFound) {
                nextNum = v;
                break;
            }
            if(v==dup){
                nextFound = true;
            }
        }

         if(dup!=-1){
             System.out.print("result:"+dup);
             if(nextNum!=-1)
                 System.out.println(" "+nextNum);
         }
    }

    public static int longestSubstring(String input) {//O(n*n)

        int len = input.length(), max=1;
        if(len==0)
            return 0;
        if(len==1)
            return 1;
        for(int i=0;i<len;i++){
            String s=""+input.charAt(i);
            for(int j=i+1;j<len;j++){
               char ch = input.charAt(j);
                if(s.contains(String.valueOf(ch))){
                   break;
                }
                s = s+ch;
                max = Math.max(max,s.length());
            }
        }
        return max;

    }
}
