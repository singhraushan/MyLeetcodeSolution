package com.rau.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {

        case2Test();
    }
    public static void case2Test() {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);

        root.left.left = new TreeNode(1);

        TreeNode res = invertTree(root);
        System.out.println(res.val);
        System.out.println(res.left+","+res.right.val);
        System.out.println(res.right.left+","+res.right.right);
    }
    public static void case1Test() {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode res = invertTree(root);
        System.out.println(res.val);
        System.out.println(res.left.val+","+res.right.val);
        System.out.println(res.left.left.val+","+res.left.right.val+","+res.right.left.val+","+res.right.right.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        bfs(root);
        return root;
    }
    private static void bfs(TreeNode root) {
        if(root==null)return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<TreeNode> prevList = new ArrayList<>();
        prevList.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> currList = new ArrayList<>();
            while (size-->0){
                TreeNode node = q.poll();
                currList.add(node);
                if(node!=null) {
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(currList.size()>1)
                prevList = exchange(currList,prevList);
        }
    }
    private static List<TreeNode> exchange(List<TreeNode> levelList,List<TreeNode> parentList) {
        int j=0;
        List<TreeNode> reverseList = new ArrayList<>();
        for (int i=levelList.size()-1;i>=0;){
            TreeNode p =null;
            while (j<parentList.size()){
                if(j<parentList.size() && parentList.get(j)!=null){
                    p =parentList.get(j++);
                    break;
                }
                j++;
            }

            if(p!=null){
                p.left=levelList.get(i);
                reverseList.add(levelList.get(i));
                i--;
                p.right=levelList.get(i);
                reverseList.add(levelList.get(i));
                i--;
            }else {i=-2;}
        }
        return reverseList;
    }
}
