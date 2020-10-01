package com.rau.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("isSymmetric: " + isSymmetric(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = null;
        root.left.right = new TreeNode(3);

        root.right.left = null;
        root.right.right = new TreeNode(3);

        System.out.println("isSymmetric: " + isSymmetric(root));


    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {

            int size = q.size();
            int[] level = new int[2*size];
            int k=0;

            while (size-- > 0) {
                TreeNode tr = q.poll();
                if (tr.left != null) {
                    q.add(tr.left);
                    level[k++] =tr.left.val;
                } else level[k++] = -1;
                if (tr.right != null) {
                    q.add(tr.right);
                    level[k++] = tr.right.val;
                } else level[k++] = -1;
            }

            int lLen1 = level.length-1, half = level.length/2;
            for(int i=0;i<half;i++){
                if(!(level[i]==level[lLen1-i])){
                    return false;
                }
            }

        }
        return true;
    }
}
