package com.rau.leetcode.easy;

import java.util.TreeMap;

public class MinStack {

    private int pointer;
    private int[] arr;
    TreeMap<Integer,Integer> map;

    public MinStack() {
        pointer = -1;
        arr = new int[20];
        map = new TreeMap<Integer,Integer>();
    }

    public void push(int x) {
        if(pointer+1==arr.length) {
            int len = arr.length;
            int[] temp = new int[2*len];
            for(int i=0;i<len;i++){
                temp[i]=arr[i];
            }
            arr = temp;
        }
        arr[++pointer] = x;
        map.put(x,map.getOrDefault(x,0)+1);
    }

    public void pop() {
        if(map.getOrDefault(arr[pointer],0) <=1 ){
            map.remove(arr[pointer]);
        }else
            map.put(arr[pointer],map.getOrDefault(arr[pointer],0)-1);
        --pointer;
    }

    public int top() {
        return arr[pointer];
    }

    public int getMin() {
        return map.firstKey();
    }

}
