package com.rau.leetcode.easy;

import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(0);
        p.right = new TreeNode(4);
        p.right.left = new TreeNode(3);
        p.right.right = new TreeNode(5);

        root.left = p;

        TreeNode q = new TreeNode(8);
        q.left = new TreeNode(7);
        q.right = new TreeNode(9);

        root.right = q;

        TreeNode res = lowestCommonAncestor(root,p,q);
        System.out.println(res.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> pHierarchy = new LinkedHashSet<>();
        bfs(root, p, pHierarchy);

        Set<TreeNode> qHierarchy = new LinkedHashSet<>();
        bfs(root, q, qHierarchy);

        TreeNode[] arr = new TreeNode[pHierarchy.size()];
        pHierarchy.toArray(arr);

        int size = arr.length;
        while (size-->0){
            if(qHierarchy.contains(arr[size]))return arr[size];
        }
        return null;
    }
    public static void bfs(TreeNode root, TreeNode c, Set<TreeNode> hierarchy) {
        if(root==null) return;
        hierarchy.add(root);
        if(root.val==c.val)return;
        if(root.val<c.val) {//right side
            bfs(root.right, c, hierarchy);
        } else {//left side
            bfs(root.left, c, hierarchy);
        }
    }
}
