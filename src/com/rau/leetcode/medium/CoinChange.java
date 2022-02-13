package com.rau.leetcode.medium;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
    }
    public static int coinChange(int[] coins, int amount) {
        int len =coins.length;
        if(amount==0 || len==0) return 0;
        int[] dp = new int[amount+1];

        for(int am=1;am<=amount;am++){
            dp[am]=Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin<=am && dp[am-coin]!=Integer.MAX_VALUE) dp[am] = Math.min( dp[am], dp[am-coin]+1 );
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

}
