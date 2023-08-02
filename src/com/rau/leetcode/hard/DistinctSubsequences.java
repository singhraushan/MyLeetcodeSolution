package com.rau.leetcode.hard;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctSubsequences {
    public static void main(String[] args) {
        //System.out.println("numDistinct: "+numDistinct("rabbbit", "rabbit"));
        //System.out.println("numDistinct: "+numDistinct("babgbag", "bag"));
        long start = System.currentTimeMillis();
        System.out.println("start: " + start);
        //System.out.println("numDistinct: " + numDistinct("anacondastreetracecar", "contra"));
        System.out.println("numDistinct: " + numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }

    public static int numDistinct(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        numDistinct(s,new ArrayList<>(),map,0);
        if(map.containsKey(t))
            return map.get(t);
        return 0;
    }

    private static void numDistinct(String s, List<String> list, Map<String, Integer> map, int index) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                if (str != null)
                    sb.append(str);
            }
            if (map.containsKey(sb.toString())) {
                int count = map.get(sb.toString());
                map.put(sb.toString(), ++count);
            } else {
                map.put(sb.toString(), 1);
            }

        } else {
            if (list.size() > index)
                list.set(index, null);
            else
                list.add(null);

            numDistinct(s, list, map, index + 1);
            if (list.size() > index)
                list.set(index, String.valueOf(s.charAt(index)));
            else
                list.add(String.valueOf(s.charAt(index)));

            numDistinct(s, list, map, index + 1);
        }

    }
}
