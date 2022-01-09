package com.rau.leetcode.easy;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left= new TreeNode(2);
        root.right= new TreeNode(7);

        root.left.left= new TreeNode(1);
        root.left.right= new TreeNode(3);

        TreeNode res = new SearchInABinarySearchTree().searchBST(root,2);
        System.out.println(res.val);
        System.out.println(res.left.val+","+res.right.val);
    }
    TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
      search(root,val);
      return res;
    }

    private void search(TreeNode root, int val){
        if(root==null) return;
        if (root.val==val) {
            res = root;
        }else if (root.val<val){//right side
            search(root.right,val);
        }else {//left side
            search(root.left,val);
        }
    }
}
