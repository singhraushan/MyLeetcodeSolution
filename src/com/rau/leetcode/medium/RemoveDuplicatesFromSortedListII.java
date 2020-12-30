package com.rau.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        //1->2->3->3->4->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        //print(deleteDuplicates(head));
        System.out.println("-------------");
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        //print(deleteDuplicates(head));
        head = new ListNode(1);
        head.next = new ListNode(1);
        print(deleteDuplicates(head));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode curr = head,prev = null;
        Set<Integer> duplicateSeen = new HashSet<>();

        while(curr!=null) {
            ListNode next = curr.next;
            if((next!=null && curr.val == next.val) || duplicateSeen.contains(curr.val)) {
                if(prev != null){
                    prev.next = next;
                }
                duplicateSeen.add(curr.val);
            }else {
                if(prev==null){
                    head =curr;
                }
                prev = curr;
            }
            curr = next;
        }
        if (prev==null){
            return null;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode curr=head;
        while(curr!=null) {
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println();
    }
}
