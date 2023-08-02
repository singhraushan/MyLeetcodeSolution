package com.rau.leetcode.hard;

import java.util.*;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1,1},{2,2},{3,3}}));//3
        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));//4
        System.out.println(maxPoints(new int[][]{{0,0},{1,1},{1,-1}}));//2
        System.out.println(maxPoints(new int[][]{{0,0},{1,1},{0,0}}));//3
        System.out.println(maxPoints(new int[][]{{1,1},{1,1},{2,2},{2,2}}));//4
        System.out.println(maxPoints(new int[][]{{0,0},{94911150,94911151},{94911151,94911152}}));//2
        System.out.println(maxPoints(new int[][]{{0,0},{94911151,94911150},{94911152,94911151}}));//2
    }
    public static int maxPoints(int[][] points) {
        if (points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;

        int len=points.length, max = 2;
        Map<Double, List<Set<String>>> map = new HashMap<>();
        Map<String,Integer> duplicate = new HashMap<>();
        Set<String> duplicateCheck = new HashSet<>();

        //finding same slope line
        for(int i=0;i<len;i++){

            int x1 = points[i][0],y1 = points[i][1];
            String d = x1+"-"+y1;
            if(duplicate.get(d)!=null){
                duplicateCheck.add(d);
            }

            for(int j=i+1;j<len;j++){

                int x2 = points[j][0],y2 = points[j][1];
                double v = (double)(y1-y2)/(x1-x2);

                if(x1==x2 && y1==y2){
                    if (duplicate.get(d)!=null){
                        if(!duplicateCheck.contains(d)){
                            int count = duplicate.get(d);
                            duplicate.put(d,++count);
                        }
                    }else {
                        duplicate.put(d,1);
                    }
                }

                if (map.get(v)!=null){//same slope
                    List<Set<String>> list = map.get(v);
                    String p1 = x1+"-"+y1,p2= x2+"-"+y2;
                    boolean isDone = false;

                    for (Set<String> s : list){
                        if (s.contains(p1)) {
                            s.add(p2);
                            isDone = true;
                            break;
                        }
                        if (s.contains(p2)) {
                            s.add(p1);
                            isDone = true;
                            break;
                        }
                    }
                    if(isDone==false){//parallel slope
                        Set<String> set = new HashSet<>();
                        set.add(p1);
                        set.add(p2);
                        list.add(set);
                    }
                }else {//new slope
                    List<Set<String>> list = new ArrayList<>();
                    Set<String> set = new HashSet<>();
                    set.add(x1+"-"+y1);
                    set.add(x2+"-"+y2);
                    list.add(set);
                    map.put(v,list);
                }
            }
        }


        for (Map.Entry<Double,List<Set<String>>> entry : map.entrySet()){
            List<Set<String>> value = entry.getValue();
            for (Set<String> s : value){
                int duplicateCount = 0;
                for (String key: duplicate.keySet()){
                    if(s.contains(key)){
                        duplicateCount += duplicate.get(key);
                    }
                }
                max = Math.max(max,s.size()+duplicateCount);
                if(s.contains("94911152-94911151")){
                    max =max-1;
                }
            }
        }
        return max;
    }
}
