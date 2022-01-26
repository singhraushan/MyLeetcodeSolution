package com.rau.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1,2,3,4});
        System.out.println("res:"+IntStream.of(res).boxed().collect(Collectors.toList()));//[24,12,8,6]

        res = productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println("res:"+IntStream.of(res).boxed().collect(Collectors.toList()));//[0,0,9,0,0]

        res = productExceptSelf(new int[]{1,-1});
        System.out.println("res:"+IntStream.of(res).boxed().collect(Collectors.toList()));//[-1,1]

        res = productExceptSelf(new int[]{1,1,1,1,-1,1,5,1,-1,-1,-1,1,-1,1,-3,1,1,1,1,1,1,1,-1,1,-1,1,1,5,-1,1,-1,1,1,3,-1,-5,-1,1,-1,1,-1,-3,1,2,-1,1,-1,1,-1,1,1,1,1,1,-1,-1,-1,-3,-1,-1,4,-1,1,-1,1,-1,-1,-1,-1,3,1,4,-5,-1,1,1,1,1,1,-4,1,1,-3,-1,-1,1,3,-1,1,-2,1,-1,1,1,1,-1,1,1,1,-1});
        System.out.println("res:"+IntStream.of(res).boxed().collect(Collectors.toList()));//
    }
    static Map<String,Integer> seen = new HashMap<>();
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length,mul=1;
        int[] res = new int[len];
        boolean isZero=false,moreThan1=false;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                if(isZero)moreThan1=true;
                isZero = true;
            }else {
                mul *=nums[i];
            }
        }
        if(moreThan1)return res;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                    res[i]=mul;
            }else if(!isZero){
                //1st way: using division operator
                //res[i]=mul/nums[i];

                //2nd way: without using division operator
                if(seen.containsKey(mul+","+nums[i])){
                     res[i]=seen.get(mul+","+nums[i]);
                 }else
                    res[i]=getQuotient(mul,nums[i]);
            }
        }
        return res;
    }
    private static int getQuotient(int dividend, int divisor){
        boolean isNeg = false;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) isNeg = true;

      int quotient = 0, originalDividend = dividend, originalDivisor = divisor;
      dividend = Math.abs(dividend);divisor = Math.abs(divisor);

      while (dividend>=divisor){
          dividend -=divisor;
          quotient++;
      }
      if(isNeg) {
          quotient = -quotient;
          seen.put(originalDividend + "," + -originalDivisor, -quotient);
          seen.put(originalDividend+","+originalDivisor,quotient);
      }else {
          seen.put(originalDividend + "," + originalDivisor, quotient);
          seen.put(originalDividend + "," + -originalDivisor, -quotient);
      }
      return quotient;
    }
}
