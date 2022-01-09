package com.rau.leetcode.medium;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left= new TreeNode(2);
        root.right= new TreeNode(7);

        root.left.left= new TreeNode(1);
        root.left.right= new TreeNode(3);

        insertIntoBST(root,5);
        System.out.println(root.val);
        System.out.println(root.left.val+","+root.right.val);
        System.out.println(root.left.left.val+","+root.left.right.val+","+root.right.left.val);
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
         getTreeNode(root, val);
         return root;
    }

    private static void getTreeNode(TreeNode root, int val) {
        if(root.val<val){// right side
            if(root.right==null){
                root.right= new TreeNode(val);
                return;
            }
            insertIntoBST(root.right,val);
        }else {//left side
            if(root.left==null){
                root.left= new TreeNode(val);
                return;
            }
            insertIntoBST(root.left,val);
        }
    }
}
