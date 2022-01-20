package com.rau.leetcode.easy;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        ListNode result = reverseList(l);
        while (result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev=null, curr = head, next=null;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;}
        return prev;
    }
}
