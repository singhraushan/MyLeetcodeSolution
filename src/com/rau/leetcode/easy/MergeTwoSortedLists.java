package com.rau.leetcode.easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1,l2);
        while (result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;
        ListNode head = null, curr = null;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                if (head == null) {
                    head = curr = curr1;
                } else {
                    curr.next = curr1;
                    curr = curr1;
                }
                curr1 = curr1.next;
            } else {
                if (head == null) {
                    head = curr = curr2;
                } else {
                    curr.next = curr2;
                    curr = curr2;
                }
                curr2 = curr2.next;
            }
        }

        while (curr1 != null) {
            if (head == null) {
                head = curr = curr1;
            } else {
                curr.next = curr1;
                curr = curr1;
            }
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            if (head == null) {
                head = curr = curr2;
            } else {
                curr.next = curr2;
                curr = curr2;
            }
            curr2 = curr2.next;
        }

        return head;
    }
}
