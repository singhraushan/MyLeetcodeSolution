package com.rau.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode();
        head.next.val = 2;
        head.next.next = new ListNode();
        head.next.next.val = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.val = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;

        ListNode curr = head;
        reorderList(head);
        while(curr!=null){
            System.out.println(curr.val+"->");
            curr = curr.next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        List<ListNode> list = new ArrayList<>();

        while (slow != null) {
            if (fast == null) {
                list.add(slow);
            } else {
                if (fast.next == null || fast.next.next == null) {
                    fast = null;
                } else {
                    fast = fast.next.next;
                }
            }
            slow = slow.next;
        }
        ListNode curr = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode temp = curr.next;
            curr.next = list.get(i);
            curr.next.next = temp;
            curr = temp;
        }
        curr.next = null;
    }
}
