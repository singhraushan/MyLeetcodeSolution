package com.rau.leetcode.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PayPayTest {
    /*public static void main(String[] args) {
        //String s1 = "110011", s2 = "1010";
        String s1 = "11010", s2 = "00101001";
        //String s1 = "0000", s2 = "000";
        int l1 = s1.length();
        int l2 = s2.length();

        int rem = 0;
        String out = "";

        while (l1 > 0 || l2 > 0) {

            String val1 = "0";
            String val2 = "0";

            if (l1 > 0) {
                val1 = s1.charAt(l1 - 1) + "";
            }

            if (l2 > 0) {
                val2 = s2.charAt(l2 - 1) + "";
            }


            if (val1.equals("1") && val2.equals("1")) {
                if (rem == 1) {
                    out = "1" + out;
                } else {
                    out = "0" + out;
                }
                rem = 1;

            } else if (!val1.equals(val2)) {
                if (rem == 1) {
                    out = "0" + out;
                    rem = 1;
                } else {
                    out = "1" + out;
                    rem = 0;
                }
            } else {
                if (rem == 1){
                    out = "1" + out;
                } else {
                    out = "0" + out;
                }
                rem = 0;
            }

            l1--;
            l2--;
        }
        String stro =out.contains("1")?out:"0";
        System.out.println(out.contains("1")?out:"0");
    }*/
    public static void main(String[] args) throws IOException {
        /*InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line="110011,1010";

        while ((line = in.readLine()) != null) {
            String[] str = line.trim().split(";");
            System.out.println(returnMoney(str[0], str[1]));
        }*/
        //printPascal(10);
        //fib(7);
        decimalToBinary(999);
    }

    private static String returnMoney(String price, String ch) {
        double money = Double.parseDouble(ch.trim())-Double.parseDouble(price.trim());
        if(money<0)
            return "ERROR";
        if(money==0)
            return "ZERO";
        Map<Double,String> m =  getMap();
        String op = m.get(money);
        if(op!=null)
            return op;
        StringBuilder sb = new StringBuilder();
        for (double key : m.keySet()) {
            while (money >= key) {
                sb.append(m.get(key));
                sb.append(",");
                money -= key;
            }
        }
      return sb.toString().substring(0,sb.toString().length()-1);
    }
    private static Map<Double,String> getMap() {
        Map<Double,String> m = new LinkedHashMap<>();
        m.put(100.00,"ONE HUNDRED");
        m.put(50.00, "FIFTY");
        m.put(20.00, "TWENTY");
        m.put(10.00, "TEN");
        m.put(5.00, "FIVE");
        m.put(2.00, "TWO");
        m.put(1.00, "ONE");
        m.put(.50, "HALF DOLLAR");
        m.put(.25, "QUARTER");
        m.put(.10, "DIME");
        m.put(.05, "NICKEL");
        m.put(.01, "PENNY");
        return m;
    }
    public static void printPascal(int n){
        for (int line=0;line<n;line++){
            for (int space=0;space<=n-line;space++){
                System.out.print(" ");
            }
            for (int col=0;col<=line;col++){
                System.out.print(cal(line,col)+" ");
            }
            System.out.println();//line change
        }
    }
    private static int cal(int line,int col){
        int res=1;
        if(col>line-col)
            col = line-col;

        for (int i=0;i<col;i++){
                res = res *(line-i);
                res = res /(i+1);
        }
        return res;
    }

    public static void fib(int n){
        int n1=0,n2=1,n3;
        for(int i=0;i<n;i++){
            System.out.print(n1+" ");
            n3= n1+n2;
            n1 = n2;
            n2 = n3;
        }
    }

    public static void decimalToBinary(int input){
        List<Integer> binaries = new ArrayList<>();
        while(input>0){
            binaries.add(input%2);
            input/=2;
        }
        //System.out.println(binaries.stream().mapToInt(Integer::intValue).);
    }
}
