package com.rau.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test15 {
    public static void main(String[] args) {

        List<Integer> list1= new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2= new ArrayList<Integer>();
        list2.add(2);
        list2.add(5);
        list2.add(4);
        list2.add(9);
        System.out.println(list1.contains(2));
        System.out.println(list1.contains(5));
        System.out.println(list1.contains(4));
        System.out.println(list1.contains(9));
        System.out.println(list1.containsAll(list2));


        new Test15().m(null);
        //System.out.println(letterCount("Exception"));

    }
    public void m(String input) {
        System.out.println("String-"+input);
    }
    public void m(Object input) {
        System.out.println("Object-"+input);
    }
    public static Map<Character,Integer> letterCount(String input) {

      Map<Character,Integer> seen = new HashMap<>();
        if(input==null)
            return seen;
        input = input.toLowerCase();
        int len = input.length();
      for(int i=0;i<len;i++ ){
           char ch = input.charAt(i);
          Integer check = seen.get(ch);
           if(check!=null){
               seen.put(ch,check+1);
           }else {
               seen.put(ch,1);
           }
       }
        return seen;
    }
}
