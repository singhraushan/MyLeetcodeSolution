package com.rau.leetcode.medium;


import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = pathSum(root, 22);
        res.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        pathTravel(root, sum, new ArrayList<>(), lists);
        return lists;
    }

    private static void pathTravel(TreeNode root, int sum, List<Integer> currentList, List<List<Integer>> collectedLists) {
        if (root == null)
            return;
        currentList.add(root.val);
        if (isLeafNode(root)) {
            int currentSum = currentList.stream().mapToInt(Integer::intValue).sum();
            if (currentSum == sum)
                collectedLists.add(currentList);
        }
        if (root.left != null)
            pathTravel(root.left, sum, new ArrayList<>(currentList), collectedLists);

        if (root.right != null)
            pathTravel(root.right, sum, new ArrayList<>(currentList), collectedLists);

    }

    private static boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
