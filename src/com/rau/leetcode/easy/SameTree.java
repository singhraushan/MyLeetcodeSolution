package com.rau.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        System.out.println("isSameTree: " + isSameTree(t1, t2));


        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println("isSameTree: " + isSameTree(t1, t2));

        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(1);
        t2 = new TreeNode(1);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println("isSameTree: " + isSameTree(t1, t2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int qSize = q1.size();

            if(qSize!=q2.size())
                return false;

            while(qSize-->0){
                TreeNode firstTree = q1.poll(), secondTree = q2.poll();
                if (firstTree.val != secondTree.val)
                    return false;

                if ( !(firstTree.left == null && secondTree.left == null) && (firstTree.left == null || secondTree.left == null)) {
                    return false;
                }
                if(firstTree.left!=null){
                    q1.add(firstTree.left);
                }

                if(secondTree.left!=null){
                    q2.add(secondTree.left);
                }

                if ( !(firstTree.right == null && secondTree.right == null) && (firstTree.right == null || secondTree.right == null)) {
                    return false;
                }
                if(firstTree.right!=null){
                    q1.add(firstTree.right);
                }

                if(secondTree.right!=null){
                    q2.add(secondTree.right);
                }

            }
        }
        return q1.size()==q2.size();
    }
}
