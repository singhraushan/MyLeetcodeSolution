package com.rau.leetcode.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumIVInputIsABST {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        p.left = new TreeNode(3);
        p.left.left = new TreeNode(2);
        p.left.right = new TreeNode(4);

        p.right = new TreeNode(6);

        p.right.right = new TreeNode(7);

        System.out.println("res:"+new TwoSumIVInputIsABST().findTarget(p,9));

    }
    boolean isFound=false;
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        bfs(root,  k);
        return isFound;
    }

    public void bfs(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Set<Integer> seen = new HashSet<>();
        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                TreeNode node = q.poll();
                if(seen.contains(k-node.val)) {
                    isFound=true;
                    return;
                }
                seen.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
    }
}
