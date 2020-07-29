package com.rau.leetcode.easy;

import java.util.*;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //ListNode node2 = new ListNode(2);
        //head.next = node2;
        //node2.next = head;

        System.out.println("hasCycle "+hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> seen = new HashSet<>();
        while (curr != null) {

            if (seen.contains(curr)) {
                return true;
            }else{
                seen.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
