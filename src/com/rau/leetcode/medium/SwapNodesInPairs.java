package com.rau.leetcode.medium;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = swapPairs(head);
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = null, curr = head, next = head.next;
        int count = 1;
        while (curr != null) {

            if (prev == null && count == 1) {
                if (next != null) {
                    curr.next = next.next;
                    next.next = curr;

                    prev = next;
                    next = curr.next;
                    head = prev;
                }
            } else if (count % 2 != 0) {
                prev.next = next;
                if (next != null) {
                    curr.next = next.next;
                    next.next = curr;
                    prev = next;
                } else {
                    prev.next = curr;
                    curr = null;
                }

                if (next != null)
                    next = next.next;
            } else {
                prev = curr;
                curr = curr.next;
                if (curr != null && curr.next != null)
                    next = curr.next;
                else next = null;
            }
            count++;
        }
        return head;
    }
}


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
