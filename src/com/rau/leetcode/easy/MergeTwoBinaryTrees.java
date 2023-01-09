package com.rau.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {

    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return null;
        TreeNode root=null;
        Queue<TreeNode> q= new LinkedList<>(),q1= new LinkedList<>(),q2= new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() || !q2.isEmpty()){
            int q1Size = q1.size(), q2Size = q2.size();
            int max= Math.max(q1Size,q2Size);
            while (max>0){
                int sum=0;
                if(q1Size>0) {
                    sum += q1.element()!=null?q1.element().val:0;
                    --q1Size;
                }

                if(q2Size>0) {
                    sum += q2.element()!=null?q2.element().val:0;
                    --q2Size;
                }
                if(root==null){
                    root= new TreeNode(sum);
                    q.add(root);
                }else {

                }
            }
        }

        return root;
    }
}
