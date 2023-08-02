package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        System.out.println("res: " + res);
    }

    public static List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        List<List<Integer>> collected = new ArrayList<>();
        permute(arr, 0, new ArrayList<>(), collected,k);
        return collected;
    }

    private static void permute(int[] arr, int index, List<Integer> current, List<List<Integer>> collected,int k) {
        if (arr.length == index) {
            List<Integer> temp = current.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if(temp.size()==k){
                collected.add(temp);
            }
        } else {
            if (current.size() > index)
                current.set(index, null);
            else
                current.add(null);
            permute(arr, index+1, current, collected,k);

            if (current.size() > index)
                current.set(index, arr[index]);
            else
                current.add(arr[index]);
            permute(arr, index+1, current, collected,k);
        }
    }
}
