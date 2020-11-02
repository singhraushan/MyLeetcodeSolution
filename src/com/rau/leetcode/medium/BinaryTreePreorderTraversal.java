package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root,res);
        return res;
    }
    private static void  recursive(TreeNode root, List<Integer> res) {
        if (root==null) {
            return;
        }
	    res.add(root.val);
        recursive(root.left,res);
        recursive(root.right,res);
    }
}
