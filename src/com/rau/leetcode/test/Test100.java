package com.rau.leetcode.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Test100 {
    public static void main(String[] args) throws Exception{
        Map<String,Double> res = read("C:/Users/DELL/Desktop/TestData.txt");
    }
    public static Map<String,Double> read(String file) throws Exception{
       BufferedReader br = new BufferedReader(new FileReader(file));
       String str=null,distributerName=null;
        int personCount =0;
       boolean isFirst = true,isDistributer = true,isMoney = false;

        Map<String,Double> res = new HashMap<>();

        while((str= br.readLine())!=null){
            if(isFirst){
                personCount = Integer.parseInt(str);
                isFirst = false;
            }else if(personCount!=0){
                    //read person name
                res.put(str,0.0);
                personCount--;
            }else {
                if(isDistributer){
                    distributerName = str;
                    isDistributer = false;
                    isMoney= true;
                }//else if(isDistributer)
                    //list.stream().filter(e->e.getAge()>20).collect(Collectors.);

            }
        }
        //Map<String,Double> res = new HashMap<>();

        return res;
    }

}
