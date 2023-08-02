package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

//a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree b = new BalancedBinaryTree();

        TreeNode root = new TreeNode(3);
        /*root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);

        System.out.println("isBalanced: "+b.isBalanced(root));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);;
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println("isBalanced: " + b.isBalanced(root));*/

        /*System.out.println("isBalanced: " + b.isBalanced(null));//true

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("isBalanced: " + b.isBalanced(root));// false*/


        root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println("isBalanced: " + b.isBalanced(root));// true
    }

    TreeSet<Integer> heights = new TreeSet<>();
    public boolean isBalanced(TreeNode root) {
        dfs(root, new ArrayList<>());
        System.out.println(heights);
        if(heights.size()==0)
            return true;
        if (heights.size()==1){
            return heights.first()<=2;
        }
        return !(heights.last() - heights.first() > 1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        if (isLeafNode(root))
            heights.add(list.size());
        if(root.left!=null)
        dfs(root.left,new ArrayList<>(list));
        if(root.right!=null)
        dfs(root.right,new ArrayList<>(list));
    }

    private boolean isLeafNode(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
