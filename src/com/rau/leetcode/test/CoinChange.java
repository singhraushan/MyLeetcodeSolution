package com.rau.leetcode.test;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(possibleWays3(new int[]{1,2},3));
        System.out.println(possibleWays3(new int[]{2,3},5));
        System.out.println(possibleWays3(new int[]{2,3},7));
    }
    public static int possibleWays( int coins[], int target) {
        int table[]=new int[target+1];
        table[0] = 1;
        for(int coin : coins)
            for(int amount=coin; amount<=target; amount++)
                table[amount] += table[amount-coin];
        return table[target];
    }
    public static int possibleWays2( int coins[], int target) {
        int table[]=new int[target+1];
        table[0] = 1;
        for(int coin : coins){
            for(int amount=1; amount<=target; amount++){
                if(amount>=coin){
                    table[amount] += table[amount-coin];
                }
            }
        }
        return table[target];
    }
    public static int possibleWays3( int coins[], int target) {
       int table[] = new int[target+1];

       table[0]=1;

       for(int c=0;c<coins.length;c++){
           for (int i=coins[c];i<target+1;i++){
               table[i] = table[i]+ table[i-coins[c]];
           }
       }
       return table[target];
    }
}
