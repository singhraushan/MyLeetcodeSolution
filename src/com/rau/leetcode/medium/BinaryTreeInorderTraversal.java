package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal(root);
        System.out.println(list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
    private static List<Integer> list = new ArrayList<>();
    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
