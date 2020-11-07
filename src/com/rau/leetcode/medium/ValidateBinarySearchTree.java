package com.rau.leetcode.medium;


import java.util.LinkedList;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);*/
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(20);

        System.out.println(isValidBST(root));
    }

    private static Stack<Integer> stack = new Stack<>();
    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        inOrder(root);
        int bigger = stack.pop();
        while (!stack.isEmpty()){
            int smaller = stack.pop();
            if(bigger<=smaller) {
                return false;
            }
            bigger =smaller;
        }
        return true;
    }
    private static void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            stack.push(root.val);
            inOrder(root.right);
        }
    }
}
