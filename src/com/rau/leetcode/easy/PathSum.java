package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root,22));
    }
    private static boolean hasSum = false;
    public static boolean hasPathSum(TreeNode root, int sum) {
        fullPath(root,sum, new ArrayList<>());
        return hasSum;
    }

    public static void fullPath(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return ;

        list.add(root.val);
        if (isLeafNode(root)) {
            int totalSum = list.stream().mapToInt(i -> i).sum();
            if(sum==totalSum) {
                hasSum = true;
                return ;
            }
        }
        fullPath(root.left,sum, new ArrayList<>(list));
        fullPath(root.right,sum, new ArrayList<>(list));
    }

    public static boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
