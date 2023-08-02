package com.rau.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class ArtificialAIForNUSTest {
    public static void main(String[] args) {
        System.out.println(arrangements(2));
        System.out.println(arrangements(3));
        System.out.println(arrangements(4));
    }
    private static int count=0;
    static int arrangements(int n) {
        if (n == 0) return 0;
        count=0;
        recursive(n, 1, new int[n + 1]);
        return count;
    }
    private  static void recursive(int n, int pos, int[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                recursive(n, pos + 1, used);
                used[i] = 0;
            }
        }
    }

    private static int res=0;
    private static int isPresent(Node root, int val) {
        res=0;
        traverse(root,val);
        return res;
    }

    private static void traverse(Node root, int val) {
        if(root==null)
            return;
        if(root.data==val){
            res =1;
            return;
        }
        if(val<root.data)
            traverse(root.left, val);
        if(val>=root.data)
            traverse(root.right, val);
    }
    class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }
}
