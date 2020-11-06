package com.rau.leetcode.easy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("maxProfit: "+maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int max=0,len = prices.length;

        for (int i=0;i<len;i++) {

            int startPointer =i+1, endPointer=len-1, v =prices[i];

            while(startPointer<=endPointer) {
                int c1 = prices[startPointer];
                if (c1>v) {
                    if (c1-v > max) {
                        max =  c1-v;
                    }
                }
               int c2 =prices[endPointer];
                if (c2>v) {
                    if (c2-v > max) {
                        max =  c2-v;
                    }
                }
                ++startPointer ;
                --endPointer;
            }
        }
        return max;
    }
}
