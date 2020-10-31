package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(root));
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        return bfs(root);
    }
    private static List<List<Integer>> bfs(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            res.add(list);
        }
        int s = res.size();
        for(int i=0; i<s/2; i++){
            swap(res,(s-1-i),i);
        }
        return res;
    }

    private static void swap(List<List<Integer>> res, int i, int j) {
        List<Integer> temp = res.get(i);
        res.set(i,res.get(j));
        res.set(j,temp);
    }

}

