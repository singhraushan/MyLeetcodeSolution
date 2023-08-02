package com.rau.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates,0,target,new ArrayList<>(), new HashSet<>(), res);
        return res;
    }

    public static void backTrack(int[] candidates, int index, int target, List<Integer> curr, Set<String> unique, List<List<Integer>> res) {
        //int sum = curr.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
        if(/*sum>=target ||*/ index==candidates.length){
            int sum = curr.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
            if(sum==target){
                List<Integer> temp = curr.stream().filter(Objects::nonNull).sorted().collect(Collectors.toList());
                String hash = temp.toString();
                if(!unique.contains(hash)) {
                    res.add(temp);
                    unique.add(hash);
                }
            }

        }else {
            if(curr.size()>index){
                curr.set(index,null);
            }else {
                curr.add(null);

            }
            backTrack(candidates,index+1,target,curr, unique, res);

            if(candidates[index]<=target) {
                if (curr.size() > index) {
                    curr.set(index, candidates[index]);
                } else {
                    curr.add(candidates[index]);
                }
                backTrack(candidates, index + 1, target, curr, unique, res);
            }
        }
    }
}
