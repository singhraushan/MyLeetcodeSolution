package com.rau.leetcode.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArunPayPayTest {
    public static void main(String[] args) {
        /*Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("Tot");
        set.add("log");
        set.add("cog");
        System.out.println(solution("hit", "cog", set));//6

        set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(solution("a", "c", set));//2*/
        int[] a = new int[]{25,2,3,57,38,41};
        for(int v: solution(a)){
            System.out.print(v+",");
        }
        System.out.println("--------------");

    }

    static int[] solution(int [] a){
        Map<Integer,Integer> digitCountMap = new HashMap<>();
        for( int v: a){
            digitMap(v,digitCountMap);
        }
        //sort based on value
        TreeMap<Integer,List<Integer>> countDigitMap = new TreeMap<>();
        for(Map.Entry<Integer,Integer> set: digitCountMap.entrySet()){
            List<Integer> list;
            if(countDigitMap.containsKey(set.getValue())){
                    list = countDigitMap.get(set.getValue());
            }else {
                list= new ArrayList<>();
            }
            list.add(set.getKey());
            countDigitMap.put(set.getValue(),list);
        }
        List<Integer> list = countDigitMap.lastEntry().getValue();
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
    private static void digitMap(int v,Map<Integer,Integer> digitCountMap){
        while (v!=0){
            int remainder = v%10;
            digitCountMap.put(remainder,digitCountMap.getOrDefault(remainder,0)+1);
            v /=10;
        }
    }

    static int solution(String beginWord, String endWord, String[] wordList){
        Set<String> set = new HashSet<String>();
        for(String str: wordList)set.add(str);
        if(!set.contains(endWord)) return 0;
       return solutionWithSet(beginWord, endWord, set);
    }
    static int solutionWithSet(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

}
