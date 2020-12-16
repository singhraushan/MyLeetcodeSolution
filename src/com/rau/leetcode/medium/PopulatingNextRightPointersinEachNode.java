package com.rau.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);
    }

    public static Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
             int size = q.size();
             while (size-->0){
                 Node curr = q.poll();
                 if(curr.left!=null){
                     q.add(curr.left);
                     curr.left.next = curr.right;
                 }
                 if(curr.right!=null){
                     q.add(curr.right);
                     if(size!=0){
                         curr.right.next = q.element().left;
                     }
                 }
             }
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}