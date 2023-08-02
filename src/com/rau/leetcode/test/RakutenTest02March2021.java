package com.rau.leetcode.test;

import java.util.*;

public class RakutenTest02March2021 {

    public static void main(String[] args) {
        /*int[] arr = new int[]{1,4,-1,3,2};
        System.out.println(solution1(arr));*/
        //System.out.println(new RakutenTest02March2021().solution(new int[]{5,4,3,2,6} ));
        System.out.println(new RakutenTest02March2021().solution(new int[]{3, 7, 4, 5} ));
        //System.out.println(solution2("codility"));
        //System.out.println(solution3(3,"1A 1B,2C 2C", "1B"));
    }

    public static int solution1(int[] A) {
        int res = 0, i = 0, len = A.length;
        Set<Integer> seen = new HashSet<>();

        for (int k = 0; k < len; k++) {

            int v = A[i];
            if (v == -1) {
                return ++res;
            } else if (v < len && v > -1) {
                if(seen.contains(v)){
                    return res;
                }
                seen.add(v);
                i = v;
                ++res;
            }
        }
        return res;
    }
    public static String solution2(String S) {
        TreeSet<String> ordered = new TreeSet<>();
        int len = S.length();
        for(int i=0;i<len;i++){
            ordered.add(S.substring(0,i)+S.substring(i+1,len));
        }
        return ordered.first();
    }

    public static String solution3(int N, String S, String T) {

        int [][]map = buildMap(N, S);

        Map<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                int value = map[i][j];
                if (value > 0) {
                    if (m.get(value) == null) {
                        m.put(value, 1);
                    } else {
                        m.put(value, m.get(value)+1);
                    }
                }
            }
        }

        Set<Integer> bombed = new HashSet<>();
        String []t_split = T.split(" ");
        for (int i=0; i<t_split.length; i++) {

            String value = t_split[i].trim();
            int row_1 = Integer.parseInt(value.substring(0, value.length()-1))-1;
            int col_1 = value.charAt(value.length()-1) - 'A';
            int v = map[row_1][col_1];
            if (v > 0) {
                bombed.add(v);
                m.put(v, m.get(v)-1);
            }
        }

        int desCounter = 0;
        int noDesCounter = 0;
        for (Map.Entry<Integer, Integer> mv : m.entrySet()) {

            int value = mv.getValue();
            if (bombed.contains(mv.getKey())) {
                if (value == 0) {
                    desCounter++;
                } else {
                    noDesCounter++;
                }
            }
        }
        return desCounter + "," +noDesCounter;
    }

    private static int[][] buildMap(int N, String S) {
        int [][]map = new int[N][N];

        String []s_split = S.split(",");
        int ship_count = 0;
        for (int i=0; i< s_split.length; i++) {
            ship_count++;
            String value = s_split[i];
            String []v_split = value.trim().split(" ");

            int row_1 = Integer.parseInt(v_split[0].substring(0, v_split[0].length()-1))-1;
            int col_1 = v_split[0].charAt(v_split[0].length()-1) - 'A';

            int row_2 = Integer.parseInt(v_split[1].substring(0, v_split[1].length()-1))-1;
            int col_2 = v_split[1].charAt(v_split[1].length()-1) - 'A';

            if (row_1 != row_2 && col_1 != col_2) {
                for (int j=row_1; j<=row_2; j++) {
                    for (int k=col_1; k<=col_2; k++) {
                        map[j][k] = ship_count;
                    }
                }
            } else if (row_1 != row_2) {
                for (int j=row_1; j<=row_2; j++) {
                    map[j][col_1] = ship_count;
                }
            } else {
                for (int j=col_1; j<=col_2; j++) {
                    map[row_1][j] = ship_count;
                }
            }

        }
        return map;
    }

    public int solution(int[] A) {
        if (A.length < 3) {
            return A[0] != A[1] ? 0 : 1;
        }
        int count = 0;
        for (int i = 0; i < A.length - 2 ; i += 2) {
            int a = A[i];
            int b = A[i+1];
            int c = A[i + 2];
            if (!(a - b > 0 && b - c < 0) && !(a - b < 0 && b - c > 0)) {
                count ++;
            }
        }
        return count;
    }

}
