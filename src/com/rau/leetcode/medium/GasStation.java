package com.rau.leetcode.medium;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));//3
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));//-1
        System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));//4
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, index = 0;
        for (int i = 0; i < cost.length; i++) {
            int cur = gas[i] - cost[i];

            tank += cur;
            if (tank < 0) {//if sum < 0, index can only start from i + 1
                index = i + 1;
                tank = 0;
            }
            total += cur;
        }
        return total < 0 ? -1 : index;
    }

    /*public static int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1, len = gas.length;
        for (int i =0; i <len; i++) {
            int t = checkForOne(i, gas, cost);
            System.out.println("t:"+t);
            if ( t>= 0) {
                //return i;
            }
        }
        return res;
    }*/

    private static int checkForOne(int start, int[] gas0, int[] cost0) {
        int[] cost = Arrays.copyOf(cost0,cost0.length);
        int[] gas = Arrays.copyOf(gas0,gas0.length);
        int currCost = 0,lastIndex = gas.length-1;
        int count = 0;
        for (int i = start; true; i++) {

            currCost = currCost +  gas[i] - cost[i];
            gas[i]=0;
            cost[i]=0;
            if(i==lastIndex){
                currCost = currCost+gas[0];
                gas[0]=0;
                i =-1;
            }else {
                currCost = currCost+gas[i+1];
                gas[i+1] =0;
            }
            ++count;
            System.out.println(start+"-----:"+currCost+"----:"+count);
            if(count>=gas.length){
                return start;
            }
            if(currCost<=0){
                return -1;
            }
        }
    }
}
