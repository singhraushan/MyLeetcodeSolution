package com.rau.leetcode.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JPMorganSGAprilTest {
    public static void main(String[] args) throws Exception{
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line,activeUser="";
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> otherUsers = new HashMap<>();
        boolean isFirstLine = true;
        while ((line = in.readLine()) != null) {
            if(isFirstLine){
                String[] str = line.trim().split(":");
                activeUser = str[0];
                String[] vals =  str[1].trim().split(",");
                int i=0;
                for(String v : vals){
                    map.put(v,i++);
                }
                isFirstLine= false;
            }else {
                String[] str = line.trim().split(":");
                String[] vals =  str[1].trim().split(",");
                List<Integer> list = new ArrayList<>();
                for(String v : vals){
                    list.add(map.get(v));
                }
                otherUsers.put(str[0],list);
            }

        }
        TreeMap<Integer, Set<String>> res =  getInversion(otherUsers);
        for(Integer i: res.keySet()){
            System.out.print(res.get(i)+",");
        }
        System.out.println(res);
    }
    /*
    *   rabbit:carrot,cabbage,fish,meat
        turtle:cabbage,carrot,fish,meat
        cat:fish,meat,carrot,cabbage
        dog:meat,fish,cabbage,carrot
* */
    private static TreeMap<Integer, Set<String>> getInversion(Map<String, List<Integer>> otherUsers){
        TreeMap<Integer, Set<String>> sortedCount = new TreeMap<>();
        for(String key : otherUsers.keySet()){
            List<Integer> values = otherUsers.get(key);
            int count=0;
            for(int i=0;i<values.size();i++){
                for(int j=i+1;j<values.size();j++){
                    if(values.get(i)<values.get(j)){
                        ++count;
                    }
                }
            }
            if(sortedCount.get(count)!=null){
                Set<String> set = sortedCount.get(count);
                set.add(key);
                sortedCount.put(count,set);
            }else {
                Set<String> set = new TreeSet<>();
                set.add(key);
                sortedCount.put(count,set);
            }
        }
        return sortedCount;
    }
}
