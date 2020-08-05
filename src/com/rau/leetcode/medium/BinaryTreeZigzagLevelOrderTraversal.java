package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean fromLeft = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            if (list.size() > 0) {
                if (fromLeft) {
                        fromLeft = false;
                } else {
                    List<Integer> list2 = new ArrayList<>();
                    for (int i = list.size()-1; i >= 0; i--) {
                        list2.add(list.get(i));
                    }
                    list = list2;
                    fromLeft = true;
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
