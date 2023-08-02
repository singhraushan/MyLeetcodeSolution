package com.rau.leetcode.test;

import java.util.*;

public class OracleTest {
    public static void main(String[] args) {
        //{101,50,2}--->{50,2,101}
        Integer[] res= sort(new Integer[]{1,10});
        for(int t: res){
            System.out.print(t+",");
        }
    }

    public static Integer[] sort(Integer[] input) {
        Arrays.sort(input,new CustomComparator());
        return input;
    }
    static class CustomComparator implements Comparator{
        public int compare(Object o1, Object o2) {
           int i1 = ((Integer)o1).intValue(), i2 = ((Integer)o2).intValue();
            if( i1 == i2){
               return 0;
            }
            List<Integer> digits1 = getDigit(i1);
            List<Integer> digits2 = getDigit(i2);
            int len = Math.min(digits1.size(),digits2.size());
            for(int i=0;i<len;i++){
                if(digits1.get(i)>digits2.get(i))
                   return -1;
                if(digits1.get(i)<digits2.get(i))
                    return 1;
            }

            if(digits1.size()>digits2.size()){
                if(digits1.get(len)==0){
                    return 1;
                }else
                    return -1;
            }else {
                if(digits2.get(len)==0){
                    return -1;
                }else
                    return 1;
            }
        }
        public List<Integer> getDigit(int number) {
            List<Integer> list = new ArrayList<>();
            while(number>0){
               list.add(number%10);
               number /=10;
           }
            Collections.reverse(list);
             return list;
        }
    }

}
