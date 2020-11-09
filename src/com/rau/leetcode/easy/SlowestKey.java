package com.rau.leetcode.easy;

public class SlowestKey {
    public static void main(String[] args) {
        System.out.println("res:" + slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));//c
        System.out.println("res:" + slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));//a
        System.out.println("res:" + slowestKey(new int[]{1,2}, "ab"));//b
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int len = releaseTimes.length, max = releaseTimes[0];
        char res = keysPressed.charAt(0);
        for (int i = 1; i < len; i++) {
            int v = releaseTimes[i] - releaseTimes[i - 1];
            if (v > max) {
                max = v;
                res = keysPressed.charAt(i);
            }else if (v == max ) {
                if(keysPressed.charAt(i) > res){
                    res = keysPressed.charAt(i);
                }
            }
        }
        return res;
    }
}
