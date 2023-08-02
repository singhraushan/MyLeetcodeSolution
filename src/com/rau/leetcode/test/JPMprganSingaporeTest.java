package com.rau.leetcode.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JPMprganSingaporeTest {
    public static void main(String[] args) throws Exception{
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        List<List<Integer>> lists =new  ArrayList<>();
        List<Integer> MList =new  ArrayList<>();
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
            String[] values = line.trim().split(",");
            List<Integer> list =new  ArrayList<>();
            int max=0;
            for(String strV: values){
                int v = Integer.parseInt(strV.trim());
                max = Math.max(max,v);
                list.add(v);
            }
            MList.add(max);
            lists.add(list);
        }

        int len = lists.size();
        for(int i=0;i<len;i++){
            List<Integer> curList = lists.get(i);
            double d = 100.0/MList.get(i);
            String res = "";
            for(int v : curList){
                res = res+","+Math.round(v*d);
            }
            System.out.println(res.substring(1));
        }

    }
}
