package com.rau.leetcode.medium;

public class Pow {
    public static void main(String[] args) {
        //System.out.println("myPow: " + myPow(2.10000, 3));
        System.out.println("myPow: " + myPow(0.00001, 2147483647));
    }

    //this one also correct.
    /*public static double myPow(double x, int n) {
        double result = 1.0;
        if(n==0)
            return 1;
        else if (n<0){
            n = Math.abs(n);
            for (int i = 1; i <= n; i++) {
                result = result * 1/x;
            }
        }else {
            for (int i = 1; i <= n; i++) {
                result = result * x;
            }
        }
        return result;
    }*/

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return recursivePow(1 / x, Math.abs(n));
        else
            return recursivePow(x, Math.abs(n));
    }

    public static double recursivePow(double x, int n) {
        if (n == 1)
            return x;
        if (n == 2)
            return x * x;
        int mypart = n / 2;
        return myPow(x, mypart) * myPow(x, n - mypart);
    }
}
