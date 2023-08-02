package com.rau.leetcode.test;

import java.util.*;

public class TravelokaTest {
    public static int waysToCoinExchange(int[] coins,int target){
        int[] ways = new int[target+1];
        ways[0]=coins[0];

        for(int coin : coins) {

            for (int j=0;j<ways.length;j++){
                if (coin<=j){
                    ways[j] += ways[j-coin];
                }
            }
        }
        return ways[target];
    }

    public static void main(String[] args) {

        System.out.println("waysToCoinExchange:"+waysToCoinExchange(new int[] { 1, 5, 10 },8));
        List<Integer> predators = new ArrayList<>();
        /*predators.add(-1);
        predators.add(8);
        predators.add(6);
        predators.add(0);
        predators.add(7);
        predators.add(3);
        predators.add(8);
        predators.add(9);
        predators.add(-1);
        predators.add(6);*/
        predators.add(4);
        predators.add(-1);
        predators.add(0);
        predators.add(3);
        predators.add(-1);

        //System.out.println("res: "+minimumGroups(predators));

        List<List<Integer>> keyTimes = new ArrayList<>();
        List<Integer> keyTime = new ArrayList<>();
        keyTime.add(0);
        keyTime.add(1);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(0);
        keyTime.add(3);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(0);
        keyTime.add(3);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(4);
        keyTime.add(5);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(5);
        keyTime.add(6);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(4);
        keyTime.add(10);
        keyTimes.add(keyTime);
        char ch = slowestKey(keyTimes);
        System.out.println("ch:"+ch);

        System.out.println("------------");

        keyTimes = new ArrayList<>();
        keyTime = new ArrayList<>();
        keyTime.add(0);
        keyTime.add(2);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(1);
        keyTime.add(3);
        keyTimes.add(keyTime);
        keyTime = new ArrayList<>();
        keyTime.add(0);
        keyTime.add(7);
        keyTimes.add(keyTime);
        System.out.println("ch2:"+slowestKey(keyTimes));
    }
    public static int minimumGroups(List<Integer> predators) {
       Map<Integer,Integer> seen = new HashMap<>();
        for(int i=0;i<predators.size();i++){
            int v= predators.get(i);
            if(v==-1){
                seen.put(i,0);
            }else if(seen.containsKey(v)){
                seen.put(i,1+seen.get(v));
            }else {
                int j=v,count =1;
                for (;j<predators.size() && j>-1;){
                    v = predators.get(j);
                    if(v==-1){
                        seen.put(i,count);
                        break;
                    }else if(seen.containsKey(v)){
                        seen.put(i,count+seen.get(v)+1);
                        break;
                    }else if(count>predators.size()){
                        break;
                    }
                    j = v;
                    count++;
                }
            }
        }
        return new HashSet(seen.values()).size();
    }

    public static char slowestKey(List<List<Integer>> keyTimes) {
        int len = keyTimes.size(), maxTime = keyTimes.get(0).get(1);
        int key = keyTimes.get(0).get(0);

        for (int i = 1; i < len; i++) {
            int v = keyTimes.get(i).get(1) - keyTimes.get(i-1).get(1);
            if (v > maxTime) {
                maxTime = v;
                key = keyTimes.get(i).get(0);
            }else if (v == maxTime ) {
                if(keyTimes.get(i).get(0) > key){
                    key = keyTimes.get(i).get(0);
                }
            }
        }
        return getChar(key);
    }
    private static char getChar(int v){
        return map.get(v);
    }
    private static Map<Integer,Character> map = new HashMap<>();
    static {
        map.put(0,'a');
        map.put(1,'b');
        map.put(2,'c');
        map.put(3,'d');
        map.put(4,'e');
        map.put(5,'f');
        map.put(6,'g');
        map.put(7,'h');
        map.put(8,'i');
        map.put(9,'j');
        map.put(10,'k');
        map.put(11,'l');
        map.put(12,'m');
        map.put(13,'n');
        map.put(14,'o');
        map.put(15,'p');
        map.put(16,'q');
        map.put(17,'r');
        map.put(18,'s');
        map.put(19,'t');
        map.put(20,'u');
        map.put(21,'v');
        map.put(22,'w');
        map.put(23,'x');
        map.put(24,'y');
        map.put(25,'z');

    }
}
