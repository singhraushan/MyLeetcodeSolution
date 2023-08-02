package com.rau.leetcode.test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TechgigCodeGladiators2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine().trim());
        while(count-->0){
            String[] leftRight = sc.nextLine().split(" ");
            int left = Integer.parseInt(leftRight[0].trim()), right = Integer.parseInt(leftRight[1].trim());
            System.out.println(maxDiff(left,right));
        }
    }
    private static int maxDiff(int left, int right) {
      int leftPrime=0,rightPrime=0;
      int i=left,j= right;
        while(i<=j){
            if(leftPrime==0 && isPrimeNumber(i)){
                leftPrime = i;
            }
            if(rightPrime==0 &&  isPrimeNumber(j)){
               rightPrime = j;
            }
            if(leftPrime!=0 && rightPrime!=0){
                break;
            }
            i++;
            j--;
        }
        if(leftPrime==0 && leftPrime==rightPrime)
            return -1;
        if(leftPrime==0 || rightPrime==0)
            return 0;
        return rightPrime-leftPrime;
    }
    private static void readCSV() {
        Scanner sc = new Scanner(System.in);
        TreeMap<String,String> map = new TreeMap<>();
        String line;
        boolean isHeader = true;
        String header = "";
        while ((line = sc.next()) != null) {
            if(isHeader){
                header = line;
                isHeader = false;
            }else if(line.trim().isEmpty()){
                isHeader = true;
            }else{
                int len = line.length(), commaIndex=0;
                for(int i=0;i<len;i++){
                    if(line.charAt(i)==','){
                        commaIndex = i;
                        break;
                    }
                }
                map.put(line.substring(0,commaIndex),line.substring(commaIndex+1,len));
            }
        }
        System.out.println(header);
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
    private static boolean isPrimeNumber(int number) {
        String str="";

        int half = number/2;
        for(int i=2;i<=half;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
