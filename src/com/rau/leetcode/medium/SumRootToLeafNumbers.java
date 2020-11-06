package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);*/
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println("result:"+sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer> listSum = new ArrayList<>();
        dfs(root,new ArrayList<>(),listSum);
        return listSum.stream().mapToInt(Integer::intValue).sum();
    }
    private static void dfs(TreeNode root, List<Integer> list , List<Integer> listSum) {

        list.add(root.val);
        if(isLeafNode(root)){
            int sum=0;
            for(int v: list){
                sum = sum*10+ v;
            }
            listSum.add(sum);
        }
        if(root.left!=null)
            dfs(root.left,new ArrayList<>(list),listSum);
        if(root.right!=null)
            dfs(root.right,new ArrayList<>(list),listSum);
    }
    private static boolean isLeafNode(TreeNode node) {
        return node.left==null && node.right==null;
    }
}
