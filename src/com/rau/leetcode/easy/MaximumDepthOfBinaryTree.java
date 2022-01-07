package com.rau.leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("maxDepth: " + maxDepth(root));//3

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = null;
        root.left.right = new TreeNode(3);

        root.right.left = null;
        root.right.right = new TreeNode(3);

        System.out.println("maxDepth: " + maxDepth(root));//3

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(25);

        System.out.println("maxDepth: " + maxDepth(root));//4
    }
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        AtomicInteger max= new AtomicInteger(1);
        dfs(root,new AtomicInteger(1),max);
        return max.get();
    }

    private static void dfs(TreeNode root, AtomicInteger atomicInteger,AtomicInteger max) {
        if(root.left==null && root.right==null){
            max.set(Math.max(max.get(),atomicInteger.get()));
        }else {
            if(root.left!=null)
                dfs(root.left,new AtomicInteger(atomicInteger.get()+1), max);
            if(root.right!=null)
                dfs(root.right,new AtomicInteger(atomicInteger.get()+1), max);
        }
    }
}
